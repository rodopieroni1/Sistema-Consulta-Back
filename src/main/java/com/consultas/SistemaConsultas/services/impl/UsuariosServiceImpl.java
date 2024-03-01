package com.consultas.SistemaConsultas.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.consultas.SistemaConsultas.Auth.MailConfiguration;
import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Exceptions.InternalServerError;
import com.consultas.SistemaConsultas.Exceptions.NotFoundExceptions;
import com.consultas.SistemaConsultas.Json.CreateUsuariosRest;

import com.consultas.SistemaConsultas.entities.Usuario;
import com.consultas.SistemaConsultas.repositories.UsuariosRepo;
import com.consultas.SistemaConsultas.services.UsuarioService;
import com.password4j.Hash;
import com.password4j.Password;

@Service
public class UsuariosServiceImpl implements UserDetailsService, UsuarioService {
	private static final Logger LOGGER = LoggerFactory.getLogger(JuzgadosServiceImpl.class);
	public static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	UsuariosRepo usuariosRepo;

	MailConfiguration mailConfiguration;

	public UsuariosServiceImpl(MailConfiguration mailConfiguration) {
		this.mailConfiguration = mailConfiguration;
	}

	@ResponseStatus(HttpStatus.OK)
	public String createUsuario(CreateUsuariosRest createUsuarioRest) throws InternalServerError {
		final Usuario usuarios = new Usuario();
		final String token = generarToken();
		usuarios.setNombreUsuario(createUsuarioRest.getNombreUsuario());
		usuarios.setEmail(createUsuarioRest.getEmail());
		String PasswordEncriptado = encriptar(createUsuarioRest.getPassword());
		usuarios.setPassword(PasswordEncriptado);
		usuarios.setToken(token);
		usuarios.setHabilitado(false);
		try {
			if (usuariosRepo.existsByEmail(createUsuarioRest.getEmail(), createUsuarioRest.getNombreUsuario())) {
				return "Usuario ingresado dos veces";
			} else {
				mailConfiguration.sendMessage(createUsuarioRest.getEmail(), token,
						createUsuarioRest.getNombreUsuario());
				usuariosRepo.save(usuarios);
				return "Usuario ingresado correctamente";
			}
		} catch (final Exception e) {
			LOGGER.error("Error en UsuarioS", e);
			throw new IllegalArgumentException(e);
		}
	}

	// encripta una contraseña utilizando el algorito pdkf2
	private String encriptar(String password) {
		Hash hash = Password.hash(password).withBcrypt();
		return hash.getResult();
	}

	// generar token
	public String generarToken() {
		String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String token = "";
		for (int x = 0; x < banco.length(); x++) {
			int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, banco.length() - 1);
			char caracterAleatorio = banco.charAt(indiceAleatorio);
			token += caracterAleatorio;
		}
		return token;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = this.usuariosRepo.findByNombreUsuario(username);
		if (usuario == null) {
			LOGGER.error("Error, el usuario no existe");
			throw new UsernameNotFoundException("Error, el usuario no existe");
		}
		List<GrantedAuthority> authorities = usuario.getRoles()// devuelve una lista e roles, pero nosotros necesitamos
																// que nos devuelva una lista de GratesAuthorities
				.stream()// inidca que vamos a trabaja con un flujo de datos y que los vamos a
							// transformar
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))// lo vamos a transformar con el metodo map a
																			// un conjunto de roles
				.peek(authority -> LOGGER.info("Role: " + authority.getAuthority()))// imprime todos los autorities que
																					// va
																					// encontrando
				.collect(Collectors.toList());// devuelve una coleccion
		return new User(usuario.getNombreUsuario(), usuario.getPassword(), usuario.getHabilitado(), true, true, true,
				authorities);
	}

	// Busqueda por id, y token para confirmacion
	public CreateUsuariosRest getUsuarioByToken(String token) throws ConsultasExceptions {
		return modelMapper.map(getUsuarioEntityToken(token), CreateUsuariosRest.class);
	}

	public Usuario getUsuarioEntityToken(String token) throws ConsultasExceptions {
		Long id = null;
		try {
			if (!(token).isEmpty()) {
				Optional<Usuario> usuarioFinal = usuariosRepo.findByToken(token);
				System.out.println("Aqui esta el problema: " + usuarioFinal);
				id = usuarioFinal.get().getId();
				if (!(usuariosRepo.findByToken(token)).isEmpty()) {
					usuariosRepo.updateByToken(token);
					return usuariosRepo.findById(id).orElseThrow(() -> new NotFoundExceptions("SNOT-404-1", "USUARIO_NOT_FOUND"));

				}
			}else {
				return usuariosRepo.findById(id).orElseThrow(() -> new NotFoundExceptions("SNOT-404-1", "USUARIO_NOT_FOUND"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@ResponseStatus(HttpStatus.OK)
	public String autenticarUsuario(CreateUsuariosRest createUsuariosRest) throws ConsultasExceptions {
		String email = createUsuariosRest.getEmail();
		String password = createUsuariosRest.getPassword();
		Usuario usuario = usuariosRepo.findByEmail(email);
		// Usuario usuario = usuariosRepo.findByPassword(password);
		System.out.println("Pass formu " + password + "pass BD: " + usuario.getPassword());
		boolean hash = BCrypt.checkpw(password, usuario.getPassword());
		if (hash) {
			return "USUARIO_AUTENTICADO";
		} else {
			return "USUARIO_NOT_FOUND";
		}
	}

}
