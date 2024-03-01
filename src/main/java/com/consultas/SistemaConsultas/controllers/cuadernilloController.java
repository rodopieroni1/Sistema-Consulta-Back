package com.consultas.SistemaConsultas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.CreateCuadernillosRest;
import com.consultas.SistemaConsultas.Json.CuadernillosRest;
import com.consultas.SistemaConsultas.Response.ConsultasResponse;
import com.consultas.SistemaConsultas.entities.Cuadernillos;
import com.consultas.SistemaConsultas.services.CuadernillosService;

@RestController
@RequestMapping(path = "/Sistema-Consultas" + "/v1")
public class cuadernilloController {
	public static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	CuadernillosService cuadernillosService; 
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/createCuadernillos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultasResponse<String> createCuadernillos(@RequestBody CreateCuadernillosRest createCuadernillosRest)
			throws ConsultasExceptions {		
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				cuadernillosService.createCuadernillos(createCuadernillosRest));
	}
	

	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/updateCuadernillos"+"/{" + "idCuadernillos"+ "}")
	public ConsultasResponse<String> updateCuadernillos(@RequestBody Cuadernillos cuadernillos, @RequestParam Long idCuadernillos) throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", cuadernillosService.updateJuzgados(cuadernillos, idCuadernillos));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/getCuadernillos"+"/{"+"idCuadernillos"+"}")
	public ConsultasResponse<CuadernillosRest> getCuadernillosByid(@RequestParam Long idCuadernillos)throws ConsultasExceptions{		
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", 
				cuadernillosService.getCuadernillosById(idCuadernillos));		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/getCuadernillosDenominacion"+"/{"+"denominacionCuadernillos"+"}")
	public ConsultasResponse<CuadernillosRest> getCuadernillosByDenominacion(@RequestParam String denominacionCuadernillos)throws ConsultasExceptions{		
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", cuadernillosService.getCuadernillosByDenominacion(denominacionCuadernillos));		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/eliminarCuadernillosByDenominacion"+"/{"+"denominacionCuadernillos"+"}")
	public ConsultasResponse<CuadernillosRest> deleteCuadernillosByDenominacion(@RequestParam String denominacionCuadernillos)throws ConsultasExceptions{		
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", cuadernillosService.deleteCuadernillosByDenominacion(denominacionCuadernillos));		
	}

}
