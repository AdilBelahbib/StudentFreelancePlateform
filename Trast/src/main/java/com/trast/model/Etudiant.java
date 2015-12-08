package com.trast.model;

import java.util.Set;

public class Etudiant extends Particulier {
	private int nombreBids;
	private Set<Qualification> qualifications;
	private Set<Competence> competences;
	private Set<Projet> projets;
	private Set<ContreProposition> contrePropositions;

	public Etudiant() {
	}

	public Etudiant(int nb, Set<Qualification> qualifications, Set<Competence> competences, Set<Projet> projets,
			Set<ContreProposition> contreProposition) {
		this.nombreBids = nb;
		this.qualifications = qualifications;
		this.competences = competences;
		this.projets = projets;
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

	public Set<Projet> getProjet() {
		return projets;
	}

	public void setProjet(Set<Projet> projets) {
		this.projets = projets;
	}

	public Set<ContreProposition> getContrePropositions() {
		return contrePropositions;
	}

	public void setContrePropositions(Set<ContreProposition> contreProposition) {
		this.contrePropositions = contreProposition;
	}

}
