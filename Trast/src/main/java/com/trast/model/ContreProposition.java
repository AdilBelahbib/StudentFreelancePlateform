package com.trast.model;

public class ContreProposition {
	private Long id;
	private String enchere;
	private Fichier fichier;
	private AppelOffre appelOffre;
	private Etudiant etudiant;
	
	public ContreProposition(){
	}
	
	public ContreProposition(Long id, String enchere, Fichier fichier, AppelOffre offre, Etudiant etudiant){
		this.id = id;
		this.enchere = enchere;
		this.fichier = fichier;
		this.appelOffre = offre;
		this.etudiant = etudiant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(id != null)
			result = prime * result + id.intValue();
		else
			result = prime * result + enchere.hashCode();
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

	public String getEnchere() {
		return enchere;
	}

	public void setEnchere(String enchere) {
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
	
	
}
