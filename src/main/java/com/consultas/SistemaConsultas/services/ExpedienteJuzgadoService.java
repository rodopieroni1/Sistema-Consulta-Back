package com.consultas.SistemaConsultas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.consultas.SistemaConsultas.Exceptions.ConsultasExceptions;
import com.consultas.SistemaConsultas.Json.ExpedienteJuzgadosRest;

@Service
public interface ExpedienteJuzgadoService {
	ExpedienteJuzgadosRest getExpeJuzgadosById(Long idExpedienteJuzgados) throws ConsultasExceptions;
	public List<ExpedienteJuzgadosRest> getExpedientesJuzgados() throws ConsultasExceptions;

}
