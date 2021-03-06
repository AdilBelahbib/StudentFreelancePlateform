package com.trast.dao;

import java.util.List;

import com.trast.model.EvenementBadge;
import com.trast.model.SourceEvenement;

public interface EvenementBadgeDAO {
	public List<EvenementBadge> getEvenementBadges();
	public EvenementBadge getEvenementBadge(Long id);
	public void ajouterEvenementBadge(EvenementBadge evenementBadge);
	public void supprimerEvenementBadge(EvenementBadge evenementBadge);
	public void modifierEvenementBadge(EvenementBadge evenementBadge);
	public List<EvenementBadge> getEvenementsBadgesBySource(SourceEvenement source);
}
