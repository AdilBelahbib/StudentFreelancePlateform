package com.trast.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.trast.model.Administrateur;

@ManagedBean(name = "administrateurController", eager = true)
@SessionScoped
public class AdministrateurController implements Serializable {

	private static final long serialVersionUID = -3873111261048683675L;
	
	@ManagedProperty(value = "#{adminitrateur}")
	private Administrateur admin;
	private String toto;

	public String getToto() {
		return toto;
	}

	public void setToto(String toto) {
		this.toto = toto;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	public void onLoad()
	{
//		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println("GETTING DATA OF : "+user.getUsername());
		System.out.println("onLoad called : "+toto+"...");
	}
	
}
