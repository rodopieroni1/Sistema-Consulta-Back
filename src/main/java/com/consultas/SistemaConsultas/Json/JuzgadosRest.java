package com.consultas.SistemaConsultas.Json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//estos Json son los encargados de devolver estos parametros al front
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JuzgadosRest {
	
	@JsonProperty("idJuzgados")
	private Long idJuzgados;
	
	@JsonProperty("denominacionJuzgados")
	private String denominacionJuzgados;
	
	public Long getIdJuzgados() {
		return idJuzgados;
	}

	public void setIdJuzgados(Long idJuzgados) {
		this.idJuzgados = idJuzgados;
	}

	public String getDenominacionJuzgados() {
		return denominacionJuzgados;
	}

	public void setDenominacionJuzgados(String denominacionJuzgados) {
		this.denominacionJuzgados = denominacionJuzgados;
	}

}
