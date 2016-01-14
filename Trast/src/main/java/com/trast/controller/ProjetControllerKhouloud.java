package com.trast.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.EtudiantDAO;
import com.trast.dao.EvenementBadgeDAO;
import com.trast.dao.LivrableDAO;
import com.trast.dao.ProjetDAO;
import com.trast.model.Entreprise;
import com.trast.model.EtatProjet;
import com.trast.model.Etudiant;
import com.trast.model.EvenementBadge;
import com.trast.model.Livrable;
import com.trast.model.Projet;
import com.trast.model.SourceEvenement;
import com.trast.model.Utilisateur;
import com.trast.service.DateCalculService;

@ManagedBean(name = "projetControllerKhouloud", eager = true)
@SessionScoped
public class ProjetControllerKhouloud {

	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	Utilisateur utilisateur;

	@ManagedProperty(value = "#{etudiant}")
	private Etudiant etudiant;

	@ManagedProperty(value = "#{entreprise}")
	private Entreprise entreprise;

	@ManagedProperty(value = "#{livrable}")
	private Livrable livrable;

	@ManagedProperty(value = "#{livrableDao}")
	private LivrableDAO livrableDao;

	@ManagedProperty(value = "#{projetDao}")
	private ProjetDAO projetDao;

	@ManagedProperty(value = "#{projet}")
	private Projet projet;
	
	@ManagedProperty(value = "#{evenementBadgeDao}")
	private EvenementBadgeDAO evenementBadgeDAO;
	
	@ManagedProperty(value = "#{etudiantDao}")
	private EtudiantDAO etudiantDao;

	private List<Projet> listeProjets;
	private List<Projet> listeProjetsTermines;
	private List<Livrable> listeLivrables;
	private String nbJoursRestants;
	private double avancementProjet;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public ProjetDAO getProjetDao() {
		return projetDao;
	}

	public void setProjetDao(ProjetDAO projetDao) {
		this.projetDao = projetDao;
	}

	public List<Projet> getListeProjets() {
		return listeProjets;
	}

	public void setListeProjets(List<Projet> listeProjets) {
		this.listeProjets = listeProjets;
	}

	public List<Livrable> getListeLivrables() {
		return listeLivrables;
	}

	public void setListeLivrables(List<Livrable> listeLivrables) {
		this.listeLivrables = listeLivrables;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Livrable getLivrable() {
		return livrable;
	}

	public void setLivrable(Livrable livrable) {
		this.livrable = livrable;
	}

	public LivrableDAO getLivrableDao() {
		return livrableDao;
	}

	public void setLivrableDao(LivrableDAO livrableDao) {
		this.livrableDao = livrableDao;
	}

	public String getNbJoursRestants() {
		return nbJoursRestants;
	}

	public void setNbJoursRestants(String nbJoursRestants) {
		this.nbJoursRestants = nbJoursRestants;
	}

	public double getAvancementProjet() {
		return avancementProjet;
	}

	public void setAvancementProjet(double avancementProjet) {
		this.avancementProjet = avancementProjet;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public List<Projet> getListeProjetsTermines() {
		return listeProjetsTermines;
	}

	public void setListeProjetsTermines(List<Projet> listeProjetsTermines) {
		this.listeProjetsTermines = listeProjetsTermines;
	}

	public EvenementBadgeDAO getEvenementBadgeDAO() {
		return evenementBadgeDAO;
	}

	public void setEvenementBadgeDAO(EvenementBadgeDAO evenementBadgeDAO) {
		this.evenementBadgeDAO = evenementBadgeDAO;
	}
	
	public EtudiantDAO getEtudiantDao() {
		return etudiantDao;
	}

	public void setEtudiantDao(EtudiantDAO etudiantDao) {
		this.etudiantDao = etudiantDao;
	}

	/**
	 * Cette fonction r�cup�re l'ensemble des projets d'un �tudiant. Elle est
	 * appel�e pour visualiser la liste de ses projets.
	 */

	public void getAllProjetsByEtudiant() {
		// recuperer utilisateur sur etudiant
		this.etudiant = (Etudiant) utilisateur;
		listeProjets = projetDao.getProjetsByEtudiant(etudiant);
	}

	/**
	 * Cette fonction r�cup�re l'ensemble des projets d'une entreprise. Elle est
	 * appel�e pour visualiser la liste de ses projets.
	 */

	public void getAllProjetsByEntreprise() {
		// recuperer utilisateur sur entreprise
		/*
		 * this.entreprise = (Entreprise)utilisateur; listeProjets =
		 * projetDao.getProjetsByEntreprise(entreprise);
		 */
		if (listeProjets == null) {
			listeProjets = new ArrayList<Projet>();
			if (listeProjetsTermines == null)
				listeProjetsTermines = new ArrayList<Projet>();
			this.entreprise = (Entreprise) utilisateur;
			for (Projet item : entreprise.getProjets()) {
				if (item.getStatut().equals(EtatProjet.ENCOURS))
					listeProjets.add(item);
				else if (item.getStatut().equals(EtatProjet.TERMINE))
					listeProjetsTermines.add(item);
			}
		}

	}

	public void getAllProjetsTermines() {
		// recuperer utilisateur sur entreprise
		/*
		 * this.entreprise = (Entreprise)utilisateur; listeProjets =
		 * projetDao.getProjetsByEntreprise(entreprise);
		 */
		if (listeProjetsTermines == null) {
			if (listeProjets == null)
				listeProjets = new ArrayList<Projet>();
			listeProjetsTermines = new ArrayList<Projet>();
			this.entreprise = (Entreprise) utilisateur;
			for (Projet item : entreprise.getProjets()) {
				if (item.getStatut().equals(EtatProjet.ENCOURS))
					listeProjets.add(item);
				else if (item.getStatut().equals(EtatProjet.TERMINE))
					listeProjetsTermines.add(item);
			}
		}

	}

	/**
	 * Cette fonction est appel�e � parti du d�tail d'un projet, et elle affiche
	 * la liste des livrables du projet choisi.
	 *
	 * Elle redirige vers la vue listeLivrable.xhtml
	 */

	public String listerLivrables() {
		Set<Livrable> listes = projet.getLivrables();
		listeLivrables = new ArrayList<Livrable>(listes);

		return "listeLivrables.xhtml?faces-redirect=true";
	}

	/**
	 * Une m�thode pour r�cup�rer le dernier �lement d'une collection Utilis�
	 * pour: - recuperer le dernier livrable
	 */

	public Object getLastElement(final Collection<?> c) {
		final Iterator<?> itr = c.iterator();
		Object lastElement = itr.next();
		while (itr.hasNext()) {
			lastElement = itr.next();
		}
		return lastElement;
	}

	/**
	 * Fonction redirection vers details d'un projet Utilis� pour calculer la
	 * dur�e restante pour la fin du projet et pour r�cuperer l'avancement du
	 * projet
	 */

	public String detailProjet() {
		Date d = new Date();
		// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// String dat = dateFormat.format(d);
		System.out.println("date jour = " + d.getTime());
		System.out.println("Date fin == " + projet.getCahierDesCharges().getDateFin().getTime());
		nbJoursRestants = DateCalculService.calculDuree(new Date(), projet.getCahierDesCharges().getDateFin());
		// Recuperer le dernier livrable
		// System.out.println("Taille livr liste =
		// "+projet.getLivrables().size() );
		if (projet.getLivrables().size() > 0) {
			livrable = (Livrable) getLastElement(projet.getLivrables());

			avancementProjet = livrable.getPourcentageAvancement();
		} else
			avancementProjet = 0;
		// R�initialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();
		return "detailsProjet.xhtml?faces-redirect=true";
	}

	/**
	 * Cette m�thode est appel�e par liste des projets cote ENTREPRISE; Elle
	 * permet de visualiser le d�tail des projets et leurs livrables
	 * 
	 * Elle redirige vers la page detailsProjet
	 */
	public String detailProjetLivrable() {
		Date d = new Date();
		// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// String dat = dateFormat.format(d);
		System.out.println("date jour = " + d.getTime());
		System.out.println("Date fin == " + projet.getCahierDesCharges().getDateFin().getTime());
		nbJoursRestants = DateCalculService.calculDuree(new Date(), projet.getCahierDesCharges().getDateFin());
		// Recuperer le dernier livrable
		// System.out.println("Taille livr liste =
		// "+projet.getLivrables().size() );
		if (projet.getLivrables().size() > 0) {
			livrable = (Livrable) getLastElement(projet.getLivrables());

			avancementProjet = livrable.getPourcentageAvancement();

			Set<Livrable> listes = projet.getLivrables();
			listeLivrables = new ArrayList<Livrable>(listes);
		} else
			avancementProjet = 0;
		// R�initialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();
		return "detailsProjet.xhtml?faces-redirect=true";
	}

	/**
	 * Cette fonction permet l'ajout d'un livrable d'un projet Puis, elle
	 * redirige vers la liste des projets
	 */
	public String enregistrerLivrable() {
		// System.out.println(" id projet " + projet.getId());
		// Initialiser les param�tres de l'instance projet
		livrable.setProjet(projet);
		Date d = new Date();
		livrable.setDateLivraison(d);
		projet.getLivrables().add(livrable);

		// Ajouter un livrable
		livrableDao.ajouterLivrable(livrable);
		// R�initialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();

		return "listeProjets.xhtml?faces-redirect=true";
	}

	public void validerLivrable() {
		livrable.setProjet(projet);
		livrable.setValide(true);
		// Modifier le livrable
		livrableDao.modifierLivrable(livrable);
		// R�initialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();
	}

	public void refuserLivrable() {
		livrable.setProjet(projet);
		livrable.setValide(false);
		// Modifier le livrable
		livrableDao.modifierLivrable(livrable);
		// R�initialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();
	}

	public void modifierLivrable() {
		livrable.setProjet(projet);

		// Modifier le livrable
		livrableDao.modifierLivrable(livrable);
		// R�initialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();

	}

	/** valide le projet */
	public void validerProjet(String v) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		/* livrable : */
		/*
		 * livrable.setProjet(projet); livrable.setValide(true); // Modifier le
		 * livrable livrableDao.modifierLivrable(livrable);
		 */
		// R�initialiser par une nouvelle instance vide
		/*
		 * livrable = (Livrable) context.getBean("livrable");
		 */
		/* Livrables */
		for (Livrable item : projet.getLivrables()) {
			if (!item.getValide()) {
				item.setProjet(projet);
				item.setValide(true);
				livrableDao.modifierLivrable(item);

			}
		}
		/* projet : */
		projet.setStatut(EtatProjet.TERMINE);
		projetDao.modifierProjet(projet);
		//

		/* add projet to projets termin�s */
		listeProjetsTermines.add(projet);
		listeProjets.remove(projet);

		/* avis sur etudiant */
		if (v.equals("1")) {
			projet.getEtudiant().setAvisPositifs(projet.getEtudiant().getAvisPositifs() + 1);
			verifierMeriteBadge();
		} else
			projet.getEtudiant().setAvisNegatifs(projet.getEtudiant().getAvisNegatifs() + 1);

		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		etudiantDao.modifierEtudiant(projet.getEtudiant());
		((ConfigurableApplicationContext) context).close();
	}

	private void verifierMeriteBadge() {
		// On vérifie si l'étudiant a fait un achévement méritant un badge
		// On récupère les evenements ayant comme source: Avis positif
		List<EvenementBadge> evenementBadgesProjet = evenementBadgeDAO.getEvenementsBadgesBySource(SourceEvenement.AVISPOSITIF);

		// Vérifier si le nombre de projet mérite un badge que l'étudiant n'a
		// pas déjà obtenu
		for (EvenementBadge evenementBadge : evenementBadgesProjet)
			if ((evenementBadge.getValeur() <= etudiant.getAvisPositifs())
					&& (!etudiant.getBadges().contains(evenementBadge.getBadge()))) {
				etudiant.getBadges().add(evenementBadge.getBadge());
				etudiantDao.modifierEtudiant(etudiant);
			}
	}
}
