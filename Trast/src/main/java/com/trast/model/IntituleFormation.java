package com.trast.model;

import java.util.Set;

public class IntituleFormation {
	private Long id;
	private String intitule;
	private Etablissement etablissement;
	private Set<Formation> formations;
	
	public IntituleFormation() {

	}

	
	public IntituleFormation(Long id, String intitule,Etablissement etablissement, Set<Formation> formations) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.etablissement = etablissement;
		this.formations = formations;
	}

	
	public Etablissement getEtablissement() {
		return etablissement;
	}


	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}


	@Override
	public int hashCode() {
		 final int prime = 31;
		  int result = 1;
		  if(id != null)
		   result = prime * result + id.intValue();
		  else 
		   result = prime * result + intitule.hashCode();
		  return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntituleFormation other = (IntituleFormation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public Set<Formation> getFormations() {
		return formations;
	}


	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}
	

}