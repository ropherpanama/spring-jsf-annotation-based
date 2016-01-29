package com.web.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.app.model.Usuario;

@Repository("usuarioDAO")
public class UsuarioDAOImpl implements UsuarioDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Usuario u) {
		sessionFactory.getCurrentSession().save(u);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		return sessionFactory.getCurrentSession().createQuery("from Usuario as u order by u.username").list();
	}

	public void remove(Integer id) {
		Usuario u = (Usuario) sessionFactory.getCurrentSession().load(Usuario.class, id);
		if (null != u) {
			sessionFactory.getCurrentSession().delete(u);
		}
	}

	public void update(Usuario u) {
		sessionFactory.getCurrentSession().update(u);
	}

	public Usuario getById(int id) {
		@SuppressWarnings("unchecked")
		List<Usuario> list = getSessionFactory().getCurrentSession().createQuery("from Usuario as u where u.usuarioId = ?")
				.setParameter(0, id).list();
		return (Usuario) list.get(0);
	}
	
	public Usuario getByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<Usuario> list = getSessionFactory().getCurrentSession().createQuery("from Usuario as u where u.username = ?")
				.setParameter(0, username).list();
		
		if(list.size() <= 0)
			return null;
		
		return (Usuario) list.get(0);
	}
}
