package com.consultas.SistemaConsultas.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@Column(unique=true, length= 20)
	private String nombreUsuario;
	
	@Column(length= 100)
	private String password;
	
	@Column(length= 65)
	private String email;
	
	private Boolean habilitado;
	
	@Column(length= 100)
	private String token;
	
	@ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="usuario_roles",
	joinColumns = @JoinColumn(name="usuario_id"), 
	inverseJoinColumns=@JoinColumn(name="role_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
	private List<Roles> roles;

	public long getId() {
		return idUsuario;
	}

	public void setId(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
