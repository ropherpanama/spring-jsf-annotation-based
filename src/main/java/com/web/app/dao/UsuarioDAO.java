package com.web.app.dao;

import java.util.List;

import com.web.app.model.Usuario;

public interface UsuarioDAO {
	
	public void add(Usuario u);

	public List<Usuario> list();

	public void remove(Integer id);

	public void update(Usuario u);

	public Usuario getById(int id);
	
	public Usuario getByUsername(String username);
}
