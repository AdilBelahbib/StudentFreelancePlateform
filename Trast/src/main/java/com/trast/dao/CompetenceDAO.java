package com.trast.dao;

import java.util.List;

import com.trast.model.Competence;

public interface CompetenceDAO {
	
	public List<Competence> getCompetences();
	public Competence getCompetence(Long id);
	public void ajouterCompetence(Competence competence);
	public void supprimerCompetence(Long id);
	public void modifierCompetence(Competence competence);
	public Competence getCompetenceByIntitule(String intitule);
	public boolean ajouterCompetenceIfNotExist(Competence competence);

}
