package com.trast.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.trast.dao.LivrableDAO;
import com.trast.dao.ProjetDAO;
import com.trast.model.Adresse;
import com.trast.model.Entreprise;
import com.trast.model.Etudiant;
import com.trast.model.Livrable;
import com.trast.model.Projet;
import com.trast.model.Utilisateur;

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

	private List<Projet> listeProjets;

	private List<Livrable> listeLivrables;
	private int nbJoursRestants;
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
	

	public int getNbJoursRestants() {
		return nbJoursRestants;
	}

	public void setNbJoursRestants(int nbJoursRestants) {
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

	/**
	 * Cette fonction récupère l'ensemble des projets d'un étudiant. Elle est
	 * appelée pour visualiser la liste de ses projets.
	 */

	public void getAllProjetsByEtudiant() {
		//recuperer utilisateur sur etudiant
		this.etudiant = (Etudiant)utilisateur;
		listeProjets = projetDao.getProjetsByEtudiant(etudiant);
	}
	
	/**
	 * Cette fonction récupère l'ensemble des projets d'une entreprise. Elle est
	 * appelée pour visualiser la liste de ses projets.
	 */

	public void getAllProjetsByEntreprise() {
		//recuperer utilisateur sur entreprise
		this.entreprise = (Entreprise)utilisateur;
		listeProjets = projetDao.getProjetsByEntreprise(entreprise);
	}
	
	
	/**
	 * Cette fonction est appelée à parti du détail d'un projet, et elle affiche
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
	 * Une méthode pour récupérer le dernier élement d'une collection
	 * Utilisé pour: 
	 * - recuperer le dernier livrable
	 */
	
	public Object getLastElement(final Collection<?> c) {
	    final Iterator<?> itr = c.iterator();
	    Object lastElement = itr.next();
	    while(itr.hasNext()) {
	        lastElement=itr.next();
	    }
	    return lastElement;
	}
	
	/**
	 * Fonction redirection vers details d'un projet
	 * Utilisé pour calculer la durée restante pour la fin du projet 
	 * et pour récuperer l'avancement du projet
	 */
	
	@SuppressWarnings("deprecation")
	public String detailProjet() {
		Date d=new Date();
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//String dat = dateFormat.format(d);
		System.out.println("date jour = "+ d.getTime());
		System.out.println("Date fin == "+ projet.getCahierDesCharges().getDateFin().getTime());
		nbJoursRestants = (projet.getCahierDesCharges().getDateFin().getDate() -  d.getDate());
		//Recuperer le dernier livrable 
		//System.out.println("Taille livr liste = "+projet.getLivrables().size() );
		if(projet.getLivrables().size() > 0)
		{
			livrable = (Livrable) getLastElement(projet.getLivrables());
		
			avancementProjet = livrable.getPourcentageAvancement();
		}
		else
			avancementProjet = 0;
		// Réinitialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();
		return "detailsProjet.xhtml?faces-redirect=true";
	}
	
	/**
	 * Cette méthode est appelée par liste des projets cote ENTREPRISE;
	 * Elle permet de visualiser le détail des projets et leurs livrables
	 * 
	 * Elle redirige vers la page detailsProjet
	 */
	@SuppressWarnings("deprecation")
	public String detailProjetLivrable() {
		Date d=new Date();
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//String dat = dateFormat.format(d);
		System.out.println("date jour = "+ d.getTime());
		System.out.println("Date fin == "+ projet.getCahierDesCharges().getDateFin().getTime());
		nbJoursRestants = (projet.getCahierDesCharges().getDateFin().getDate() -  d.getDate());
		//Recuperer le dernier livrable 
		//System.out.println("Taille livr liste = "+projet.getLivrables().size() );
		if(projet.getLivrables().size() > 0)
		{
			livrable = (Livrable) getLastElement(projet.getLivrables());
		
			avancementProjet = livrable.getPourcentageAvancement();
			

			Set<Livrable> listes = projet.getLivrables();
			listeLivrables = new ArrayList<Livrable>(listes);
		}
		else
			avancementProjet = 0;
		// Réinitialiser par une nouvelle instance vide
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
		//System.out.println(" id projet " + projet.getId());
		// Initialiser les paramètres de l'instance projet
		livrable.setProjet(projet);
		Date d=new Date();
		livrable.setDateLivraison(d);
		projet.getLivrables().add(livrable);

		// Ajouter un livrable
		livrableDao.ajouterLivrable(livrable);
		// Réinitialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();

		return "listeProjets.xhtml?faces-redirect=true";
	}
	
	public void validerLivrable(){
		livrable.setProjet(projet);
		livrable.setValide(true);
		// Modifier le livrable
		livrableDao.modifierLivrable(livrable);
		// Réinitialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();
	}
	
	public void refuserLivrable(){
		livrable.setProjet(projet);
		livrable.setValide(false);
		// Modifier le livrable
		livrableDao.modifierLivrable(livrable);
		// Réinitialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();
	}
	
	public void modifierLivrable(){
		livrable.setProjet(projet);

		// Modifier le livrable
		livrableDao.modifierLivrable(livrable);
		// Réinitialiser par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		livrable = (Livrable) context.getBean("livrable");
		((ConfigurableApplicationContext) context).close();

	}
}
