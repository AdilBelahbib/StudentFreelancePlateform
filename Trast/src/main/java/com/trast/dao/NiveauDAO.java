package com.trast.dao;

import java.util.List;

import com.trast.model.Niveau;

public interface NiveauDAO {
	
	public List<Niveau> getNiveaux();
	public Niveau getNiveau(Long id);
	public void ajouterNiveau(Niveau admin);
	public void supprimerNiveau(Long id);
	public void modifierNiveau(Niveau admin);

}
