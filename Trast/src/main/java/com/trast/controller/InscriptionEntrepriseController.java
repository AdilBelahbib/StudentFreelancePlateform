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

import com.trast.dao.EntrepriseDAO;
import com.trast.model.Adresse;
import com.trast.model.Entreprise;

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

		entrepriseDAO.ajouterEntreprise(entreprise);

		// Réinitialiser l'entreprise
		entreprise = (Entreprise) context.getBean("entreprise");
		((ConfigurableApplicationContext) context).close();
		System.out.println("Inscription réussie.");
	}
	
	
	
}
