package com.trast.dao;

import java.util.List;

import com.trast.model.Qualification;

public interface QualificationDAO {
	public List<Qualification> getQualifications();
	public Qualification getQualificationParId(Long id);
	public void ajouterQualification(Qualification qualification);
	public void modifierQualification(Qualification qualification);
	public void supprimerQualification(Long id);
}
