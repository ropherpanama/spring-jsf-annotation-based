package com.web.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = -7349089919081820667L;
	@Id
	@Column(name = "usuario_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer usuarioId;
	@Column(name = "login")
	private String username;
	@Column(name = "password")
	private String password;

	// Relacion muchos a muchos con la tabla roles (un usuario puede tener
	// varios roles)
	@ManyToMany
	@JoinTable(name = "usuarios_roles", joinColumns = {
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id") }, inverseJoinColumns = {
	@JoinColumn(name = "rol_id", referencedColumnName = "rol_id") })
	private List<Rol> roles;

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
}
