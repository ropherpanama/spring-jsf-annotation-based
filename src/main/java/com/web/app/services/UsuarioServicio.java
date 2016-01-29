package com.web.app.services;

import java.util.List;

import com.web.app.model.Usuario;

public interface UsuarioServicio {

	public void add(Usuario u);

	public List<Usuario> list();

	public void remove(Integer id);

	public void update(Usuario u);

	public Usuario getById(int id);
	
	public Usuario getByUsername(String username);
}
