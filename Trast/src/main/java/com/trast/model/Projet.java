package com.trast.model;

public class Projet {	
	private Long id;
	private Etudiant etudiant;
	private CahierDesCharges cahierDesCharges;
	private EtatProjet status;
	
	public Projet() {
	}

	public Projet(Long id, Etudiant etudiant, CahierDesCharges cahierDesCharges) {
		this.id = id;
		this.etudiant = etudiant;
		this.cahierDesCharges = cahierDesCharges;
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

	public CahierDesCharges getCahierDesCharges() {
		return cahierDesCharges;
	}

	public void setCahierDesCharges(CahierDesCharges cahierDesCharges) {
		this.cahierDesCharges = cahierDesCharges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		if(id != null)
			result = prime * result + ((id == null) ? 0 : id.intValue());
		else
			result = prime * result + ((id == null) ? 0 : cahierDesCharges.hashCode());
		
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
		Projet other = (Projet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
