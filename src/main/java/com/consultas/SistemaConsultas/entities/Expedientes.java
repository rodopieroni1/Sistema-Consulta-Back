package com.consultas.SistemaConsultas.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EXPEDIENTES")
public class Expedientes {

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "IDEXPEDIENTE", unique = true, nullable = false)
			private Long idExpediente;
			
			@Column(name = "NUMEXPEDIENTE")
			private String numExpediente;
			
			@Column(name = "FECHAEXPEDIENTE")
			private Date fechaExpediente ;
			
			@Column(name = "MOVIMIENTOEXPEDIENTE")
			private String movimientoExpediente;
			
			@Column(name = "CARATULA")
			private String caratula;
			
			@Column(name = "SEGUNDAINSTANCIA")
			private String segundaInstancia;
			
			@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "expedientes")
			private List<ExpedientesJuzgados> idExpedientesJuzgados;
			
			@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "expedientes")
			private List<ExpedientesClientes> idExpedientesClientes;
			
			
			
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

			public List<ExpedientesJuzgados> getIdExpedientesJuzgados() {
				return idExpedientesJuzgados;
			}

			public void setIdExpedientesJuzgados(List<ExpedientesJuzgados> idExpedientesJuzgados) {
				this.idExpedientesJuzgados = idExpedientesJuzgados;
			}

	

}
