package com.model;


public class Remuneration {
	private Long id;
	private double somme;
	private String intitule;
	private String devise;
	private AppelOffre appelOffre;
	
	public Remuneration() {
		super();
	}

	
	public Remuneration(Long id, double somme, String intitule, String devise,AppelOffre appelOffre) {
		super();
		this.id = id;
		this.somme = somme;
		this.intitule = intitule;
		this.devise = devise;
		this.appelOffre = appelOffre;
	}

	public AppelOffre getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffre appelOffre) {
		this.appelOffre = appelOffre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSomme() {
		return somme;
	}

	public void setSomme(double somme) {
		this.somme = somme;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
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
		Remuneration other = (Remuneration) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
