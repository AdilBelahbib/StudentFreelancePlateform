package com.trast.model;

import java.util.Date;

public class ResultatTest {
	private Long id;
	private double score;
	private Date dateDernierPassage;
	private Etudiant etudiant;
	private Test test;
	
	public ResultatTest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getDateDernierPassage() {
		return dateDernierPassage;
	}

	public void setDateDernierPassage(Date dateDernierPassage) {
		this.dateDernierPassage = dateDernierPassage;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
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
		result = prime * result + ((id == null) ? (etudiant.hashCode()+test.hashCode()) : id.hashCode());
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
		ResultatTest other = (ResultatTest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
