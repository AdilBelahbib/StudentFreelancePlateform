package com.trast.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.AdministrateurDAO;
import com.trast.dao.AdresseDAO;
import com.trast.dao.EntrepriseDAO;
import com.trast.dao.FichierDAO;
import com.trast.model.Administrateur;
import com.trast.model.Adresse;
import com.trast.model.Entreprise;
import com.trast.model.EtatCompte;
import com.trast.model.Fichier;
import com.trast.service.UploadFileService;

@ManagedBean(name = "administrateurController", eager = true)
@SessionScoped
public class AdministrateurController implements Serializable {

	private static final long serialVersionUID = -3873111261048683675L;

	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	private Administrateur admin;
	
	@ManagedProperty(value = "#{administrateurDao}")
	private AdministrateurDAO adminDao;
	
	private List<Entreprise> entreprises;
	private Entreprise entreprise;
	private String motDePasse;

	@ManagedProperty(value = "#{adresse}")
	private Adresse adresse;
	
	@ManagedProperty(value = "#{adresseDao}")
	private AdresseDAO adresseDao;

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	public List<Entreprise> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	
	
	
	public AdministrateurDAO getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdministrateurDAO adminDao) {
		this.adminDao = adminDao;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public AdresseDAO getAdresseDao() {
		return adresseDao;
	}

	public void setAdresseDao(AdresseDAO adresseDao) {
		this.adresseDao = adresseDao;
	}

	public String getEntreprisesEnAttente() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO) context.getBean("entrepriseDao");
		entreprises = entrepriseDAO.getEntreprisesByEtatCompte(EtatCompte.EN_ATTENTE);
		((ConfigurableApplicationContext) context).close();

		return "/views/admin/listedemandesinscriptions.xhtml";
	}

	public void accepterEntreprise() {
		System.out.println("ACCEPTER");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO) context.getBean("entrepriseDao");

		// Mettre à jour l'état de l'entreprise
		entreprise.setEtatCompte(EtatCompte.ACTIVE);
		entrepriseDAO.modifierEntreprise(entreprise);
		((ConfigurableApplicationContext) context).close();

		entreprises.remove(entreprise);
	}

	public void refuserEntreprise() {
		System.out.println("REFUSER");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO) context.getBean("entrepriseDao");

		// Supprimer l'entreprise de la bdd
		entrepriseDAO.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext) context).close();

		entreprises.remove(entreprise);
	}

	// ajouter adresse a la liste des adresses de l admin
	public void ajouterAdresse() {
		adresse.setUtilisateur(admin);

		// Mettre à jour l'étudiant
		adresseDao.ajouterAdresse(adresse);

		admin.getAdresses().add(adresse);

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		adresse = (Adresse) context.getBean("adresse");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'admin retire une adresse
	public void retirerAdresse() {
		admin.getAdresses().remove(adresse);

		adresse.setUtilisateur(null);
		adresseDao.modifierAdresse(adresse);
		adresseDao.supprimerAdresse(adresse.getId());

		// Réinitialiser l'adresse par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		adresse = (Adresse) context.getBean("adresse");
		((ConfigurableApplicationContext) context).close();
	}
	
	public void modifierAdministrateur()
	{
		if(motDePasse != null)
			if(!motDePasse.equals(""))
				admin.setMotDePasse(motDePasse);
		
		adminDao.modifierAdministrateur(admin);;
	}
	
	/***********************************************/
	
	/* modifier avatar de l'admin*/
	
	/*************************************************/
	public void modifierAvatar(){
		// Si un fichier est s�lectionn�:
		if(UploadFileService.fileSelected()){
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			Fichier fichier = (Fichier)context.getBean("fichier");
			FichierDAO fichierDao = (FichierDAO)context.getBean("fichierDao");
			/* avatar a pour nom avatar*/
			System.out.println("id "+admin.getId());
			fichier.setChemin("/admin/"+admin.getId());
			fichier.setTitre("avatar");
			UploadFileService.uploadFichier(fichier);
			fichierDao.ajouterFichier(fichier);
			
			/* attribut avatar non implement� ***/
			/****************/
			/* associer file a l'entreprise*/
			admin.getFichiers().add(fichier);
			adminDao.modifierAdministrateur(admin);
			((ConfigurableApplicationContext) context).close();
		}
		
	}

}
