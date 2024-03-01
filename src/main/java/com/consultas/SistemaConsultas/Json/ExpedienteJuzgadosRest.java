package com.consultas.SistemaConsultas.Json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpedienteJuzgadosRest {
	
	@JsonProperty("idExpedientesJuzgados")
	private Long idExpedientesJuzgados;

	@JsonProperty("idExpediente")
	private Long idExpediente;
	
	@JsonProperty("idJuzgados")
	private Long idJuzgados;

	public Long getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(Long idExpediente) {
		this.idExpediente = idExpediente;
	}

	public Long getIdExpedientesJuzgados() {
		return idExpedientesJuzgados;
	}

	public void setIdExpedientesJuzgados(Long idExpedientesJuzgados) {
		this.idExpedientesJuzgados = idExpedientesJuzgados;
	}

	public Long getIdJuzgados() {
		return idJuzgados;
	}

	public void setIdJuzgados(Long idJuzgados) {
		this.idJuzgados = idJuzgados;
	}	
}
