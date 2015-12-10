package com.trast.model;

import java.util.Set;

public class Etablissement {
	private Long id;
	private String nomEtablissement;
	private Set<IntituleFormation> intituleFormations;

	public Etablissement() {
		
	}

	public Etablissement(Long id, String nomEtablissement, Set<IntituleFormation> intituleFormations) {
		super();
		this.id = id;
		this.nomEtablissement = nomEtablissement;
		this.intituleFormations = intituleFormations;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomEtablissement() {
		return nomEtablissement;
	}

	public void setNomEtablissement(String nomEtablissement) {
		this.nomEtablissement = nomEtablissement;
	}

	public Set<IntituleFormation> getIntituleFormations() {
		return intituleFormations;
	}

	public void setIntituleFormations(Set<IntituleFormation> intituleFormations) {
		this.intituleFormations = intituleFormations;
	}

	@Override
	public int hashCode() {
		 final int prime = 31;
		  int result = 1;
		  if(id != null)
		   result = prime * result + id.intValue();
		  else 
		   result = prime * result + nomEtablissement.hashCode();
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
		Etablissement other = (Etablissement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}