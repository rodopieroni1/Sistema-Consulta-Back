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
@Table(name = "ESCRITOS")
public class Escritos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDESCRITOS", unique = true, nullable = false)
	private Long idEscritos;
	
	@Column(name = "DESCRIPCIONESCRITOS")
	private String descripcionEscritos;
	
	@Column(name = "TITULOESCRITOS")
	private String tituloEscritos;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IDEXPEDIENTE", nullable = false)
	private Expedientes idexpedientes;

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

	public Expedientes getIdexpedientes() {
		return idexpedientes;
	}

	public void setIdexpedientes(Expedientes idexpedientes) {
		this.idexpedientes = idexpedientes;
	}

}
