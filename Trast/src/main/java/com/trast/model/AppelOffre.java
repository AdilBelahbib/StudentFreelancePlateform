package com.trast.model;

import java.util.Date;
import java.util.Set;

public class AppelOffre {
	private Long id;
	private Date dateExpiration;
	private Date dateDebut;
	private Set<Remuneration> remunerations;
	private Set<Qualification> qualifications;
	private Set<ContreProposition> contrePropositions;
	private Set<Competence> competences;
	private Entreprise entreprise;
	private CahierDesCharges cahierDesCharges;
	private EtatAppelOffre statut;
	private boolean entretien;

	public AppelOffre(){
	}

	public AppelOffre(Long id, Date dateExpiration, Date dateDebut, Set<Remuneration> remunerations,
			Set<Qualification> qualifications, Set<ContreProposition> contrePropositions, Set<Competence> competences,
			Entreprise entreprise, CahierDesCharges cahierDesCharges, EtatAppelOffre statut, boolean entretien) {
		this.id = id;
		this.dateExpiration = dateExpiration;
		this.dateDebut = dateDebut;
		this.remunerations = remunerations;
		this.qualifications = qualifications;
		this.contrePropositions = contrePropositions;
		this.competences = competences;
		this.entreprise = entreprise;
		this.cahierDesCharges = cahierDesCharges;
		this.statut = statut;
		this.entretien = entretien;
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

	public Set<ContreProposition> getContrePropositions() {
		return contrePropositions;
	}

	public void setContrePropositions(Set<ContreProposition> contrePropositions) {
		this.contrePropositions = contrePropositions;
	}

	public Set<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}

	public EtatAppelOffre getStatut() {
		return statut;
	}

	public void setStatut(EtatAppelOffre status) {
		this.statut = status;
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

	public boolean isEntretien() {
		return entretien;
	}

	public void setEntretien(boolean entretien) {
		this.entretien = entretien;
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
}
