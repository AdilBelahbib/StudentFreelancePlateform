package com.trast.model;

import java.util.Date;
import java.util.Set;

public class Experience extends Qualification{
	private String responsabilite;
	private String typeExperience;
	private String structureAccueil;
	private String sujet;
	private Double salaire;
	
	public Experience() {
		
	}
	public Experience(Long id, Date dateDebut, Date dateFin,Etudiant etudiant,Set<Fichier> fichiers,AppelOffre appelOffre, String responsabilite, String typeExperience, String structureAccueil, String sujet,
			Double salaire) {
		super(id, dateDebut, dateFin,etudiant,fichiers,appelOffre);
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
	
	@Override
	public int hashCode() {
		 final int prime = 31;
		  int result = 1;
		  if(this.getId() != null)
		   result = prime * result + this.getId().intValue();
		  else 
		   result = prime * result + this.structureAccueil.hashCode() + (this.getDateDebut().hashCode()*this.getDateFin().hashCode());
		  return result;

	}
	
}