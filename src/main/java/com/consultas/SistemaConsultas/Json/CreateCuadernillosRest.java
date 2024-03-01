package com.consultas.SistemaConsultas.Json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCuadernillosRest {
	
	@JsonProperty("idCuadernillo")
	private Long idCuadernillo;
	
	@JsonProperty("movimientoCuadernillo")
	private String movimientoCuadernillo;
	
	@JsonProperty("tipoCuadernillo")
	private String tipoCuadernillo;
	
	@JsonProperty("fechaCuadernillo")
	private Date fechaCuadernillo;
	
	@JsonProperty("denominacionCuadernillo")
	private String denominacionCuadernillo;
		
	@JsonProperty("idExpediente")
	private Long idExpediente;

	public Long getIdCuadernillo() {
		return idCuadernillo;
	}

	public void setIdCuadernillo(Long idCuadernillo) {
		this.idCuadernillo = idCuadernillo;
	}

	
	public String getMovimientoCuadernillo() {
		return movimientoCuadernillo;
	}

	public void setMovimientoCuadernillo(String movimientoCuadernillo) {
		this.movimientoCuadernillo = movimientoCuadernillo;
	}

	public String getDenominacionCuadernillo() {
		return denominacionCuadernillo;
	}

	public void setDenominacionCuadernillo(String denominacionCuadernillo) {
		this.denominacionCuadernillo = denominacionCuadernillo;
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

	public Long getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(Long idExpediente) {
		this.idExpediente = idExpediente;
	}

}
