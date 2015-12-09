package com.trast.dao;

import java.util.List;

import com.trast.model.Fichier;

public interface FichierDAO {

	public List<Fichier> getFichiers();
	public Fichier getFichierParId(Long id);
	public void ajouterFichier(Fichier fichier);
	public void modifierFichier(Long id);
	public void supprimerFichier(Long id);
}
