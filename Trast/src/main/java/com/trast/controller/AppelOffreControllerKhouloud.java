package com.trast.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.AppelOffreDAO;
import com.trast.dao.ContrePropositionDAO;
import com.trast.dao.EtudiantDAO;
import com.trast.model.AppelOffre;
import com.trast.model.ContreProposition;
import com.trast.model.EtatAppelOffre;
import com.trast.model.Etudiant;

@ManagedBean(name = "appelOffreControllerKhouloud", eager = true)
@SessionScoped
public class AppelOffreControllerKhouloud implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value ="#{sessionScope.appelOffre}")
	private AppelOffre appelOffre;
	
	@ManagedProperty(value = "#{sessionScope.appelOffreDao}")
	private AppelOffreDAO appelOffreDao;
	//LISTES DES APPELS D'OFFRE
	@ManagedProperty(value = "#{listes}")
	private List<AppelOffre> listes;
	
	/*
	 * Instance contreProposition pour:
	 * 	L'ajout d'une contre-proposition lors de la visualisation 
	 * des d�tails d'un appel d'offre
	 */
	@ManagedProperty(value = "#{contreProposition}")
	private ContreProposition contreProposition;
	
	@ManagedProperty(value = "#{contrePropositionDao}")
	private ContrePropositionDAO contrePropositionDao;
	
	public ContrePropositionDAO getContrePropositionDao() {
		return contrePropositionDao;
	}

	public void setContrePropositionDao(ContrePropositionDAO contrePropositionDao) {
		this.contrePropositionDao = contrePropositionDao;
	}

	public ContreProposition getContreProposition() {
		return contreProposition;
	}

	public void setContreProposition(ContreProposition contreProposition) {
		this.contreProposition = contreProposition;
	}

	public List<AppelOffre> getListes() {
		return listes;
	}

	public void setListes(List<AppelOffre> listes) {
		this.listes = listes;
	}

	public AppelOffre getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffre appelOffre) {
		this.appelOffre = appelOffre;
	}

	public AppelOffreDAO getAppelOffreDao() {
		return appelOffreDao;
	}

	public void setAppelOffreDao(AppelOffreDAO appelOffreDao) {
		this.appelOffreDao = appelOffreDao;
	}
	/**
	 * La fonction permet de visualiser la liste des appels d'offre
	 * qui ont le statut ENCOURS.
	 * Elle redirige vers la vue "listeAppelOffres.xhtml"
	 * */
	
	@Transactional
	public String listerAppelOffres(){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		this.appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		this.listes = this.appelOffreDao.getAppelOffresByStatus(EtatAppelOffre.ENCOURS);
		//System.out.println(listes.get(0).getId()+" "+listes.get(0).getStatut());
		((ConfigurableApplicationContext)context).close();
		return "listeAppelOffres";
	}
	/**
	 * La fonction est appel�e lorsque l'�tudiant visualise le d�tail 
	 * d'un appel d'offre.
	 */
	public String enregistrerContreProposition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		//R�cup�rer l'�tudiant connect�
		HttpSession session = request.getSession();
		Etudiant etudiant = (Etudiant) session.getAttribute("utilisateur");
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		//Reduire le nombre de bids de l'�tudiant
		etudiant.setNombreBids(etudiant.getNombreBids() - 1);
		etudiantDao.modifierEtudiant(etudiant);
		
		//Initialiser les param�tres de l'instance contreProposition
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);
		appelOffre.getContrePropositions().add(contreProposition);
		
		//Ajouter unecontreProposition
		contrePropositionDao.ajouterContreProposition(contreProposition);
		//modifier l appel d'offre par le nouveau
		//appelOffreDao.modifierAppelOffre(appelOffre);
		// r�initialisation de l'instance de contreProposition, vide
		contreProposition = (ContreProposition) context.getBean("contreProposition");
		((ConfigurableApplicationContext) context).close();
		return "listeAppelOffre";
	}
	
	/**
	 * La fonction est appel�e pour d�tailler un appel d'offre
	 * Elle redirige vers la vue detailsAppelOffre.xhtml
	 */
	public String details(){
		
		return "detailsAppelOffres";
	}
	
	/**
	 * La fonction est appel�e pour visualiser le formulaire 
	 * d'ajout d'une contre-proposition
	 * Elle redirige vers la vue ajoutContreProposition.xhtml
	 */
	public String nouvelleContreProposition(){
		return "ajoutContreProposition";
	}

}
