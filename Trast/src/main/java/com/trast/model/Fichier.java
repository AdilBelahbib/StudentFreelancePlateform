package com.trast.model;

public class Fichier {
	private Long id;
	private String titre;
	private String chemin;
	
	public Fichier(){
	}
	
	public Fichier(Long id, String titre, String chemin)
	{
		this.id = id;
		this.titre = titre;
		this.chemin = chemin;
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

}
