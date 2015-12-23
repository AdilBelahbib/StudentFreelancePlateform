package com.trast.model;

import java.util.Date;
import java.util.Set;

public class Formation extends Qualification{
	private String intituleFormation;
	private String etablissement;
	
	public Formation() {

	}

	

	public Formation(Long id, Date dateDebut, Date dateFin, Etudiant etudiant, Set<Fichier> fichiers,
			AppelOffre appelOffre, String intituleFormation, String etablissement) {
		super(id, dateDebut, dateFin, etudiant, fichiers, appelOffre);
		this.intituleFormation = intituleFormation;
		this.etablissement = etablissement;
	}


	public String getIntituleFormation() {
		return intituleFormation;
	}

	public void setIntituleFormation(String intituleFormation) {
		this.intituleFormation = intituleFormation;
	}
	
	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}



	@Override
	public int hashCode() {
		 final int prime = 31;
		  int result = 1;
		  if(this.getId() != null)
		   result = prime * result + this.getId().intValue();
		  else 
		   result = prime * result + this.intituleFormation.hashCode() + (this.getDateDebut().hashCode()*this.getDateFin().hashCode());
		  return result;

	}
	

}