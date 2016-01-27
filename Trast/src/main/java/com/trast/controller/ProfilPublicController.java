package com.trast.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.trast.model.Entreprise;
import com.trast.model.Etudiant;
import com.trast.model.Utilisateur;

@ManagedBean(name = "profilPublicController", eager = true)
@SessionScoped
public class ProfilPublicController {
	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	Utilisateur utilisateur;
	
	private Etudiant etudiant;
	
	private Entreprise entreprise;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	/**
	 * Fonction qui permet de r�cup�rer les informations de l'entreprise 
	 * 		== Visualiser le profil public de l'entreprise ==
	 * Elle est appel�e du d�tail d'appel d'offre
	 */
	public String getInfosEntreprise(){
		this.etudiant = (Etudiant) this.utilisateur;
		
		return "/views/profilEntreprise.xhtml?faces-redirect=true?id="+entreprise.getId();
	}
	
	/**
	 * Fonction qui permet de r�cup�rer les informations de l'�tudiant 
	 * 	== Visualiser le profil public de l'�tudiant == 
	 * 
	 * Elle est appel�e de la liste des appels d'offre.
	 */
	
	public String getInfosEtudiant(){
		this.entreprise = (Entreprise) this.utilisateur;
		
		return "/views/profilEtudiant.xhtml?faces-redirect=true?id="+etudiant.getId();
	}
}
