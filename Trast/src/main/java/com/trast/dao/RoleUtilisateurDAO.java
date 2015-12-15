package com.trast.dao;

import java.util.List;

import com.trast.model.RoleUtilisateur;

public interface RoleUtilisateurDAO {
	public List<RoleUtilisateur> getRoles();
	public RoleUtilisateur getRole(Long id);
	public void ajouterRole(RoleUtilisateur role);
	public void supprimerRole(RoleUtilisateur role);
	public void modifierRole(RoleUtilisateur role);
	RoleUtilisateur getRoleByNom(String role);

}
