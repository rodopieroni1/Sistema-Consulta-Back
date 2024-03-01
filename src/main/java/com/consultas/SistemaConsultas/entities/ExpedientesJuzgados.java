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
@Table(name = "EXPEDIENTESJUZGADOS")
public class ExpedientesJuzgados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDEXPEDIENTESJUZGADOS", unique = true, nullable = false)
	private Long idExpedientesJuzgados;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDEXPEDIENTE", nullable = false)
	private Expedientes expedientes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDJUZGADOS", nullable = false)
	private Juzgados juzgados;
	
	public Long getIdExpedientesJuzgados() {
		return idExpedientesJuzgados;
	}

	public void setIdExpedientesJuzgados(Long idExpedientesJuzgados) {
		this.idExpedientesJuzgados = idExpedientesJuzgados;
	}

	public Expedientes getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(Expedientes expedientes) {
		this.expedientes = expedientes;
	}

	public Juzgados getJuzgados() {
		return juzgados;
	}

	public void setJuzgados(Juzgados juzgados) {
		this.juzgados = juzgados;
	}
	
}
