package com.consultas.SistemaConsultas.entities;

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
@Table(name = "JUZGADOS")
public class Juzgados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDJUZGADOS", unique = true, nullable = false)
	private Long idJuzgados;
	
	@Column(name = "DENOMINACIONJUZGADOS")
	private String denominacionJuzgados;

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "juzgados")
	private List<ExpedientesJuzgados> idExpedientesJuzgados;*/
	
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

	/*public List<ExpedientesJuzgados> getIdExpedientesJuzgados() {
		return idExpedientesJuzgados;
	}

	public void setIdExpedientesJuzgados(List<ExpedientesJuzgados> idExpedientesJuzgados) {
		this.idExpedientesJuzgados = idExpedientesJuzgados;
	}
*/
}
