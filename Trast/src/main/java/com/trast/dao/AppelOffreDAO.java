package com.trast.dao;

import java.util.List;

import com.trast.model.AppelOffre;

public interface AppelOffreDAO {
	
	public List<AppelOffre> getAppelOffres();
	public AppelOffre getAppelOffre(Long id);
	public void ajouterAppelOffre(AppelOffre appelOffre);
	public void supprimerAppelOffre(Long id);
	public void modifierAppelOffre(AppelOffre appelOffre);

}
