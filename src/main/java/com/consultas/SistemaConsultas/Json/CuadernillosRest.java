package com.consultas.SistemaConsultas.Json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CuadernillosRest {
	
	@JsonProperty("idCuadernillo")
	private Long idCuadernillo;
	
	@JsonProperty("denominacionCuadernillo")
	private String denominacionCuadernillo;
	
	@JsonProperty("tipoCuadernillo")
	private String tipoCuadernillo;
	
	@JsonProperty("fechaCuadernillo")
	private Date fechaCuadernillo;
	
	@JsonProperty("idExpediente")
	private Long idExpediente;
	
	public Long getIdCuadernillo() {
		return idCuadernillo;
	}

	public void setIdCuadernillo(Long idCuadernillo) {
		this.idCuadernillo = idCuadernillo;
	}

	public String getTipoCuadernillo() {
		return tipoCuadernillo;
	}

	public void setTipoCuadernillo(String tipoCuadernillo) {
		this.tipoCuadernillo = tipoCuadernillo;
	}	

	public Date getFechaCuadernillo() {
		return fechaCuadernillo;
	}

	public void setFechaCuadernillo(Date fechaCuadernillo) {
		this.fechaCuadernillo = fechaCuadernillo;
	}

	public String getDenominacionCuadernillo() {
		return denominacionCuadernillo;
	}

	public void setDenominacionCuadernillo(String denominacionCuadernillo) {
		this.denominacionCuadernillo = denominacionCuadernillo;
	}

	public Long getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(Long idExpediente) {
		this.idExpediente = idExpediente;
	}

	
}
