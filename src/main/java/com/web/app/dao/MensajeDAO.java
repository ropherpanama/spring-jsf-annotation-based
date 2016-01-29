package com.web.app.dao;

import java.util.List;

import com.web.app.model.Mensaje;

public interface MensajeDAO {
	
	public void add(Mensaje m);

	public List<Mensaje> list();

	public void remove(Integer id);

	public void update(Mensaje m);

	public Mensaje getById(int id);
}
