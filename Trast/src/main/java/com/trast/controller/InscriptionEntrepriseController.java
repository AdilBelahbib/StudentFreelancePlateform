package com.trast.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.EntrepriseDAO;
import com.trast.dao.FichierDAO;
import com.trast.model.Adresse;
import com.trast.model.Entreprise;
import com.trast.model.Fichier;
import com.trast.service.Security;
import com.trast.service.UploadFileService;

@ManagedBean(name = "inscriptionEntrepriseController", eager = true)
@SessionScoped
public class InscriptionEntrepriseController implements Serializable {

	private static final long serialVersionUID = 1017995181310443923L;
	// L'entreprise concernée
	@ManagedProperty(value = "#{entreprise}")
	private Entreprise entreprise;
	// Utilisée pour récupérer les données d'une adresse lors de l'inscription
	@ManagedProperty(value = "#{adresse}")
	private Adresse adresse;
	// Utilisée pour récupérer le secteur d'activités saisi
	private String secteurActivites;

	// valeur du titre de fichier identite de l'entrprise
	@ManagedProperty(value = "#{proprietes['entrepriseIdentiteFile']}")
	String titreFichierIdentite;
	
	public String getTitreFichierIdentite() {
		return titreFichierIdentite;
	}

	public void setTitreFichierIdentite(String titreFichierIdentite) {
		this.titreFichierIdentite = titreFichierIdentite;
	}

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

	// La méthode appelée quand l'entreprise ajoute une adresse à sa liste
	public void ajouterAdresse() {
		entreprise.getAdresses().add(adresse);
		// Réinitialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		adresse = (Adresse) context.getBean("adresse");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'entreprise retire une adresse
	public void retirerAdresse() {
		entreprise.getAdresses().remove(adresse);
	}

	// La méthode appelée quand l'entreprise ajoute un secteur d'activités
	public void ajouterSecteurActivites() {
		entreprise.getSecteurActivites().add(secteurActivites);
		secteurActivites = new String();
	}

	// La méthode appelée quand l'entreprise retire un secteur d'activités
	public void retirerSecteurActivites() {
		entreprise.getSecteurActivites().remove(secteurActivites);
	}
	
	// La méthode appelée quand l'entreprise valide son inscription
	public void inscrire() {
		// Récupérer le DAO de l'entreprise et l'insérer dans la bdd
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO) context.getBean("entrepriseDao");
		
		//Hacher le mot de passe de l'étudiant
		entreprise.setMotDePasse(Security.get_SHA_1_SecurePassword(entreprise.getMotDePasse()));
		
		entrepriseDAO.ajouterEntreprise(entreprise);
		
		//Traitement des messages des erreus /Controle\
		FacesMessage message = new FacesMessage( "Inscription r�ussie !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
		
		/*** ajout pi�ce d'identit�**/
		if(UploadFileService.fileSelected()){
			Fichier fichier = (Fichier)context.getBean("fichier");
			FichierDAO fichierDao = (FichierDAO)context.getBean("fichierDao");

			fichier.setChemin("/entreprise/"+entreprise.getId());
			fichier.setTitre(titreFichierIdentite);
			UploadFileService.uploadFichier(fichier);
			fichierDao.ajouterFichier(fichier);
			/* associer file a l'entreprise*/
			entreprise.getFichiers().add(fichier);
			entrepriseDAO.modifierEntreprise(entreprise);
		}
		
		/******/
		

		// Réinitialiser l'entreprise
		entreprise = (Entreprise) context.getBean("entreprise");
		((ConfigurableApplicationContext) context).close();
	}
	
}
