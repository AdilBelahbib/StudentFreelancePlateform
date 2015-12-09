package com.trast.dao;

import java.util.List;

import com.trast.model.ContreProposition;

public interface ContrePropositionDAO {
	
	public List<ContreProposition> getContrePropositions();
	public ContreProposition getContrePropositionParId(Long id);
	public void ajouterContreProposition(ContreProposition contreProposition);
	public void modifierContreProposition(Long id);
	public void supprimerContreProposition(Long id);
}
