package com.trast.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.AdresseDAO;
import com.trast.dao.EntrepriseDAO;
import com.trast.dao.FichierDAO;
import com.trast.model.Adresse;
import com.trast.model.Entreprise;
import com.trast.model.Fichier;
import com.trast.service.Security;
import com.trast.service.UploadFileService;

@ManagedBean(name = "entrepriseController", eager = true)
@SessionScoped
public class EntrepriseController implements Serializable {

	private static final long serialVersionUID = 6158707672711389644L;

	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	private Entreprise entreprise;

	@ManagedProperty(value = "#{adresse}")
	private Adresse adresse;

	@ManagedProperty(value = "#{entrepriseDao}")
	private EntrepriseDAO entrepriseDao;

	@ManagedProperty(value = "#{adresseDao}")
	private AdresseDAO adresseDao;
	
	

	private String secteurActivites;
	private String motDePasse;

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getSecteurActivites() {
		return secteurActivites;
	}

	public void setSecteurActivites(String secteurActivites) {
		this.secteurActivites = secteurActivites;
	}
	
	public EntrepriseDAO getEntrepriseDao() {
		return entrepriseDao;
	}

	public void setEntrepriseDao(EntrepriseDAO entrepriseDao) {
		this.entrepriseDao = entrepriseDao;
	}

	public AdresseDAO getAdresseDao() {
		return adresseDao;
	}

	public void setAdresseDao(AdresseDAO adresseDao) {
		this.adresseDao = adresseDao;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	

	// La méthode appelée quand l'entreprise ajoute une adresse à sa liste
	public void ajouterAdresse() {
		adresse.setUtilisateur(entreprise);
		adresseDao.ajouterAdresse(adresse);
		
		// Mettre à jour l'entreprise
		entreprise.getAdresses().add(adresse);

		// Réinitialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		adresse = (Adresse) context.getBean("adresse");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'entreprise retire une adresse
	public void retirerAdresse() {
		entreprise.getAdresses().remove(adresse);
		
		adresse.setUtilisateur(null);
		adresseDao.modifierAdresse(adresse);
		adresseDao.supprimerAdresse(adresse.getId());

		// Réinitialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		adresse = (Adresse) context.getBean("adresse");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'entreprise ajoute un secteur d'activités
	public void ajouterSecteurActivites() {
		entreprise.getSecteurActivites().add(secteurActivites);
		
		entrepriseDao.modifierEntreprise(entreprise);
		
		secteurActivites = new String();
	}

	// La méthode appelée quand l'entreprise retire un secteur d'activités
	public void retirerSecteurActivites() {
		entreprise.getSecteurActivites().remove(secteurActivites);
		
		entrepriseDao.modifierEntreprise(entreprise);
	}
	
	public void modifierEntreprise()
	{
		if(motDePasse != null)
			if(!motDePasse.equals(""))
				entreprise.setMotDePasse(Security.get_SHA_1_SecurePassword(motDePasse));

		entrepriseDao.modifierEntreprise(entreprise);
	}

	//Methodes Nassima
	public String profil(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
				
		HttpSession session = request.getSession();
		this.entreprise = (Entreprise) session.getAttribute("utilisateur");
		return "profil";
	}
	
	public String modifierProfil(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String requete = request.getParameter("requete");
		System.out.println("********req "+requete);
		if(requete.equals("get")) return "modifierProfil";
		else{
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
			entrepriseDao.modifierEntreprise(entreprise);
			((ConfigurableApplicationContext)context).close();
			return "profil";
		}
	}
	
	public String modifierCompte(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String requete = request.getParameter("requete");
		System.out.println("********req "+requete);
		if(requete.equals("get")) return "modifierCompte";
		else{
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
			entrepriseDao.modifierEntreprise(entreprise);
			((ConfigurableApplicationContext)context).close();
			return "profil";
		}
	}
	

	/***********************************************/
	
	/* modifier avatar de l'entreprise*/
	
	/*************************************************/
	public void modifierAvatar(){
		// Si un fichier est s�lectionn�:
		if(UploadFileService.fileSelected()){
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EntrepriseDAO entrepriseDAO = (EntrepriseDAO) context.getBean("entrepriseDao");
			Fichier fichier = (Fichier)context.getBean("fichier");
			FichierDAO fichierDao = (FichierDAO)context.getBean("fichierDao");
			
			/* supprimer l'ancien avatar*/
			Fichier ancienAvatar = entreprise.getAvatar();
			if(ancienAvatar!=null) fichierDao.supprimerFichier(ancienAvatar.getId());
			
			/* avatar a pour nom avatar*/
			fichier.setChemin("/entreprise/"+entreprise.getId());
			fichier.setTitre("avatar");
			UploadFileService.uploadFichier(fichier);
			fichierDao.ajouterFichier(fichier);
			
			/* associer file a l'entreprise*/
			entreprise.setAvatar(fichier);
			//entreprise.getFichiers().add(fichier);
			entrepriseDAO.modifierEntreprise(entreprise);
			((ConfigurableApplicationContext) context).close();
		}
		
	}
}
