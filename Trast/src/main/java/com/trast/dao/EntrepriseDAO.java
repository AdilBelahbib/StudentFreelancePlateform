package com.trast.dao;



import java.util.List;

import com.trast.model.Entreprise;
import com.trast.model.EtatCompte;

public interface EntrepriseDAO {
	
	public List<Entreprise> getEntreprises();
	public Entreprise getEntrepriseParId(Long id);
	public void ajouterEntreprise(Entreprise entreprise);
	public void modifierEntreprise(Entreprise entreprise);
	public void supprimerEntreprise(Long id);
	public List<Entreprise> getEntreprisesByEtatCompte(EtatCompte etatCompte);
	
}
