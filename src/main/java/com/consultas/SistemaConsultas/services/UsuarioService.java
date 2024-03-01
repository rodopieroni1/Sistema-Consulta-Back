package com.consultas.SistemaConsultas.services;

import org.springframework.stereotype.Service;
import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.CreateUsuariosRest;

@Service
public interface UsuarioService {
	String createUsuario(CreateUsuariosRest createUsuariosRest ) throws ConsultasExceptions;
	CreateUsuariosRest getUsuarioByToken(String token) throws ConsultasExceptions;
	String autenticarUsuario(CreateUsuariosRest createUsuariosRest)throws ConsultasExceptions;

}
