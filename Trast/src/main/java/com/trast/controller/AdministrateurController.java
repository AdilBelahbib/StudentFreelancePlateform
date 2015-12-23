package com.trast.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.trast.model.Administrateur;

@ManagedBean(name = "administrateurController", eager = true)
@SessionScoped
public class AdministrateurController implements Serializable {

	private static final long serialVersionUID = -3873111261048683675L;
	
	@ManagedProperty(value = "#{adminitrateur}")
	private Administrateur admin;

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	
}
