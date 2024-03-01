package com.consultas.SistemaConsultas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.CreateEscritosRest;
import com.consultas.SistemaConsultas.Response.ConsultasResponse;
import com.consultas.SistemaConsultas.entities.Escritos;
import com.consultas.SistemaConsultas.services.EscritosService;

@RestController
@RequestMapping(path = "/Sistema-Consultas" + "/v1")
public class escritosController {
	
	@Autowired
	EscritosService escritosService;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/createEscritos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultasResponse<String> createEscritos(@RequestBody CreateEscritosRest createEscritosRest)
			throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				escritosService.crearEscritos(createEscritosRest));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/updateEscritos"+"/{" + "idEscritos"+ "}")
	public ConsultasResponse<String> updateEscritos(@RequestBody Escritos escritos, @RequestParam Long idEscritos) throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				escritosService.updateEscritos(escritos, idEscritos));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/deleteEscritos"+"/{" + "idEscritos"+ "}")
	public ConsultasResponse<String> deleteEscritos(@RequestBody Escritos escritos, @RequestParam Long idEscritos) throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				escritosService.deleteEscritos(escritos, idEscritos));
	}
	
}
