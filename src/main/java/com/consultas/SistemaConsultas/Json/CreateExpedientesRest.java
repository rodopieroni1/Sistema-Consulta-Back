package com.consultas.SistemaConsultas.Json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateExpedientesRest {
	@JsonProperty("idExpediente")
	private Long idExpediente;
	
	@JsonProperty("numExpediente")
	private String numExpediente;
	
	@JsonProperty("fechaExpediente")
	private Date fechaExpediente ;
	
	@JsonProperty("movimientoExpediente")
	private String movimientoExpediente;
	
	@JsonProperty("caratula")
	private String caratula;
	
	@JsonProperty("segundaInstancia")
	private String segundaInstancia;
	
	public Long getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(Long idExpediente) {
		this.idExpediente = idExpediente;
	}

	public String getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(String numExpediente) {
		this.numExpediente = numExpediente;
	}

	public Date getFechaExpediente() {
		return fechaExpediente;
	}

	public void setFechaExpediente(Date fechaExpediente) {
		this.fechaExpediente = fechaExpediente;
	}

	public String getMovimientoExpediente() {
		return movimientoExpediente;
	}

	public void setMovimientoExpediente(String movimientoExpediente) {
		this.movimientoExpediente = movimientoExpediente;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public String getSegundaInstancia() {
		return segundaInstancia;
	}

	public void setSegundaInstancia(String segundaInstancia) {
		this.segundaInstancia = segundaInstancia;
	}

}
