package com.web.app.managed.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.web.app.services.UsuarioServicio;

@ManagedBean(name = "mbLogin")
@SessionScoped
//@Component("mbLogin")
//@Scope("session")
public class LoginManagedBean extends AncestralManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	@ManagedProperty(value = "#{usuarioServicio}")
	UsuarioServicio servicio;
	
	@ManagedProperty(value="#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	public String login() {
		try {
            if(username.length() > 0 && password.length() > 0) {
            	Authentication request = new UsernamePasswordAuthenticationToken(username, password);
                Authentication result = authenticationManager.authenticate(request);
                SecurityContextHolder.getContext().setAuthentication(result);
                return "welcome";
            }else {
            	addWarnMessage("Hey!", "Tienes cuenta de usuario?");
            	return "goout";
            } 
        } catch (AuthenticationException e) {
            if(e instanceof BadCredentialsException)
            	addWarnMessage("Oops!", "Combinacion username/password incorrecta");
            return "goout";
        }
	}

	public UsuarioServicio getServicio() {
		return servicio;
	}

	public void setServicio(UsuarioServicio servicio) {
		this.servicio = servicio;
	}
}
