package com.trast.model;

import java.util.Set;

public class Badge {
	private Long id;
	private String intitule;
	private Fichier icone;
	private Set<Etudiant> etudiants;
	//private Test test;
	
	public Badge() {
	}

	public Badge(Long id, String intitule, Fichier icone, Set<Etudiant> etudiants) {
		this.id = id;
		this.intitule = intitule;
		this.icone = icone;
		this.etudiants = etudiants;
		//this.test = test;
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

	public Fichier getIcone() {
		return icone;
	}

	public void setIcone(Fichier icone) {
		this.icone = icone;
	}

	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
/*
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? intitule.hashCode() : id.hashCode());
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
		Badge other = (Badge) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
