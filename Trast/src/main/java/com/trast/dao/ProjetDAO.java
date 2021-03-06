package com.trast.dao;

import java.util.List;

import com.trast.model.Entreprise;
import com.trast.model.Etudiant;
import com.trast.model.Projet;

public interface ProjetDAO {
	public List<Projet> getProjets();
	public Projet getProjetParId(Long id);
	public void ajouterProjet(Projet projet);
	public void modifierProjet(Projet projet);
	public void supprimerProjet(Long id);
	public List<Projet> getProjetsByEtudiant(Etudiant etudiant);
	public List<Projet> getProjetsByEntreprise(Entreprise entreprise);
}
