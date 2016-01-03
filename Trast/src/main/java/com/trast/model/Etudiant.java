package com.trast.model;

import java.util.Date;
import java.util.Set;

public class Etudiant extends Particulier {
	private int nombreBids;
	private int avisPositifs;
	private int avisNegatifs;
	private Set<Qualification> qualifications;
	private Set<Niveau> niveaux;
	private Set<Projet> projets;
	private Set<ContreProposition> contrePropositions;
	private Set<ResultatTest> resultatTests;
	private Set<Badge> badges;

	public Etudiant() {
	}
	
	public Etudiant(String nom, String prenom, Date date, int nombreBids, int avisPositifs, int avisNegatifs,
			Set<Qualification> qualifications, Set<Niveau> niveaux, Set<Projet> projets,
			Set<ContreProposition> contrePropositions, Set<ResultatTest> resultatTests, Set<Badge> badges) {
		super(nom, prenom, date);
		this.nombreBids = nombreBids;
		this.avisPositifs = avisPositifs;
		this.avisNegatifs = avisNegatifs;
		this.qualifications = qualifications;
		this.niveaux = niveaux;
		this.projets = projets;
		this.contrePropositions = contrePropositions;
		this.resultatTests = resultatTests;
		this.badges = badges;
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

	public int getAvisPositifs() {
		return avisPositifs;
	}

	public void setAvisPositifs(int avisPositifs) {
		this.avisPositifs = avisPositifs;
	}

	public int getAvisNegatifs() {
		return avisNegatifs;
	}

	public void setAvisNegatifs(int avisNegatifs) {
		this.avisNegatifs = avisNegatifs;
	}

	public Set<Badge> getBadges() {
		return badges;
	}

	public void setBadges(Set<Badge> badges) {
		this.badges = badges;
	}
}
