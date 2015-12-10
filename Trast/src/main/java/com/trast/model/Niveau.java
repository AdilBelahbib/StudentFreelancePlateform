package com.trast.model;

public class Niveau {
	private Long id;
	private Etudiant etudiant;
	private Competence competence;
	private int maitrise;
	
	public Niveau() {
	}

	public Niveau(Long id, Etudiant etudiant, Competence competence, int maitrise) {
		this.id = id;
		this.etudiant = etudiant;
		this.competence = competence;
		this.maitrise = maitrise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public int getMaitrise() {
		return maitrise;
	}

	public void setMaitrise(int maitrise) {
		this.maitrise = maitrise;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		if(this.id != null)
			result = prime * result + ((id == null) ? 0 : id.intValue());
		else
			result = prime * result + ((id == null) ? 0 : etudiant.hashCode());
			
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
		Niveau other = (Niveau) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
