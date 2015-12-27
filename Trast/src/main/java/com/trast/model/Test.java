package com.trast.model;

import java.util.Set;

public class Test {
	private Long id;
	private Set<Question> questions;
	private double duree;
	private int nombrePassage;
	private Set<Competence> competences;
	private Entreprise entreprise;
	
	public Test() {
	}

	public Test(Long id, Set<Question> questions, double duree, int nombrePassage, Set<Competence> competences,
			Entreprise entreprise) {
		this.id = id;
		this.questions = questions;
		this.duree = duree;
		this.nombrePassage = nombrePassage;
		this.competences = competences;
		this.entreprise = entreprise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public int getNombrePassage() {
		return nombrePassage;
	}

	public void setNombrePassage(int nombrePassage) {
		this.nombrePassage = nombrePassage;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Set<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? (questions.hashCode()+entreprise.hashCode()) : id.hashCode());
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
		Test other = (Test) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
