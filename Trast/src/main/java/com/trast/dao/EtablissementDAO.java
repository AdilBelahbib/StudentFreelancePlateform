package com.trast.dao;

import java.util.List;

import com.trast.model.Etablissement;

public interface EtablissementDAO {
	
	public List<Etablissement> getEtablissements();
	public Etablissement getEtablissementParId(Long id);
	public void ajouterEtablissement(Etablissement etablissement);
	public void modifierEtablissement(Etablissement etablissement);
	public void supprimerEtablissement(Long id);

}
