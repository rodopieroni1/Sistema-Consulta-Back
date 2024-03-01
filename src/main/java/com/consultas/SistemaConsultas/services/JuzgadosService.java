package com.consultas.SistemaConsultas.services;

import org.springframework.stereotype.Service;
import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.CreateJuzgadosRest;
import com.consultas.SistemaConsultas.Json.JuzgadosRest;
import com.consultas.SistemaConsultas.entities.Juzgados;
@Service
public interface JuzgadosService {
	String createJuzgados(CreateJuzgadosRest createJuzgadosRest) throws ConsultasExceptions;
	JuzgadosRest getJuzgadosByid(Long idJuzgados) throws ConsultasExceptions;	
	JuzgadosRest getJuzgadosBydenominacion(String denominacionJuzgados) throws ConsultasExceptions;	
	JuzgadosRest deleteJuzgadosByDenominacion(String denominacionJuzgados) throws ConsultasExceptions;
	String updateJuzgados(Juzgados juzgados, Long idJuzgados)throws ConsultasExceptions;
}
