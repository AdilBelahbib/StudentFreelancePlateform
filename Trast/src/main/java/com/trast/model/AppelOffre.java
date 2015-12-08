package com.trast.model;

import java.util.Date;
import java.util.Set;

public class AppelOffre {
	private Long id;
	private Date dateExpiration;
	private Date dateDebut;
	private Set<Remuneration> remunerations;
	private Set<Qualification> qualifications;
	private Set<Etudiant> etudiants;
	private Entreprise entreprise;
	private CahierDesCharges cahierDesCharges;

	
	public AppelOffre(){
	}
	
	public AppelOffre(Long id, Date dateExp, Date dateDebut,
			Set<Remuneration> remunerations, Set<Qualification> qualifications,
			Set<Etudiant> etudiants, Entreprise entreprise, CahierDesCharges cahier){
		this.id = id;
		this.dateExpiration = dateExp;
		this.dateDebut = dateDebut;
		this.remunerations = remunerations;
		this.qualifications = qualifications;
		this.etudiants = etudiants;
		this.entreprise = entreprise;
		this.cahierDesCharges = cahier;
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
		AppelOffre other = (AppelOffre) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public Set<Remuneration> getRemunerations() {
		return remunerations;
	}

	public void setRemunerations(Set<Remuneration> remunerations) {
		this.remunerations = remunerations;
	}

	public Set<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public CahierDesCharges getCahierDesCharges() {
		return cahierDesCharges;
	}

	public void setCahierDesCharges(CahierDesCharges cahierDesCharges) {
		this.cahierDesCharges = cahierDesCharges;
	}

	
}
