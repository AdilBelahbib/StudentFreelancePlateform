package com.trast.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.EntrepriseDAO;
import com.trast.model.Administrateur;
import com.trast.model.Entreprise;
import com.trast.model.EtatCompte;

@ManagedBean(name = "administrateurController", eager = true)
@SessionScoped
public class AdministrateurController implements Serializable {

	private static final long serialVersionUID = -3873111261048683675L;
	
	@ManagedProperty(value = "#{adminitrateur}")
	private Administrateur admin;
	private List<Entreprise> entreprises;
	private Entreprise entreprise;
	
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

	public String getEntreprisesEnAttente()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO) context.getBean("entrepriseDao");
		entreprises = entrepriseDAO.getEntreprisesByEtatCompte(EtatCompte.EN_ATTENTE);
		((ConfigurableApplicationContext)context).close();
		
		return "/views/admin/listedemandesinscriptions.xhtml";
	}
	
	public void accepterEntreprise()
	{
		System.out.println("ACCEPTER");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO) context.getBean("entrepriseDao");
		
		//Mettre à jour l'état de l'entreprise
		entreprise.setEtatCompte(EtatCompte.ACTIVE);
		entrepriseDAO.modifierEntreprise(entreprise);
		((ConfigurableApplicationContext)context).close();
		
		entreprises.remove(entreprise);
	}
	
	public void refuserEntreprise()
	{
		System.out.println("REFUSER");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO) context.getBean("entrepriseDao");
		
		//Supprimer l'entreprise de la bdd
		entrepriseDAO.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
		
		entreprises.remove(entreprise);
	}
}
