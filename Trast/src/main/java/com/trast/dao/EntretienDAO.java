package com.trast.dao;

import java.util.List;

import com.trast.model.ContreProposition;
import com.trast.model.Entreprise;
import com.trast.model.Entretien;
import com.trast.model.Etudiant;

public interface EntretienDAO {
	public List<Entretien> getEntretiens();
	public Entretien getEntretien(Long id);
	public void ajouterEntretien(Entretien entretien);
	public void supprimerEntretien(Entretien entretien);
	public void modifierEntretien(Entretien entretien);
}
