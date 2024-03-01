package com.consultas.SistemaConsultas.services;

import org.springframework.stereotype.Service;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.CreateEscritosRest;
import com.consultas.SistemaConsultas.entities.Escritos;

@Service
public interface EscritosService{
	String crearEscritos(CreateEscritosRest createEscritosRest) throws ConsultasExceptions;
	String updateEscritos(Escritos escritos, Long idEscritos) throws ConsultasExceptions;
	String deleteEscritos(Escritos escritos, Long idEscritos) throws ConsultasExceptions;
}
