package com.trast.model;

import java.util.Date;

public class Particulier extends Utilisateur {
	private String nom;
	private String prenom;
	private Date dateNaissance;
	
	public Particulier(){
	}
	
	public Particulier(String nom, String prenom,Date date){
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
