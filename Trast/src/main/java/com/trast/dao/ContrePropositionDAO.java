package com.trast.dao;

import java.util.List;

import com.trast.model.AppelOffre;
import com.trast.model.ContreProposition;

public interface ContrePropositionDAO {
	
	public List<ContreProposition> getContrePropositions();
	public ContreProposition getContrePropositionParId(Long id);
	public void ajouterContreProposition(ContreProposition contreProposition);
	public void modifierContreProposition(ContreProposition contreProposition);
	public void supprimerContreProposition(Long id);
	public List<ContreProposition> getContrePropositionsByAppelOffre(AppelOffre appelOffre);
}
