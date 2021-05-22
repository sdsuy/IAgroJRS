package com.entidad;

import java.io.Serializable;

public class Rol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Roles rol;

	public Rol() {
		super();
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}
   
}
