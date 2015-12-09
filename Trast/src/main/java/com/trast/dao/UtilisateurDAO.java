package com.trast.dao;

import java.util.List;

import com.trast.model.Utilisateur;

public interface UtilisateurDAO {
	public List<Utilisateur> getUtilisateurs();
	public Utilisateur getUtilisateurParId(Long id);
	public void ajouterUtilisateur(Utilisateur utilisateur);
	public void modifierUtilisateur(Long id);
	public void supprimerUtilisateur(Long id);
}
