package com.consultas.SistemaConsultas.repositories;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.consultas.SistemaConsultas.entities.Usuario;

@Repository
public interface UsuariosRepo extends CrudRepository<Usuario, Long> {
	
	public Usuario findByNombreUsuario(String nombreUsuario);
	
	@Query("select u from Usuario u where u.nombreUsuario=?1")
	public Usuario findByIdUsuarioV2(String nombreUsuario);
	
	@Query("select u from Usuario u where u.token = :token")
	public Optional<Usuario> findByToken(String token);
	
	@Query("select u from Usuario u where u.id = :id")
	public Optional<Usuario> findById(Long id);
	
	@Query("select u from Usuario u where u.email = :email")
	public Usuario findByEmail(String email);
	
	@Query("select u from Usuario u where u.password = :password")
	public Usuario findByPassword(String password);
	
	
	@Modifying
	@Transactional
	@Query("update Usuario u Set u.habilitado = true, u.token = null where u.token = :token")
	public void updateByToken(String token);
	
	@Query("select case when( count(u)>0) then true else false end from Usuario u  where u.email= :email and u.nombreUsuario= :nombreUsuario")
	public boolean existsByEmail(String email, String nombreUsuario);

}
