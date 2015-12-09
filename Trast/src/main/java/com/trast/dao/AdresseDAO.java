package com.trast.dao;

import java.util.List;

import com.trast.model.Adresse;

public interface AdresseDAO {
	
	public List<Adresse> getAdresses();
	public Adresse getAdresseParId(Long id);
	public void ajouterAdresse(Adresse adresse);
	public void modifierAdresse(Long id);
	public void supprimerAdresse(Long id);
}
