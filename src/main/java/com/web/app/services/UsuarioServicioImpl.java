package com.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.dao.UsuarioDAO;
import com.web.app.model.Usuario;

@Service("usuarioServicio")
@Transactional(readOnly = true)
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void add(Usuario u) {
		usuarioDAO.add(u);
	}

	@Override
	@Transactional(readOnly = false)
	public List<Usuario> list() {
		return usuarioDAO.list();
	}

	@Override
	@Transactional(readOnly = false)
	public void remove(Integer id) {
		usuarioDAO.remove(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Usuario u) {
		usuarioDAO.update(u);
	}

	@Override
	@Transactional(readOnly = false)
	public Usuario getById(int id) {
		return usuarioDAO.getById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Usuario getByUsername(String username) {
		return usuarioDAO.getByUsername(username);
	}
}
