package com.consultas.SistemaConsultas.services;

import org.springframework.stereotype.Service;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.CreateCuadernillosRest;
import com.consultas.SistemaConsultas.Json.CuadernillosRest;
import com.consultas.SistemaConsultas.entities.Cuadernillos;

@Service
public interface CuadernillosService {
	String createCuadernillos(CreateCuadernillosRest createCuadernillosRest ) throws ConsultasExceptions;
	String updateJuzgados(Cuadernillos cuadernillos, Long idCuadernillos) throws ConsultasExceptions;
	CuadernillosRest getCuadernillosByDenominacion(String denominacionCuadernillos) throws ConsultasExceptions;
	CuadernillosRest getCuadernillosById (Long idCuadernillos) throws ConsultasExceptions;
	CuadernillosRest deleteCuadernillosByDenominacion(String denominacionCuadernillos);
	String deleteCuadernillos(String denominacionCuadernillo)throws ConsultasExceptions;

}
