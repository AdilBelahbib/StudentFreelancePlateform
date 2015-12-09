package com.trast.dao;



import java.util.List;

import com.trast.model.Entreprise;

public interface EntrepriseDAO {
	
	public List<Entreprise> getEntreprises();
	public Entreprise getEntrepriseParId(Long id);
	public void ajouterEntreprise(Entreprise entreprise);
	public void modifierEntreprise(Long id);
	public void supprimerEntreprise(Long id);
	
}
