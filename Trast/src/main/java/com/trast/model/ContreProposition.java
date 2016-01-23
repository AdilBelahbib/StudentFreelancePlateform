package com.trast.model;

public class ContreProposition {
	private Long id;
	private Double enchere;
	private Fichier fichier;
	private AppelOffre appelOffre;
	private Etudiant etudiant;
	private Entretien entretien;
	
	public ContreProposition(){
	}

	public ContreProposition(Long id, Double enchere, Fichier fichier, AppelOffre appelOffre, Etudiant etudiant,
			Entretien entretien) {
		this.id = id;
		this.enchere = enchere;
		this.fichier = fichier;
		this.appelOffre = appelOffre;
		this.etudiant = etudiant;
		this.entretien = entretien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(id != null)
			result = prime * result + id.intValue();
		else
			result = (prime * result + etudiant.hashCode());
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
		ContreProposition other = (ContreProposition) obj;
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

	public Double getEnchere() {
		return enchere;
	}

	public void setEnchere(Double enchere) {
		this.enchere = enchere;
	}

	public Fichier getFichier() {
		return fichier;
	}

	public void setFichier(Fichier fichier) {
		this.fichier = fichier;
	}

	public AppelOffre getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffre offre) {
		this.appelOffre = offre;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Entretien getEntretien() {
		return entretien;
	}

	public void setEntretien(Entretien entretien) {
		this.entretien = entretien;
	}
	
	
}
