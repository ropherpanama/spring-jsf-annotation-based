package com.web.app.services;

import java.util.List;

import com.web.app.model.Mensaje;

public interface MensajeServicio {

	public void add(Mensaje m);

	public List<Mensaje> list();

	public void remove(Integer id);

	public void update(Mensaje m);

	public Mensaje getById(int id);
}
