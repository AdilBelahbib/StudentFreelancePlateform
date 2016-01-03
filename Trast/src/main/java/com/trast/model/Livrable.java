package com.trast.model;

import java.util.Date;

public class Livrable {
	private Long id;
	private Date dateLivraison;
	private double pourcentageAvancement;
	private boolean valide;
	private String remarqueEntreprise;
	private Fichier fichier;
	private Projet projet;
	
	public Livrable() {
	}

	public Livrable(Long id, Date dateLivraison, double pourcentageAvancement, boolean valideParEntreprise,
			String remarqueEntreprise, Fichier fichier, Projet projet) {
		this.id = id;
		this.dateLivraison = dateLivraison;
		this.pourcentageAvancement = pourcentageAvancement;
		this.valide = valideParEntreprise;
		this.remarqueEntreprise = remarqueEntreprise;
		this.fichier = fichier;
		this.projet = projet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public double getPourcentageAvancement() {
		return pourcentageAvancement;
	}

	public void setPourcentageAvancement(double pourcentageAvancement) {
		this.pourcentageAvancement = pourcentageAvancement;
	}

	public boolean getValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public String getRemarqueEntreprise() {
		return remarqueEntreprise;
	}

	public void setRemarqueEntreprise(String remarqueEntreprise) {
		this.remarqueEntreprise = remarqueEntreprise;
	}

	public Fichier getFichier() {
		return fichier;
	}

	public void setFichier(Fichier fichier) {
		this.fichier = fichier;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? (dateLivraison.hashCode()+projet.hashCode()) : id.hashCode());
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
		Livrable other = (Livrable) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
