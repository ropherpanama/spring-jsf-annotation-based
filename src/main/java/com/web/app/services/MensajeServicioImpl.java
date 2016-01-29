package com.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.dao.MensajeDAO;
import com.web.app.model.Mensaje;

@Service("mensajeServicio")
@Transactional(readOnly = true)
public class MensajeServicioImpl implements MensajeServicio {

	@Autowired
	private MensajeDAO mensajeDAO;

	public MensajeDAO getMensajeDAO() {
		return mensajeDAO;
	}

	public void setMensajeDAO(MensajeDAO mensajeDAO) {
		this.mensajeDAO = mensajeDAO;
	}

	@Transactional(readOnly = false)
	public void add(Mensaje m) {
		mensajeDAO.add(m);
	}

	@Transactional(readOnly = false)
	public List<Mensaje> list() {
		return mensajeDAO.list();
	}

	@Transactional(readOnly = false)
	public void remove(Integer id) {
		mensajeDAO.remove(id);
	}

	@Transactional(readOnly = false)
	public void update(Mensaje m) {
		mensajeDAO.update(m);
	}

	@Transactional(readOnly = false)
	public Mensaje getById(int id) {
		return mensajeDAO.getById(id);
	}
}
