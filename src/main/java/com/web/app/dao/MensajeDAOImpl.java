package com.web.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.app.model.Mensaje;

@Repository("mensajeDAO")
public class MensajeDAOImpl implements MensajeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Mensaje m) {
		sessionFactory.getCurrentSession().save(m);
	}

	@SuppressWarnings("unchecked")
	public List<Mensaje> list() {
		return sessionFactory.getCurrentSession().createQuery("from Mensaje as m").list();
	}

	public void remove(Integer id) {
		Mensaje m = (Mensaje) sessionFactory.getCurrentSession().load(Mensaje.class, id);
		if (null != m) {
			sessionFactory.getCurrentSession().delete(m);
		}
	}

	public void update(Mensaje m) {
		sessionFactory.getCurrentSession().update(m);
	}

	public Mensaje getById(int id) {
		@SuppressWarnings("unchecked")
		List<Mensaje> list = getSessionFactory().getCurrentSession().createQuery("from Mensaje  where mensajeId = ?")
				.setParameter(0, id).list();
		return (Mensaje) list.get(0);
	}
}
