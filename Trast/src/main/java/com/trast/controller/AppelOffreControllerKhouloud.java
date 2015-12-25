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

	@ManagedProperty(value ="#{appelOffre}")
	private AppelOffre appelOffre;
	
	@ManagedProperty(value = "#{appelOffreDao}")
	private AppelOffreDAO appelOffreDao;
	
	@ManagedProperty(value ="#{sessionScope.utilisateur}")
	private Etudiant etudiant;
	
	@ManagedProperty(value = "#{etudiantDao}")
	private EtudiantDAO etudiantDao;
	//LISTES DES APPELS D'OFFRE
	@ManagedProperty(value = "#{listes}")
	private List<AppelOffre> listes;
	
	/*
	 * Instance contreProposition pour:
	 * 	L'ajout d'une contre-proposition lors de la visualisation 
	 * des détails d'un appel d'offre
	 */
	@ManagedProperty(value = "#{contreProposition}")
	private ContreProposition contreProposition;
	
	@ManagedProperty(value = "#{contrePropositionDao}")
	private ContrePropositionDAO contrePropositionDao;
	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public EtudiantDAO getEtudiantDao() {
		return etudiantDao;
	}

	public void setEtudiantDao(EtudiantDAO etudiantDao) {
		this.etudiantDao = etudiantDao;
	}

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
	 * La fonction est appelée lorsque l'étudiant visualise le détail 
	 * d'un appel d'offre.
	 */
	public String enregistrerContreProposition() {
		
		//Reduire le nombre de bids de l'étudiant
		etudiant.setNombreBids(etudiant.getNombreBids() - 1);
		
		
		//Initialiser les paramètres de l'instance contreProposition
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);
		appelOffre.getContrePropositions().add(contreProposition);
		etudiant.getContrePropositions().add(contreProposition);
		
		//Ajouter unecontreProposition
		contrePropositionDao.ajouterContreProposition(contreProposition);
		etudiantDao.modifierEtudiant(etudiant);
		//modifier l appel d'offre par le nouveau
		//appelOffreDao.modifierAppelOffre(appelOffre);
		
		return "listeAppelOffre";
	}
	
	/**
	 * La fonction est appelée pour détailler un appel d'offre
	 * Elle redirige vers la vue detailsAppelOffre.xhtml
	 */
	public String details(){
		
		return "detailsAppelOffres";
	}
	
	/**
	 * La fonction est appelée pour visualiser le formulaire 
	 * d'ajout d'une contre-proposition
	 * Elle redirige vers la vue ajoutContreProposition.xhtml
	 */
	public String nouvelleContreProposition(){
		return "ajoutContreProposition";
	}

}
