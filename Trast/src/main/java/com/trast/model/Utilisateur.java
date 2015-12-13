package com.trast.model;

import java.util.HashSet;
import java.util.Set;

public class Utilisateur {
	private Long id;
	private String email;
	private String motDePasse;
	private Set<Fichier> fichiers;
	private Set<Adresse> adresses;
	private RoleUtilisateur roleUtilisateur;
	
	public RoleUtilisateur getRoleUtilisateur() {
		return roleUtilisateur;
	}

	public void setRoleUtilisateur(RoleUtilisateur roleUtilisateur) {
		this.roleUtilisateur = roleUtilisateur;
	}

	//roles:
	private Set<RoleUtilisateur> rolesUtilisateur = new HashSet<RoleUtilisateur>(0);
	
	public Set<RoleUtilisateur> getRolesUtilisateur() {
		return rolesUtilisateur;
	}

	public void setRolesUtilisateur(Set<RoleUtilisateur> rolesUtilisateur) {
		this.rolesUtilisateur = rolesUtilisateur;
	}

	public Utilisateur(){		
	}
	
	public Utilisateur(Long id, String email, String motDePasse, Set<Fichier> fichiers, Set<Adresse> adresses) {
		this.id = id;
		this.email = email;
		this.motDePasse = motDePasse;
		this.fichiers = fichiers;
		this.adresses = adresses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Set<Fichier> getFichiers() {
		return fichiers;
	}

	public void setFichiers(Set<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(id != null)
			result = prime * result + id.intValue();
		else
			result = prime * result + email.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
