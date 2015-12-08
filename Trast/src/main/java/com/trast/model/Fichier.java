package com.trast.model;

public class Fichier {
	private Long id;
	private String titre;
	private String chemin;
	private CahierDesCharges cahierDesCharges;
	private Utilisateur utilisateur;
	private ContreProposition contreProposition;
	
	public Fichier(){
	}
	
	public Fichier(Long id, String titre, String chemin, CahierDesCharges cahier, Utilisateur utilisateur,
			ContreProposition contreProposition)
	{
		this.id = id;
		this.titre = titre;
		this.chemin = chemin;
		this.cahierDesCharges = cahier;
		this.utilisateur = utilisateur;
		this.contreProposition = contreProposition;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(id != null)
			result = prime * result + id.intValue();
		else
			result = prime * result + titre.hashCode();
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
		Fichier other = (Fichier) obj;
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

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public CahierDesCharges getCahierDesCharges() {
		return cahierDesCharges;
	}

	public void setCahierDesCharges(CahierDesCharges cahier) {
		this.cahierDesCharges = cahier;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ContreProposition getContreProposition() {
		return contreProposition;
	}

	public void setContreProposition(ContreProposition contreProposition) {
		this.contreProposition = contreProposition;
	}
	

}
