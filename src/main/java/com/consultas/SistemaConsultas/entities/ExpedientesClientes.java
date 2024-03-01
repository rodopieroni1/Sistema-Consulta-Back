package com.consultas.SistemaConsultas.entities;

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
@Table(name = "EXPEDIENTESCLIENTES")
public class ExpedientesClientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDEXPEDIENTESCLIENTES", unique = true, nullable = false)
	private Long idExpedientesClientes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDEXPEDIENTE", nullable = false)
	private Expedientes expedientes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCLIENTE", nullable = false)
	private Clientes clientes;
	
	public Expedientes getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(Expedientes expedientes) {
		this.expedientes = expedientes;
	}

	public Long getIdExpedientesClientes() {
		return idExpedientesClientes;
	}

	public void setIdExpedientesClientes(Long idExpedientesClientes) {
		this.idExpedientesClientes = idExpedientesClientes;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
}
