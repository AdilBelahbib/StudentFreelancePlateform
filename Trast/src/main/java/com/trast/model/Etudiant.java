package com.trast.model;

import java.util.Date;
import java.util.Set;

public class Etudiant extends Particulier {
	private int nombreBids;
	private Set<Qualification> qualifications;
	private Set<Niveau> niveaux;
	private Set<Projet> projets;
	private Set<ContreProposition> contrePropositions;
	private Set<ResultatTest> resultatTests;

	public Etudiant() {
	}

	public Etudiant(String nom, String prenom, Date date, int nombreBids, Set<Qualification> qualifications,
			Set<Niveau> niveaux, Set<Projet> projets, Set<ContreProposition> contrePropositions,
			Set<ResultatTest> resultatTests) {
		super(nom, prenom, date);
		this.nombreBids = nombreBids;
		this.qualifications = qualifications;
		this.niveaux = niveaux;
		this.projets = projets;
		this.contrePropositions = contrePropositions;
		this.resultatTests = resultatTests;
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

	public Set<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(Set<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}

	public Set<ContreProposition> getContrePropositions() {
		return contrePropositions;
	}

	public void setContrePropositions(Set<ContreProposition> contreProposition) {
		this.contrePropositions = contreProposition;
	}

	public Set<ResultatTest> getResultatTests() {
		return resultatTests;
	}

	public void setResultatTests(Set<ResultatTest> resultatTests) {
		this.resultatTests = resultatTests;
	}

}
