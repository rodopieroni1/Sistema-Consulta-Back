package com.consultas.SistemaConsultas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Exceptions.NotFoundExceptions;
import com.consultas.SistemaConsultas.Json.ExpedienteJuzgadosRest;
import com.consultas.SistemaConsultas.entities.ExpedientesJuzgados;
import com.consultas.SistemaConsultas.repositories.ExpedientesJuzgadosRepo;
import com.consultas.SistemaConsultas.services.ExpedienteJuzgadoService;
@Service
public class ExpedienteJuzgadosServiceImpl implements ExpedienteJuzgadoService{
	
	public static final ModelMapper modelMapper = new ModelMapper();
	@Autowired
	ExpedientesJuzgadosRepo expedientesJuzgadoRepo;	

	@Override
	public ExpedienteJuzgadosRest getExpeJuzgadosById(Long idExpedienteJuzgados) throws ConsultasExceptions {
		return modelMapper.map(getExpedienteJuzgadosEntity(idExpedienteJuzgados), ExpedienteJuzgadosRest.class); 
	}
	
	public ExpedientesJuzgados getExpedienteJuzgadosEntity(Long idExpedienteJuzgados) throws ConsultasExceptions {
		return expedientesJuzgadoRepo.findById(idExpedienteJuzgados)
				.orElseThrow(() -> new NotFoundExceptions("SNOT-404-1", "EXPEDIENTE_JUZGADOS_NOT_FOUND"));
	}
	
	@Override
	public List<ExpedienteJuzgadosRest> getExpedientesJuzgados() throws ConsultasExceptions {
		final List<ExpedientesJuzgados> expedientesJuzgadosEntity = expedientesJuzgadoRepo.findAll();
		return expedientesJuzgadosEntity.stream().map(service -> modelMapper.map(service, ExpedienteJuzgadosRest.class))
				.collect(Collectors.toList());
		}
	
	
}
