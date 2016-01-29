package com.web.app.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.dao.UsuarioDAO;
import com.web.app.model.Rol;
import com.web.app.model.Usuario;

@Service("userDetailsService")
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDAO.getByUsername(username);

		if (usuario == null)
			throw new UsernameNotFoundException("Usuario " + username + " existe.");

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(usuario.getUsername(), usuario.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, getAuthorities(usuario.getRoles()));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(List<Rol> roles) {
		List<GrantedAuthority> authList = getGrantedAuthorities(roles);
		return authList;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(List<Rol> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Rol rol : roles) {
			authorities.add(new SimpleGrantedAuthority(rol.getDescripcion()));
		}

		return authorities;
	}
}
