package com.web.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mensajes")
public class Mensaje implements Serializable {
	private static final long serialVersionUID = 3843260319968612021L;
	@Id
	@Column(name = "mensaje_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mensajeId;
	@Column(name = "texto")
	private String texto;
	@Column(name = "fecha")
	private Date fecha;

	public Integer getMensajeId() {
		return mensajeId;
	}

	public void setMensajeId(Integer mensajeId) {
		this.mensajeId = mensajeId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
