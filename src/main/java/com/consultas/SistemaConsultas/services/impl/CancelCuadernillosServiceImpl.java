package com.consultas.SistemaConsultas.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Exceptions.InternalServerError;
import com.consultas.SistemaConsultas.Exceptions.NotFoundExceptions;
import com.consultas.SistemaConsultas.Json.CreateCuadernillosRest;
import com.consultas.SistemaConsultas.Json.CuadernillosRest;
import com.consultas.SistemaConsultas.entities.Cuadernillos;
import com.consultas.SistemaConsultas.repositories.CuadernillosRepo;
import com.consultas.SistemaConsultas.services.CancelCuadernillosService;
import com.consultas.SistemaConsultas.services.CuadernillosService;

@Service
public class CancelCuadernillosServiceImpl implements CancelCuadernillosService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CancelCuadernillosServiceImpl.class);
	@Autowired
	private CuadernillosRepo cuadernillosRepo;

	@Override
	public String deleteCuadernillos(String denominacionCuadernillo) throws ConsultasExceptions {
		cuadernillosRepo.findByDenominacionCuadernillo(denominacionCuadernillo)
				.orElseThrow(() -> new NotFoundExceptions("CUADERNILLOS_NOT_FOUND", "CUADERNILLOS_NOT_FOUND"));
	try {
		cuadernillosRepo.deleteBydenominacionCuadernillo(denominacionCuadernillo);
	} catch (Exception e) {
		LOGGER.error("INTERNAL_SERVER_ERROR", e);
		throw new InternalServerError("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
	}
		
		return "ESCRITO_DELETES";
	}	

}
