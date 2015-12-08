package com.trast.model;

import java.util.Date;
import java.util.Set;

public class Formation extends Qualification{
	private IntituleFormation intituleFormation;

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formation(Long id, Date dateDebut, Date dateFin,Etudiant etudiant,Set<Fichier> fichiers,Set<AppelOffre> appelOffres, IntituleFormation intituleFormation) {
		super(id, dateDebut, dateFin,etudiant,fichiers,appelOffres);
		this.intituleFormation = intituleFormation;
	}

	public IntituleFormation getIntituleFormation() {
		return intituleFormation;
	}

	public void setIntituleFormation(IntituleFormation intituleFormation) {
		this.intituleFormation = intituleFormation;
	}

	

}