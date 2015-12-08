package com.trast.model;

import java.util.Date;

public class Particulier extends Utilisateur {
	private String nomUtilisateur;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	
	public Particulier(){
	}
	
	public Particulier(String utilisateur, String nom, String prenom,Date date){
		this.nomUtilisateur = utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = date;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
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
