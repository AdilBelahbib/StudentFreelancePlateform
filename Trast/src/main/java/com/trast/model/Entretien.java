package com.trast.model;

import java.util.Date;
import java.util.Set;

public class Entretien {
	
	private Long id;
	private Date dateEntretien;
	private boolean termine;
	private Set<String> notes;
	private ContreProposition contreProposition;
	
	public Entretien() {
	}

	public Entretien(Long id, Date dateEntretien, boolean termine, Set<String> notes,
			ContreProposition contreProposition) {
		this.id = id;
		this.dateEntretien = dateEntretien;
		this.termine = termine;
		this.notes = notes;
		this.contreProposition = contreProposition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateEntretien() {
		return dateEntretien;
	}

	public void setDateEntretien(Date dateEntretien) {
		this.dateEntretien = dateEntretien;
	}

	public boolean isTermine() {
		return termine;
	}

	public void setTermine(boolean termine) {
		this.termine = termine;
	}

	public Set<String> getNotes() {
		return notes;
	}

	public void setNotes(Set<String> notes) {
		this.notes = notes;
	}

	public ContreProposition getContreProposition() {
		return contreProposition;
	}

	public void setContreProposition(ContreProposition contreProposition) {
		this.contreProposition = contreProposition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? dateEntretien.hashCode()+contreProposition.hashCode() : id.hashCode());
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
		Entretien other = (Entretien) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
