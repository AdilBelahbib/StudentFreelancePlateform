package com.trast.dao;

import java.util.List;

import com.trast.model.IntituleFormation;

public interface IntituleFormationDAO {
	public List<IntituleFormation> getIntituleFormations();
	public IntituleFormation getIntituleFormationParId(Long id);
	public void ajouterIntituleFormation(IntituleFormation intituleFormation);
	public void modifierIntituleFormation(Long id);
	public void supprimerIntituleFormation(Long id);
}
