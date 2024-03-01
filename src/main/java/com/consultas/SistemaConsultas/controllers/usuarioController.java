package com.consultas.SistemaConsultas.controllers;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.CreateUsuariosRest;
import com.consultas.SistemaConsultas.Response.ConsultasResponse;
import com.consultas.SistemaConsultas.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Sistema-Consultas" + "/v1")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class usuarioController {
		
	@Autowired
	UsuarioService usuariosService;
	
	@ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/crearUsuario")
	public ConsultasResponse<String> createUsuarios(@RequestBody CreateUsuariosRest createUsuariosRest)
			throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				usuariosService.createUsuario(createUsuariosRest));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/confirmar"+"/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultasResponse<CreateUsuariosRest> confirmarUsuarios(@PathVariable String token)
			throws ConsultasExceptions {
		return new ConsultasResponse<CreateUsuariosRest>("Succes", String.valueOf(HttpStatus.OK), "OK",
				usuariosService.getUsuarioByToken(token));		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/autenticar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultasResponse<String> autenticarUsuarios(@RequestBody CreateUsuariosRest createUsuariosRest)
			throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				usuariosService.autenticarUsuario(createUsuariosRest));		
	}
	
}
