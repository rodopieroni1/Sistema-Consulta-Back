package com.consultas.SistemaConsultas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCLIENTE", unique = true, nullable = false)
	private Long idCliente;
	
	@Column(name = "NOMBRECLIENTE")
	private String nombreCliente;
	
	@Column(name = "DNICLIENTE")
	private Long dniClinete;
	
	@Column(name = "DIRECCIONCLIENTE")
	private String direccionCliente;	
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public Long getDniClinete() {
		return dniClinete;
	}
	public void setDniClinete(Long dniClinete) {
		this.dniClinete = dniClinete;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

}
