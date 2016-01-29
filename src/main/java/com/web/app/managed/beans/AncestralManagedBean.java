package com.web.app.managed.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AncestralManagedBean {
	
	public void addMessage(String titulo, String detalle) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo,  detalle);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void addErrorMessage(String titulo, String detalle) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo,  detalle);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void addFatalMessage(String titulo, String detalle) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo,  detalle);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void addWarnMessage(String titulo, String detalle) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo,  detalle);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
