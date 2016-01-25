package com.trast.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.trast.dao.EntretienDAO;
import com.trast.model.ContreProposition;
import com.trast.model.Entreprise;
import com.trast.model.Entretien;
import com.trast.model.Etudiant;
import com.trast.model.Utilisateur;
import com.trast.service.DateCalculService;

@ManagedBean(name = "entretienControllerKhouloud", eager = true)
@SessionScoped
public class EntretienControllerKhouloud {
	//Utilisateur connect�
	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	Utilisateur utilisateur;
	
	//Utilis� pour diff�rencier l'utilisateur connect�
	private Etudiant etudiant;
	private Entreprise entreprise;
	
	private ContreProposition contreProposition;
	
	private String nbJoursRestants;
	
	@ManagedProperty(value = "#{entretienDao}")
	private EntretienDAO entretienDao;
	
	@ManagedProperty(value = "#{entretien}")
	private Entretien entretien;
	
	//Stockage de la liste des entretiens � partir des contresPropositions
		//de l'�tudiant connect�
	private List<Entretien> listeEntretiens;
	
	public String getNbJoursRestants() {
		return nbJoursRestants;
	}

	public void setNbJoursRestants(String nbJoursRestants) {
		this.nbJoursRestants = nbJoursRestants;
	}

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

	public ContreProposition getContreProposition() {
		return contreProposition;
	}

	public void setContreProposition(ContreProposition contreProposition) {
		this.contreProposition = contreProposition;
	}

	public EntretienDAO getEntretienDao() {
		return entretienDao;
	}

	public void setEntretienDao(EntretienDAO entretienDao) {
		this.entretienDao = entretienDao;
	}

	public Entretien getEntretien() {
		return entretien;
	}

	public void setEntretien(Entretien entretien) {
		this.entretien = entretien;
	}

	public List<Entretien> getListeEntretiens() {
		return listeEntretiens;
	}

	public void setListeEntretiens(List<Entretien> listeEntretiens) {
		this.listeEntretiens = listeEntretiens;
	}

	/**
	 * Cette fonction r�cup�re la liste des entretiens de la part 
	 * de l'�tudiant connect�. 
	 * Elle est appell�e par la vue listeEntretiens.xhtml
	 */
	public void getAllEntretiensByEtudiant(){
		// recuperer utilisateur sur etudiant
		this.etudiant = (Etudiant) utilisateur;
		//Instanciation de la liste des entretiens
		listeEntretiens = new ArrayList<Entretien>();
		//Pour chaque �l�ment de la liste des contre-propositions 
			//extraire et remplir la liste des entretiens
		for(ContreProposition item : etudiant.getContrePropositions()){
			if(item.getEntretien() != null)
			{
				listeEntretiens.add(item.getEntretien());
			}
		}
	}
	
	/**
	 * Fonction d�tails des entretiens, elle est appell�e � partir
	 * de la liste des entretiens
	 */
	public String detailsEntretien(){
		//calculer nombre des jours restants pour l'entretien
		nbJoursRestants = DateCalculService.calculDuree(new Date(), entretien.getDateEntretien());
		
		return "detailsEntretien.xhtml?faces-redirect=true";
	}
}
