package com.trast.dao;

import java.util.List;

import com.trast.model.Administrateur;

public interface AdministrateurDAO {
	
	public List<Administrateur> getAdministrateurs();
	public Administrateur getAdministrateur(Long id);
	public void ajouterAdministrateur(Administrateur admin);
	public void supprimerAdministrateur(Long id);
	public void modifierAdministrateur(Administrateur admin);

}
