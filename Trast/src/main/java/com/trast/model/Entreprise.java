package com.trast.model;

import java.util.Set;

public class Entreprise extends Utilisateur{
	private String sigle;
	private Set<String> secteurActivites;
	private String apercu;
	private Set<AppelOffre> appelOffres;
	private Set<Projet> projets;
	private Set<Test> tests;
	private EtatCompte etatCompte;
	
	public Entreprise(){
	} 	

	public Entreprise(Long id, String email, String motDePasse, Set<Fichier> fichiers, Set<Adresse> adresses,
			String sigle, Set<String> secteurActivites, String apercu, Set<AppelOffre> appelOffres, Set<Projet> projets,
			Set<Test> tests, EtatCompte etatCompte) {
		super(id, email, motDePasse, fichiers, adresses);
		this.sigle = sigle;
		this.secteurActivites = secteurActivites;
		this.apercu = apercu;
		this.appelOffres = appelOffres;
		this.projets = projets;
		this.tests = tests;
		this.etatCompte = etatCompte;
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
	
	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}

	public EtatCompte getEtatCompte() {
		return etatCompte;
	}

	public void setEtatCompte(EtatCompte etatCompte) {
		this.etatCompte = etatCompte;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
	
}