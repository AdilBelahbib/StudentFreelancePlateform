package com.trast.dao;

import java.util.List;

import com.trast.model.CahierDesCharges;

public interface CahierDesChargesDAO {

	public List<CahierDesCharges> getCahiersDesCharges();
	public CahierDesCharges getCahierDesChargesParId(Long id);
	public void ajouterCahierDesCharges(CahierDesCharges cahierDesCharges);
	public void modifierCahierDesCharges(Long id);
	public void supprimerCahierDesCharges(Long id);
}
