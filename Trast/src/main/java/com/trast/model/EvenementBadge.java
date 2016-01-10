package com.trast.model;

public class EvenementBadge {
	private Long id;
	private SourceEvenement sourceEvenement;
	private double valeur;
	private Badge badge;
	
	public EvenementBadge() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SourceEvenement getSourceEvenement() {
		return sourceEvenement;
	}

	public void setSourceEvenement(SourceEvenement sourceEvenement) {
		this.sourceEvenement = sourceEvenement;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result + ((id == null) ? (this.sourceEvenement.hashCode()*(int)this.valeur) : id.hashCode()));
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
		EvenementBadge other = (EvenementBadge) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
