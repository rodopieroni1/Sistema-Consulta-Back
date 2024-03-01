package com.consultas.SistemaConsultas.Json;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EscritosRest {

	@JsonProperty("idEscritos")
	private Long idEscritos;
	
	@JsonProperty("descripcionEscritos")
	private String descripcionEscritos;
	
	@JsonProperty("tituloEscritos")
	private String tituloEscritos;
	
	@JsonProperty("idExpediente")
	private Long idExpediente;
	
	public Long getIdEscritos() {
		return idEscritos;
	}

	public void setIdEscritos(Long idEscritos) {
		this.idEscritos = idEscritos;
	}

	public String getDescripcionEscritos() {
		return descripcionEscritos;
	}

	public void setDescripcionEscritos(String descripcionEscritos) {
		this.descripcionEscritos = descripcionEscritos;
	}

	public String getTituloEscritos() {
		return tituloEscritos;
	}

	public void setTituloEscritos(String tituloEscritos) {
		this.tituloEscritos = tituloEscritos;
	}

	public Long getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(Long idExpediente) {
		this.idExpediente = idExpediente;
	}

}
