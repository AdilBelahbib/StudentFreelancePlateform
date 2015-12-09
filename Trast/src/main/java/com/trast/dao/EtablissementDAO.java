package com.trast.dao;

import java.util.List;

import com.trast.model.Etablissement;

public interface EtablissementDAO {
	
	public List<Etablissement> getEtablissements();
	public Etablissement getEtablissementParId(Long id);
	public void ajouterEtablissement(Etablissement etablissement);
	public void modifierEtablissement(Long id);
	public void supprimerEtablissement(Long id);

}
