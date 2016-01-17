package com.trast.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trast.dao.AppelOffreDAO;
import com.trast.dao.CahierDesChargesDAO;
import com.trast.dao.CompetenceDAO;
import com.trast.dao.ContrePropositionDAO;
import com.trast.dao.EntrepriseDAO;
import com.trast.dao.EtudiantDAO;
import com.trast.dao.EvenementBadgeDAO;
import com.trast.dao.ExperienceDAO;
import com.trast.dao.FichierDAO;
import com.trast.dao.FormationDAO;
import com.trast.dao.ProjetDAO;
import com.trast.dao.RemunerationDAO;
import com.trast.model.AppelOffre;
import com.trast.model.CahierDesCharges;
import com.trast.model.Competence;
import com.trast.model.ContreProposition;
import com.trast.model.Entreprise;
import com.trast.model.EtatAppelOffre;
import com.trast.model.EtatProjet;
import com.trast.model.Etudiant;
import com.trast.model.EvenementBadge;
import com.trast.model.Experience;
import com.trast.model.Fichier;
import com.trast.model.Formation;
import com.trast.model.Projet;
import com.trast.model.Qualification;
import com.trast.model.Remuneration;
import com.trast.model.SourceEvenement;
import com.trast.model.Utilisateur;
import com.trast.service.UploadFileService;

@ManagedBean(name = "appelOffreController", eager = true)
@SessionScoped
public class AppelOffreController implements Serializable {

	private static final long serialVersionUID = -2671155118015679305L;

	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	Utilisateur utilisateur;

	private Etudiant etudiant;
	private Entreprise entreprise;

	@ManagedProperty(value = "#{appelOffre}")
	AppelOffre appelOffre;

	@ManagedProperty(value = "#{appelOffreDao}")
	private AppelOffreDAO appelOffreDao;

	@ManagedProperty(value = "#{appelOffres}")
	List<AppelOffre> appelOffres;

	@ManagedProperty(value = "#{contreProposition}")
	ContreProposition contreProposition;

	@ManagedProperty(value = "#{contrePropositionDao}")
	private ContrePropositionDAO contrePropositionDao;
	
	@ManagedProperty(value = "#{evenementBadgeDao}")
	private EvenementBadgeDAO evenementBadgeDAO;
	
	/*
	 * @ManagedProperty(value ="#{sessionScope.utilisateur}") private Etudiant
	 * etudiant;
	 */

	@ManagedProperty(value = "#{etudiantDao}")
	private EtudiantDAO etudiantDao;
	// LISTES DES APPELS D'OFFRE
	@ManagedProperty(value = "#{listes}")
	private List<AppelOffre> listes;

	/* pour creation d'un appel offre */
	@ManagedProperty(value = "#{cahierDesCharges}")
	CahierDesCharges cahierDesCharges;

	@ManagedProperty(value = "#{fichier}")
	Fichier fichier;

	@ManagedProperty(value = "#{remuneration}")
	Remuneration remuneration;
	@ManagedProperty(value = "#{formation}")
	Formation formation;
	@ManagedProperty(value = "#{experience}")
	Experience experience;
	@ManagedProperty(value = "#{experiencesAppelOffre}")
	List<Experience> experiencesAppelOffre;
	@ManagedProperty(value = "#{remunerationsAppelOffre}")
	List<Remuneration> remunerationsAppelOffre;
	@ManagedProperty(value = "#{formationsAppelOffre}")
	List<Formation> formationsAppelOffre;
	@ManagedProperty(value = "#{competence}")
	Competence competence;

	/************************************************/

	public AppelOffreDAO getAppelOffreDao() {
		return appelOffreDao;
	}

	public void setAppelOffreDao(AppelOffreDAO appelOffreDao) {
		this.appelOffreDao = appelOffreDao;
	}

	public ContrePropositionDAO getContrePropositionDao() {
		return contrePropositionDao;
	}

	public void setContrePropositionDao(ContrePropositionDAO contrePropositionDao) {
		this.contrePropositionDao = contrePropositionDao;
	}

	public EtudiantDAO getEtudiantDao() {
		return etudiantDao;
	}

	public void setEtudiantDao(EtudiantDAO etudiantDao) {
		this.etudiantDao = etudiantDao;
	}

	public List<AppelOffre> getListes() {
		return listes;
	}

	public void setListes(List<AppelOffre> listes) {
		this.listes = listes;
	}

	public Fichier getFichier() {
		return fichier;
	}

	public void setFichier(Fichier fichier) {
		this.fichier = fichier;
	}

	public AppelOffre getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffre appelOffre) {
		this.appelOffre = appelOffre;
	}

	public List<AppelOffre> getAppelOffres() {
		return appelOffres;
	}

	public void setAppelOffres(List<AppelOffre> appelOffres) {
		this.appelOffres = appelOffres;
	}

	public CahierDesCharges getCahierDesCharges() {
		return cahierDesCharges;
	}

	public void setCahierDesCharges(CahierDesCharges cahierDesCharges) {
		this.cahierDesCharges = cahierDesCharges;
	}

	public Remuneration getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(Remuneration remuneration) {
		this.remuneration = remuneration;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public List<Experience> getExperiencesAppelOffre() {
		return experiencesAppelOffre;
	}

	public void setExperiencesAppelOffre(List<Experience> experiencesAppelOffre) {
		this.experiencesAppelOffre = experiencesAppelOffre;
	}

	public List<Remuneration> getRemunerationsAppelOffre() {
		return remunerationsAppelOffre;
	}

	public void setRemunerationsAppelOffre(List<Remuneration> remunerationsAppelOffre) {
		this.remunerationsAppelOffre = remunerationsAppelOffre;
	}

	public List<Formation> getFormationsAppelOffre() {
		return formationsAppelOffre;
	}

	public void setFormationsAppelOffre(List<Formation> formationsAppelOffre) {
		this.formationsAppelOffre = formationsAppelOffre;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;

	}

	public ContreProposition getContreProposition() {
		return contreProposition;
	}

	public void setContreProposition(ContreProposition contreProposition) {
		this.contreProposition = contreProposition;
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

	public EvenementBadgeDAO getEvenementBadgeDAO() {
		return evenementBadgeDAO;
	}

	public void setEvenementBadgeDAO(EvenementBadgeDAO evenementBadgeDAO) {
		this.evenementBadgeDAO = evenementBadgeDAO;
	}

	/*****************************************************/

	public void ajouterCompetence() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		/* verifier si ca existe deja */
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		competence = competenceDao.ajouterCompetenceIfNotExist(competence);
		appelOffre.getCompetences().add(competence);
		competence = (Competence) context.getBean("competence");
		((ConfigurableApplicationContext) context).close();

		// System.out.println("**** ajout "+competence.getIntitule()+" res
		// "+exist);
	}

	public void retirerCompetence() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		this.appelOffre.getCompetences().remove(competence);
	}

	public void ajouterRemuneration() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		remuneration.setAppelOffre(appelOffre);
		this.appelOffre.getRemunerations().add(remuneration);
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		RemunerationDAO remunerationDao = (RemunerationDAO) context.getBean("remunerationDao");
		remunerationDao.ajouterRemuneration(remuneration);
		remuneration = (Remuneration) context.getBean("remuneration");
		((ConfigurableApplicationContext) context).close();
	}

	public void retirerRemuneration() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		this.appelOffre.getRemunerations().remove(remuneration);
	}

	public void ajouterFormation() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		formationsAppelOffre.add(formation);
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		formation = (Formation) context.getBean("formation");
		((ConfigurableApplicationContext) context).close();
	}

	public void retirerFormation() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		formationsAppelOffre.remove(formation);
	}

	public void ajouterExperience() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		experiencesAppelOffre.add(experience);
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		experience = (Experience) context.getBean("experience");
		((ConfigurableApplicationContext) context).close();
	}

	public void retirerExperience() {
		experiencesAppelOffre.remove(experience);
	}

	/************************************************************/

	public void relancerAppelOffre() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		AppelOffreDAO appelDao = (AppelOffreDAO) context.getBean("appelOffreDao");

		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		for (AppelOffre item : entreprise.getAppelOffres()) {
			if (item.getId() == appelOffre.getId()) {
				item.setStatut(EtatAppelOffre.ENCOURS);
				appelDao.modifierAppelOffre(item);
				break;
			}
		}
		((ConfigurableApplicationContext) context).close();
		this.afficherAppelsOffreArchives();
		// return "afficherArchives";
	}

	public void archiverAppelOffre() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		AppelOffreDAO appelDao = (AppelOffreDAO) context.getBean("appelOffreDao");

		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		for (AppelOffre item : entreprise.getAppelOffres()) {
			if (item.getId() == appelOffre.getId()) {
				item.setStatut(EtatAppelOffre.PREPARE);
				appelDao.modifierAppelOffre(item);
				break;
			}
		}
		((ConfigurableApplicationContext) context).close();
		this.afficherAppelsOffreEnCours();
		// return "afficherArchives";
	}

	public String affecterAppelOffre() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		AppelOffreDAO appelDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");

		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		System.out.println("************* " + entreprise.getId());
		Projet projet = (Projet) context.getBean("projet");
		System.out.println("************* " + entreprise.getId());
		entreprise.getProjets().add(projet);

		projet.setEntreprise(entreprise);
		projet.setCahierDesCharges(appelOffre.getCahierDesCharges());
		projet.setEtudiant(contreProposition.getEtudiant());
		projet.setCout(contreProposition.getEnchere());
		projet.setStatut(EtatProjet.ENCOURS);
		projetDao.ajouterProjet(projet);

		// **************************************************//
		// * BADGE: Vérifier si l'étudiant mérite un badge *//
		contreProposition.getEtudiant().getProjets().add(projet);
		this.verifierMeriteBadge(etudiant);
		// **************************************************//

		/* retirer contre proposition acceptee */
		appelOffre.getContrePropositions().remove(contreProposition);
		contreProposition.getEtudiant().getContrePropositions().remove(contreProposition);
		contreProposition.setEtudiant(null);
		contrePropositionDao.modifierContreProposition(contreProposition);
		contrePropositionDao.supprimerContreProposition(contreProposition.getId());

		/* retirer les autres contrepropositions + incre bids */
		for (ContreProposition item : appelOffre.getContrePropositions()) {
			item.getEtudiant().setNombreBids(item.getEtudiant().getNombreBids() + 1);
			etudiantDao.modifierEtudiant(item.getEtudiant());
			/* supprimer */
			item.setEtudiant(null);
			contrePropositionDao.modifierContreProposition(item);
			contrePropositionDao.supprimerContreProposition(item.getId());
			appelOffre.getContrePropositions().remove(item);
		}
		/* modifier etat appelOffre / supprimer */
		for (AppelOffre item : entreprise.getAppelOffres()) {
			if (item.getId() == appelOffre.getId()) {
				item.setStatut(EtatAppelOffre.AFFECTE);
				appelDao.modifierAppelOffre(item);
				break;
			}
		}

		((ConfigurableApplicationContext) context).close();
		appelOffres.remove(appelOffre);

		//return "afficherEncours";
		return "/views/entreprise/afficherAppelsOffreEnCours.xhtml?faces-redirect=true";

	}

	public String refuserContreProposition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		AppelOffreDAO appelDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");

		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		contreProposition.getEtudiant().setNombreBids(contreProposition.getEtudiant().getNombreBids() + 1);
		etudiantDao.modifierEtudiant(contreProposition.getEtudiant());
		/* supprimer */
		contreProposition.setEtudiant(null);
		contrePropositionDao.modifierContreProposition(contreProposition);
		contrePropositionDao.supprimerContreProposition(contreProposition.getId());
		appelOffre.getContrePropositions().remove(contreProposition);
		appelDao.modifierAppelOffre(appelOffre);
		((ConfigurableApplicationContext) context).close();

		/* recuperer les appels d'offre archive */
		appelOffres.remove(appelOffre);

		//return "afficherEncours";
		return "/views/entreprise/afficherAppelsOffreEnCours.xhtml?faces-redirect=true";

	}

	/************************************************/
	public void afficherAppelsOffre() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		/* recuperer entrprise avec ID */
		appelOffres = new ArrayList<AppelOffre>(entreprise.getAppelOffres());
		System.out.println("app " + entreprise.getAppelOffres().size() + ", rec " + appelOffres.size());
		/*
		 * initialiser appel d'offre et cahierdescharges pour une eventuelle
		 * creation
		 */
		cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		appelOffre = (AppelOffre) context.getBean("appelOffre");

		((ConfigurableApplicationContext) context).close();

	}

	public void afficherAppelsOffreArchives() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		appelOffres = new ArrayList<AppelOffre>();
		/* recuperer les appels d'offre archive */
		for (AppelOffre item : entreprise.getAppelOffres()) {
			if (item.getStatut().equals(EtatAppelOffre.PREPARE))
				appelOffres.add(item);
		}
	}

	public void afficherAppelsOffreEnCours() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		appelOffres = new ArrayList<AppelOffre>();
		/* recuperer les appels d'offre archive */
		for (AppelOffre item : entreprise.getAppelOffres()) {
			if (item.getStatut().equals(EtatAppelOffre.ENCOURS))
				appelOffres.add(item);
		}

	}

	public String ajouterAppelOffre() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String requete = request.getParameter("requete");
		if (requete.equals("get")) {
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			CahierDesChargesDAO cahierDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
			AppelOffreDAO appelDao = (AppelOffreDAO) context.getBean("appelOffreDao");
			EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");

			System.out.println("date " + appelOffre.getDateExpiration() + " , " + fichier.getTitre());
			appelOffre.setDateDebut(cahierDesCharges.getDateDebut());
			appelOffre.setEntreprise(entreprise);
			appelOffre.setCahierDesCharges(cahierDesCharges);
			cahierDesCharges.setDateDebut(appelOffre.getDateDebut());
			cahierDesCharges.setAppelOffre(appelOffre);
			appelOffre.setStatut(EtatAppelOffre.ENCOURS);
			appelDao.ajouterAppelOffre(appelOffre);
			cahierDao.ajouterCahierDesCharges(cahierDesCharges);
			/***** ajouter fichier cahier des charges****/
			
			if(UploadFileService.fileSelected()){
				Fichier fichier = (Fichier)context.getBean("fichier");
				FichierDAO fichierDao = (FichierDAO)context.getBean("fichierDao");
				fichier.setChemin("/entreprise/"+entreprise.getId());
				fichier.setTitre(cahierDesCharges.getSujet()+cahierDesCharges.getId());
				UploadFileService.uploadFichier(fichier);
				fichierDao.ajouterFichier(fichier);
				cahierDesCharges.getFichiers().add(fichier);
			}
			
			/*************/
			cahierDao.modifierCahierDesCharges(cahierDesCharges);
			entrepriseDao.modifierEntreprise(entreprise);
			// cahierDesCharges = null;

			remuneration = (Remuneration) context.getBean("remuneration");
			formation = (Formation) context.getBean("formation");
			experience = (Experience) context.getBean("experience");
			((ConfigurableApplicationContext) context).close();

			/* initialiser pour ajout apppel offre */
			formationsAppelOffre = new ArrayList<Formation>();
			experiencesAppelOffre = new ArrayList<Experience>();
			return "ajouterRemunerations.xhtml?faces-redirect=true";
		} else {
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
			ExperienceDAO experienceDao = (ExperienceDAO) context.getBean("experienceDao");
			for (Formation item : formationsAppelOffre) {
				item.setAppelOffre(appelOffre);
				formationDao.ajouterFormation(item);
				appelOffre.getQualifications().add(item);
			}
			for (Experience item : experiencesAppelOffre) {
				item.setAppelOffre(appelOffre);
				experienceDao.ajouterExperience(item);
				appelOffre.getQualifications().add(item);
			}

			AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
			appelOffreDao.modifierAppelOffre(appelOffre);
			((ConfigurableApplicationContext) context).close();
			appelOffres.add(appelOffre);
			return "afficherAppelsOffreEnCours.xhtml?faces-redirect=true";
		}
	}

	public String details() {
		// recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise) utilisateur;

		formationsAppelOffre = new ArrayList<Formation>();
		experiencesAppelOffre = new ArrayList<Experience>();
		for (Qualification qualification : appelOffre.getQualifications()) {
			if (qualification.getClass().equals(Formation.class)) {
				System.out.println("quualif");
				this.formationsAppelOffre.add((Formation) qualification);

			} else
				this.experiencesAppelOffre.add((Experience) qualification);
		}
		return "detailsAppelOffre.xhtml?faces-redirect=true";
	}

	public String contrePropositions() {
	
		return "/views/entreprise/contrePropositions.xhtml?faces-redirect=true";
	}

	/***
	 * PARTIE KHOULOUD
	 */

	/**
	 * La fonction permet de visualiser la liste des appels d'offre qui ont le
	 * statut ENCOURS. Elle redirige vers la vue "listeAppelOffres.xhtml"
	 */

	@Transactional
	public void listerAppelOffres() {
		// recuperer utilisateur sur etudiant
		this.etudiant = (Etudiant) utilisateur;

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		this.appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		this.listes = this.appelOffreDao.getAppelOffresByStatus(EtatAppelOffre.ENCOURS);
		// System.out.println(listes.get(0).getId()+"
		// "+listes.get(0).getStatut());
		((ConfigurableApplicationContext) context).close();

	}

	/**
	 * La fonction est appel�e lorsque l'�tudiant visualise le d�tail d'un appel
	 * d'offre.
	 */
	public String enregistrerContreProposition() {
		// recuperer utilisateur sur etudiant
		this.etudiant = (Etudiant) utilisateur;
		// Reduire le nombre de bids de l'�tudiant
		etudiant.setNombreBids(etudiant.getNombreBids() - 1);

		// Initialiser les param�tres de l'instance contreProposition
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);
		appelOffre.getContrePropositions().add(contreProposition);
		etudiant.getContrePropositions().add(contreProposition);

		// Ajouter unecontreProposition
		contrePropositionDao.ajouterContreProposition(contreProposition);
		etudiantDao.modifierEtudiant(etudiant);
		// modifier l appel d'offre par le nouveau
		// appelOffreDao.modifierAppelOffre(appelOffre);

		return "listeAppelOffres.xhtml?faces-redirect=true";
	}

	/**
	 * La fonction est appel�e pour d�tailler un appel d'offre Elle redirige
	 * vers la vue detailsAppelOffre.xhtml
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String detailsAppelOffre() {

		return "detailAppelOffre.xhtml?faces-redirect=true";
	}

	public int dejaPostuler() {
		// recuperer utilisateur sur etudiant
		this.etudiant = (Etudiant) utilisateur;

		for (ContreProposition contre : etudiant.getContrePropositions()) {
			if (contre.getAppelOffre().equals(appelOffre))
				return 1;
		}
		return 0;
	}

	private void verifierMeriteBadge(Etudiant etudiant) {
		// On vérifie si l'étudiant a fait un achévement méritant un badge
		// On récupère les evenements ayant comme source: Les projet
		List<EvenementBadge> evenementBadgesProjet = evenementBadgeDAO.getEvenementsBadgesBySource(SourceEvenement.TEST);
		
		//Vérifier si le nombre de projet mérite un badge que l'étudiant n'a pas déjà obtenu
		for(EvenementBadge evenementBadge: evenementBadgesProjet)
			if((evenementBadge.getValeur() <= etudiant.getProjets().size()) && (!etudiant.getBadges().contains(evenementBadge.getBadge())))
			{
				etudiant.getBadges().add(evenementBadge.getBadge());
				etudiantDao.modifierEtudiant(etudiant);
			}
	}

}
