package com.consultas.SistemaConsultas.services;

import org.springframework.stereotype.Service;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;

@Service
public interface CancelCuadernillosService {
	
	public String deleteCuadernillos(String denominacionCuadernillo)throws ConsultasExceptions;

}
