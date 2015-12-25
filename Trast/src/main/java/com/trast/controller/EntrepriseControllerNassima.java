package com.trast.controller;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.trast.dao.EntrepriseDAO;
import com.trast.model.Entreprise;

@ManagedBean(name = "entrepriseControllerNassima", eager = true)
@SessionScoped
public class EntrepriseControllerNassima implements Serializable{
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 713139923140386252L;
	// L'entreprise concernée
		@ManagedProperty(value = "#{entreprise}")
		private Entreprise entreprise;
		/* pour l'ajout d'un secteur lors de la modifcation du profil*/
		@ManagedProperty(value = "#{secteur}")
		String secteur;
		
public String getSecteur() {
			return secteur;
		}

		public void setSecteur(String secteur) {
			this.secteur = secteur;
			entreprise.getSecteurActivites().add(secteur);
			secteur="";
		}

/****************************************************************/
	
	// recuperer profil de l'entreprise:
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
			secteur="";
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

}
