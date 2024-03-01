package com.consultas.SistemaConsultas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.ExpedienteJuzgadosRest;
import com.consultas.SistemaConsultas.Response.ConsultasResponse;
import com.consultas.SistemaConsultas.services.ExpedienteJuzgadoService;

@RestController
@RequestMapping(path = "/Sistema-Consultas" + "/v1")
public class expedienteJuzgadosControllers {

	@Autowired
	ExpedienteJuzgadoService expedientesJuzgadosService;	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "expedientejuzgados", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultasResponse<List<ExpedienteJuzgadosRest>> getExpedienteJuzgados()throws ConsultasExceptions{		
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				expedientesJuzgadosService.getExpedientesJuzgados());
	}
}
