package com.trast.dao;

import java.util.List;

import com.trast.model.AppelOffre;
import com.trast.model.EtatAppelOffre;

public interface AppelOffreDAO {
	
	public List<AppelOffre> getAppelOffres();
	public AppelOffre getAppelOffre(Long id);
	public void ajouterAppelOffre(AppelOffre appelOffre);
	public void supprimerAppelOffre(Long id);
	public void modifierAppelOffre(AppelOffre appelOffre);
	public List<AppelOffre> getAppelOffresByStatus(EtatAppelOffre statut);

}
