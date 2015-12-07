package com.model;

import java.util.Set;

public class Etudiant extends Particulier{
	private int nombreBids;
	private Set<Qualification> qualifications;
	private Set<Competence> competences;
	private Set<AppelOffre> appelOffres;
	private Set<CahierDesCharges> cahiersDesCharges;
	private Set<ContreProposition> contrePropositions;
	
	public Etudiant(){
	}
	
	public Etudiant(int nb,Set<Qualification> qualifications, 
			Set<Competence> competences, Set<AppelOffre> appelOffres,
			Set<CahierDesCharges> cahiers, Set<ContreProposition> contreProposition){
		this.nombreBids = nb;
		this.qualifications = qualifications;
		this.competences = competences;
		this.appelOffres = appelOffres;
		this.cahiersDesCharges = cahiers;
		this.contrePropositions = contreProposition;
	}
	
	public int getNombreBids() {
		return nombreBids;
	}

	public void setNombreBids(int nombreBids) {
		this.nombreBids = nombreBids;
	}

	public Set<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public Set<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}

	public Set<AppelOffre> getAppelOffres() {
		return appelOffres;
	}

	public void setAppelOffres(Set<AppelOffre> appelOffres) {
		this.appelOffres = appelOffres;
	}

	public Set<CahierDesCharges> getCahiersDesCharges() {
		return cahiersDesCharges;
	}

	public void setCahiersDesCharges(Set<CahierDesCharges> cahiersDesCharges) {
		this.cahiersDesCharges = cahiersDesCharges;
	}

	public Set<ContreProposition> getContrePropositions() {
		return contrePropositions;
	}

	public void setContrePropositions(Set<ContreProposition> contreProposition) {
		this.contrePropositions = contreProposition;
	}
	
	
}
