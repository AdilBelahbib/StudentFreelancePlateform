package com.trast.dao;

import java.util.List;

import com.trast.model.Experience;

public interface ExperienceDAO {
	public List<Experience> getExperiences();
	public Experience getExperience(Long id);
	public void ajouterExperience(Experience experience);
	public void supprimerExperience(Long id);
	public void modifierExperience(Experience experience);

}
