package com.model;

import java.util.Set;

public class Entreprise extends Utilisateur{
	private String sigle;
	private Set<String> secteurActivites;
	private String apercu;
	private Set<AppelOffre> appelOffres;
	
	public Entreprise(){
	}
	
	public Entreprise(String sigle, Set<String> secteurs, String apercu,
			Set<AppelOffre> appelOffres){
		this.sigle = sigle;
		this.secteurActivites = secteurs;
		this.apercu = apercu;
		this.appelOffres = appelOffres;
	}

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public Set<String> getSecteurActivites() {
		return secteurActivites;
	}

	public void setSecteurActivites(Set<String> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}

	public String getApercu() {
		return apercu;
	}

	public void setApercu(String apercu) {
		this.apercu = apercu;
	}

	public Set<AppelOffre> getAppelOffres() {
		return appelOffres;
	}

	public void setAppelOffres(Set<AppelOffre> appelOffres) {
		this.appelOffres = appelOffres;
	}
	
	
}
