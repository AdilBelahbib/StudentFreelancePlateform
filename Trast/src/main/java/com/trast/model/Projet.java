package com.trast.model;

import java.util.Set;

public class Projet {	
	private Long id;
	private Etudiant etudiant;
	private CahierDesCharges cahierDesCharges;
	private Entreprise entreprise;
	private EtatProjet statut;
	private double cout;
	private String devise;
	private Set<Livrable> livrables;
	
	public Projet() {
	}
	
	public Projet(Long id, Etudiant etudiant, CahierDesCharges cahierDesCharges, Entreprise entreprise,
			EtatProjet statut, double cout, String devise, Set<Livrable> livrables) {
		this.id = id;
		this.etudiant = etudiant;
		this.cahierDesCharges = cahierDesCharges;
		this.entreprise = entreprise;
		this.statut = statut;
		this.cout = cout;
		this.devise = devise;
		this.livrables = livrables;
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

	public EtatProjet getStatut() {
		return statut;
	}

	public void setStatut(EtatProjet status) {
		this.statut = status;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Set<Livrable> getLivrables() {
		return livrables;
	}

	public void setLivrables(Set<Livrable> livrables) {
		this.livrables = livrables;
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