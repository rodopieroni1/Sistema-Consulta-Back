package com.consultas.SistemaConsultas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.CreateJuzgadosRest;
import com.consultas.SistemaConsultas.Json.JuzgadosRest;
import com.consultas.SistemaConsultas.Response.ConsultasResponse;
import com.consultas.SistemaConsultas.entities.Juzgados;
import com.consultas.SistemaConsultas.services.JuzgadosService;

@RestController
@RequestMapping(path = "/Sistema-Consultas" + "/v1")
public class juzgadosControllers {

	@Autowired
	JuzgadosService juzgadosService;

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/createJuzgados", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultasResponse<String> createJuzgados(@RequestBody CreateJuzgadosRest createJuzgadosRest)
			throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				juzgadosService.createJuzgados(createJuzgadosRest));
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/updateJuzgados" + "/{" + "idJuzgados" + "}")
	public ConsultasResponse<String> updateJuzgados(@RequestBody Juzgados juzgados, @RequestParam Long idJuzgados)
			throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				juzgadosService.updateJuzgados(juzgados, idJuzgados));
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/getJuzgados" + "/{" + "idJuzgados" + "}")
	public ConsultasResponse<JuzgadosRest> getJuzgadosByid(@RequestParam Long idJuzgados) throws ConsultasExceptions {
		System.out.println("idJuzgados"+ idJuzgados);
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				juzgadosService.getJuzgadosByid(idJuzgados));
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/getJuzgadosDenominacion" + "/{" + "denominacionJuzgados" + "}")
	public ConsultasResponse<JuzgadosRest> getJuzgadosByDenominacion(@RequestParam String denominacionJuzgados)
			throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				juzgadosService.getJuzgadosBydenominacion(denominacionJuzgados));
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/eliminarJuzgadoByDenominacion" + "/{" + "denominacionJuzgados" + "}")
	public ConsultasResponse<JuzgadosRest> deleteJuzgadosByDenominacion(@RequestParam String denominacionJuzgados)
			throws ConsultasExceptions {
		return new ConsultasResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				juzgadosService.deleteJuzgadosByDenominacion(denominacionJuzgados));
	}

}
