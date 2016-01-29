package com.web.app.managed.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.web.app.managed.tablecolumns.MensajeTableColumn;
import com.web.app.model.Mensaje;
import com.web.app.services.MensajeServicio;

@ManagedBean(name = "mbDashboard")
@SessionScoped
//@Component("mbDashboard")
//@Scope("session")
public class DashboardManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{mensajeServicio}")
	MensajeServicio servicio;
	private List<Mensaje> mensajes;
	private List<MensajeTableColumn> dataTableColumns = new ArrayList<MensajeTableColumn>();

	@PostConstruct
	public void init() {
		mensajes = servicio.list();
		dataTableColumns.add(new MensajeTableColumn("Id", "mensajeId"));
		dataTableColumns.add(new MensajeTableColumn("Texto", "texto"));
		dataTableColumns.add(new MensajeTableColumn("Fecha", "fecha"));
	}

	public MensajeServicio getServicio() {
		return servicio;
	}

	public void setServicio(MensajeServicio servicio) {
		this.servicio = servicio;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public List<MensajeTableColumn> getDataTableColumns() {
		return dataTableColumns;
	}
}
