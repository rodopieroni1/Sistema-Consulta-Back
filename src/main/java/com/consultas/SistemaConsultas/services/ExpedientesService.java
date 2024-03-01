package com.consultas.SistemaConsultas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.CreateExpedientesRest;
import com.consultas.SistemaConsultas.Json.ExpedientesRest;

@Service
public interface ExpedientesService {

	ExpedientesRest getExpedienteById(Long idExpediente) throws ConsultasExceptions;
	ExpedientesRest getExpedientesByNumExp(String expedientesNumExp) throws ConsultasExceptions;

	public List<ExpedientesRest> getExpedientes() throws ConsultasExceptions;
	void CreateExpediente(CreateExpedientesRest createExpedientesRest) throws ConsultasExceptions;

}
