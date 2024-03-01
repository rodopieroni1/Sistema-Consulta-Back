package com.consultas.SistemaConsultas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.ExpedientesRest;
import com.consultas.SistemaConsultas.Response.ConsultasResponse;
import com.consultas.SistemaConsultas.services.ExpedientesService;

@RestController
@RequestMapping(path = "/Sistema-Consultas" + "/v1")
public class expedientesControllers {
	@Autowired
	ExpedientesService expedientesService;

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) 
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "expedientes" + "/{" + "expedientesId"+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultasResponse<ExpedientesRest> getExpedientesById(@PathVariable Long expedientesId) throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				expedientesService.getExpedienteById(expedientesId));
	}
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) 
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/expedientes")
	public ConsultasResponse<List<ExpedientesRest>> getExpedientes()throws ConsultasExceptions{		
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				expedientesService.getExpedientes());
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "expedientesNumExp" + "/{"+"expedientesNumExp"+"}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultasResponse<ExpedientesRest> getExpedienteByNumExp(@PathVariable String expedientesNumExp) throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				expedientesService.getExpedientesByNumExp(expedientesNumExp));
	}
	
	
	
}
