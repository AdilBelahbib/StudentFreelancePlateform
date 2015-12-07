package com.model;

import java.util.Set;

public class Competence {
	private Long id;
	private String intitule;
	private int niveau;
	private Etudiant etudiant;
	

	public Competence() {
		super();
	}
	
	public Competence(Long id, String intitule, int niveau, Etudiant etudiant) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.niveau = niveau;
		this.etudiant = etudiant;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
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
		Competence other = (Competence) obj;
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
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	

}