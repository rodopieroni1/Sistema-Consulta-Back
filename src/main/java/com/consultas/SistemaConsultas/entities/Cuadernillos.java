package com.consultas.SistemaConsultas.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUADERNILLOS")
public class Cuadernillos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCUADERNILLO", unique = true, nullable = false)
	private Long idCuadernillo;
	
	@Column(name = "TIPOCUADERNILLO")
	private String tipoCuadernillo;
	
	@Column(name = "MOVIMIENTOCUADERNILLO")
	private String movimientoCuadernillo;
	
	@Column(name = "FECHACUADERNILLO")
	private Date fechaCuadernillo;
	
	@Column(name = "DENOMINACIONCUADERNILLO")
	private String denominacionCuadernillo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IDEXPEDIENTE", nullable = false)
	private Expedientes idexpediente;


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

	public Date getFechaCuadernillo() {
		return fechaCuadernillo;
	}

	public void setFechaCuadernillo(Date fechaCuadernillo) {
		this.fechaCuadernillo = fechaCuadernillo;
	}

	public Expedientes getIdexpediente() {
		return idexpediente;
	}

	public void setIdexpediente(Expedientes idexpediente) {
		this.idexpediente = idexpediente;
	}


	
}
