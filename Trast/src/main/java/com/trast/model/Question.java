package com.trast.model;

import java.util.Set;

public class Question {
	private Long id;
	private String question;
	private Set<String> reponsesJustes;
	private Set<String> reponsesFausses;
	private double coefficient;
	private Test test;
	
	public Question() {
	}

	public Question(Long id, String question, Set<String> reponsesJustes, Set<String> reponsesFausses,
			double coefficient, Test test) {
		this.id = id;
		this.question = question;
		this.reponsesJustes = reponsesJustes;
		this.reponsesFausses = reponsesFausses;
		this.coefficient = coefficient;
		this.test = test;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<String> getReponsesJustes() {
		return reponsesJustes;
	}

	public void setReponsesJustes(Set<String> reponsesJustes) {
		this.reponsesJustes = reponsesJustes;
	}

	public Set<String> getReponsesFausses() {
		return reponsesFausses;
	}

	public void setReponsesFausses(Set<String> reponsesFausses) {
		this.reponsesFausses = reponsesFausses;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((id == null) ? (question.hashCode()+(int)coefficient) : id.hashCode());
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
		Question other = (Question) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
