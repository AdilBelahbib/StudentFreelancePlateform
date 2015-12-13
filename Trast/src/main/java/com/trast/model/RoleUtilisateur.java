package com.trast.model;

import java.util.Set;

public class RoleUtilisateur {
	private Integer id;
	private String role;
	private Set<Utilisateur> utilisateurs;
	
	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public RoleUtilisateur(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
