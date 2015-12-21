package com.trast.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.trast.model.Etudiant;

@ManagedBean(name = "etudiantController", eager = true)
@RequestScoped
public class EtudiantController {
	
	@ManagedProperty(value = "#{etudiant}") 
	private Etudiant etudiant;
	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
}
