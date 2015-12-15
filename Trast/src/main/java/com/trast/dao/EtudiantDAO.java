package com.trast.dao;

import java.util.List;

import com.trast.model.Etudiant;

public interface EtudiantDAO {
	public List<Etudiant> getEtudiants();
	public Etudiant getEtudiant(Long id);
	public boolean ajouterEtudiant(Etudiant etudiant);
	public void supprimerEtudiant(Long id);
	public void modifierEtudiant(Etudiant etudiant);

}
