package com.web.app.managed.tablecolumns;

import java.io.Serializable;

public class MensajeTableColumn implements Serializable {
	private static final long serialVersionUID = 1751386886175498227L;
	private String header;
	private String property;

	public MensajeTableColumn(String header, String property) {
		this.header = header;
		this.property = property;
	}

	public String getHeader() {
		return header;
	}

	public String getProperty() {
		return property;
	}
}
