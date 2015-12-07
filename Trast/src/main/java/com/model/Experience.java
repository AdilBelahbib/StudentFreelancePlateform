package com.model;

import java.util.Date;
import java.util.Set;

public class Experience extends Qualification{
	private String responsabilite;
	private String typeExperience;
	private String structureAccueil;
	private String sujet;
	private Double salaire;
	
	public Experience() {
		super();
	}
	public Experience(Long id, Date dateDebut, Date dateFin,Etudiant etudiant,Set<Fichier> fichiers,Set<AppelOffre> appelOffres, String responsabilite, String typeExperience, String structureAccueil, String sujet,
			Double salaire) {
		super(id, dateDebut, dateFin,etudiant,fichiers,appelOffres);
		this.responsabilite = responsabilite;
		this.typeExperience = typeExperience;
		this.structureAccueil = structureAccueil;
		this.sujet = sujet;
		this.salaire = salaire;
	}
	
	public String getResponsabilite() {
		return responsabilite;
	}
	public void setResponsabilite(String responsabilite) {
		this.responsabilite = responsabilite;
	}
	public String getTypeExperience() {
		return typeExperience;
	}
	public void setTypeExperience(String typeExperience) {
		this.typeExperience = typeExperience;
	}
	public String getStructureAccueil() {
		return structureAccueil;
	}
	public void setStructureAccueil(String structureAccueil) {
		this.structureAccueil = structureAccueil;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

}