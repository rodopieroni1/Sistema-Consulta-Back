package com.consultas.SistemaConsultas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Exceptions.NotFoundExceptions;
import com.consultas.SistemaConsultas.Json.CreateExpedientesRest;
import com.consultas.SistemaConsultas.Json.ExpedientesRest;

import com.consultas.SistemaConsultas.entities.Expedientes;
import com.consultas.SistemaConsultas.repositories.CuadernillosRepo;
import com.consultas.SistemaConsultas.repositories.EscritosRepo;
import com.consultas.SistemaConsultas.repositories.ExpedientesRepo;
import com.consultas.SistemaConsultas.repositories.JuzgadosRepo;
import com.consultas.SistemaConsultas.services.ExpedientesService;

@Service
public class ExpedientesServiceImpl implements ExpedientesService {	
	@Autowired
	JuzgadosRepo juzgadosRepo;
	/*@Autowired
	ExpedientesJuzgadosRepo expedientesJuzgadosRepo;*/
	@Autowired
	ExpedientesRepo expedientesRepo;
	@Autowired
	CuadernillosRepo cuadernillosRepo;
	@Autowired
	EscritosRepo escritosRepo;

	public static final ModelMapper modelMapper = new ModelMapper();

	

	public List<ExpedientesRest> getExpedientes() throws ConsultasExceptions {
		final List<Expedientes> expedientesEntity = expedientesRepo.findAll();
		return expedientesEntity.stream().map(service -> modelMapper.map(service, ExpedientesRest.class))
				.collect(Collectors.toList());
		// stream recorre todo la lista expedientesEntity
	}

	public ExpedientesRest getExpedienteById(Long idExpediente) throws ConsultasExceptions {
		return modelMapper.map(getExpedienteEntity(idExpediente), ExpedientesRest.class);
		// mapear la entidad Expediente a la clase ExpedienteRest
	}
	
	public ExpedientesRest getExpedientesByNumExp(String NumExpediente) throws ConsultasExceptions {
		return modelMapper.map(getExpedienteEntityNumExp(NumExpediente), ExpedientesRest.class);
		
		// mapear la entidad Expediente a la clase ExpedienteRest
	}
	
	public Expedientes getExpedienteEntityNumExp(String NumExpediente) throws ConsultasExceptions {
		return expedientesRepo.findByNumExpediente(NumExpediente)
				.orElseThrow(() -> new NotFoundExceptions("SNOT-404-1", "EXPEDIENTE_NOT_FOUND"));
	}
	public Expedientes getExpedienteEntity(Long idExpediente) throws ConsultasExceptions {
		return expedientesRepo.findById(idExpediente).orElseThrow(() -> new NotFoundExceptions("SNOT-404-1", "EXPEDIENTE_NOT_FOUND"));
	}

	@Override
	public void CreateExpediente(CreateExpedientesRest createExpedientesRest) throws ConsultasExceptions {
		//final List<ExpedientesJuzgados> juzgadosId = expedientesJuzgadosRepo
			//	.findById(createExpedientesRest.getIdJuzgadosExpedientes());
		// String numExpediente = generarNumExpediente(juzgadosId,
		// createExpedientesRest);

		final Expedientes expediente = new Expedientes();
		expediente.setCaratula(createExpedientesRest.getCaratula());
		expediente.setFechaExpediente(createExpedientesRest.getFechaExpediente());
		expediente.setMovimientoExpediente(createExpedientesRest.getMovimientoExpediente());
		expediente.setNumExpediente(createExpedientesRest.getNumExpediente());
		expediente.setSegundaInstancia(createExpedientesRest.getSegundaInstancia());
		//expediente.setExpedientesJuzgados(juzgadosId);
	}

	
}
