package com.trast.model;

import java.util.Date;
import java.util.Set;

public class CahierDesCharges {
	private Long id;
	private String sujet;
	private Date dateDebut;
	private Date dateFin;
	private Set<Fichier> fichiers;
	private Projet projet;
	private AppelOffre appelOffre;
	
	public CahierDesCharges(){
	}
	
	public CahierDesCharges(Long id, String sujet, Date dateDebut, Date dateFin,
			Set<Fichier> fichiers, Projet projet, AppelOffre offre){
		this.id = id;
		this.sujet = sujet;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.fichiers = fichiers;
		this.projet = projet;
		this.appelOffre = offre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Set<Fichier> getFichiers() {
		return fichiers;
	}

	public void setFichiers(Set<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	
	public AppelOffre getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffre offre) {
		this.appelOffre = offre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(id != null)
			result = prime * result + id.intValue();
		else
			result = prime * result + dateDebut.hashCode();
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
		CahierDesCharges other = (CahierDesCharges) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
