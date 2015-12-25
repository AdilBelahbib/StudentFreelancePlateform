package com.trast.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.AppelOffreDAO;
import com.trast.dao.CahierDesChargesDAO;
import com.trast.dao.CompetenceDAO;
import com.trast.dao.EntrepriseDAO;
import com.trast.dao.ExperienceDAO;
import com.trast.dao.FormationDAO;
import com.trast.dao.RemunerationDAO;
import com.trast.model.Adresse;
import com.trast.model.AppelOffre;
import com.trast.model.CahierDesCharges;
import com.trast.model.Competence;
import com.trast.model.Entreprise;
import com.trast.model.Experience;
import com.trast.model.Fichier;
import com.trast.model.Formation;
import com.trast.model.Qualification;
import com.trast.model.Remuneration;

@ManagedBean(name = "appelOffreControllerNassima", eager = true)
@SessionScoped
public class AppelOffreControllerNassima implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2671155118015679305L;
	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	Entreprise entreprise;
	@ManagedProperty(value = "#{appelOffre}")
	AppelOffre appelOffre;
	@ManagedProperty(value = "#{appelOffres}")
	List<AppelOffre> appelOffres;
	
	/* pour creation d'un appel offre*/
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
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
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

/*****************************************************/
	
	public void ajouterCompetence(){
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			/* verifier si ca existe deja*/
			CompetenceDAO competenceDao = (CompetenceDAO)context.getBean("competenceDao");
			boolean exist = competenceDao.ajouterCompetenceIfNotExist(competence);
			appelOffre.getCompetences().add(competence);
			competence = (Competence)context.getBean("competence");
			((ConfigurableApplicationContext) context).close();	
			
			System.out.println("**** ajout "+competence.getIntitule()+" res "+exist);
	}
	public void retirerCompetence(){
		this.appelOffre.getCompetences().remove(competence);
	}
	public void ajouterRemuneration(){
		remuneration.setAppelOffre(appelOffre);
		this.appelOffre.getRemunerations().add(remuneration);
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		RemunerationDAO remunerationDao= (RemunerationDAO) context.getBean("remunerationDao");
		remunerationDao.ajouterRemuneration(remuneration);
		remuneration= (Remuneration) context.getBean("remuneration");
		((ConfigurableApplicationContext) context).close();
	}
	public void retirerRemuneration(){
		this.appelOffre.getRemunerations().remove(remuneration);
	}
	
	public void ajouterFormation(){
		formationsAppelOffre.add(formation);
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		formation= (Formation) context.getBean("formation");
		((ConfigurableApplicationContext) context).close();
	}
	public void retirerFormation(){
		formationsAppelOffre.remove(formation);
	}

	public void ajouterExperience(){
		experiencesAppelOffre.add(experience);
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		experience= (Experience) context.getBean("experience");
		((ConfigurableApplicationContext) context).close();
	}
	public void retirerExperience(){
		experiencesAppelOffre.remove(experience);
	}
	
	/************************************************************/
	public String afficherAppelsOffre(){
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		/* recuperer entrprise avec ID*/
		appelOffres = new ArrayList<AppelOffre>(entreprise.getAppelOffres());
		System.out.println("app "+entreprise.getAppelOffres().size()+", rec "+appelOffres.size());
		/* initialiser appel d'offre et cahierdescharges pour une eventuelle creation*/
		 cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		 appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		((ConfigurableApplicationContext)context).close();

		return "afficherAppelsOffre";
	}

	public String ajouterAppelOffre(){
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String requete = request.getParameter("requete");
		if(requete.equals("get"))
		{
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CahierDesChargesDAO  cahierDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		AppelOffreDAO  appelDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		
		
		System.out.println("date "+appelOffre.getDateExpiration()+" , "+fichier.getTitre());
		appelOffre.setDateDebut(cahierDesCharges.getDateDebut());
		appelOffre.setEntreprise(entreprise);
		appelOffre.setCahierDesCharges(cahierDesCharges);
		cahierDesCharges.setDateDebut(appelOffre.getDateDebut());
		cahierDesCharges.setAppelOffre(appelOffre);
		appelDao.ajouterAppelOffre(appelOffre);
		cahierDao.ajouterCahierDesCharges(cahierDesCharges);
		entrepriseDao.modifierEntreprise(entreprise);
		//cahierDesCharges = null;
		
		
		remuneration= (Remuneration) context.getBean("remuneration");
		formation= (Formation) context.getBean("formation");
		experience= (Experience) context.getBean("experience");
		((ConfigurableApplicationContext)context).close();
		
		/* initialiser pour ajout apppel offre */
		formationsAppelOffre = new ArrayList<Formation>();
		experiencesAppelOffre = new ArrayList<Experience>();
		return "ajouterRemunerations";
		}
		else{
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			FormationDAO formationDao= (FormationDAO) context.getBean("formationDao");
			ExperienceDAO experienceDao= (ExperienceDAO) context.getBean("experienceDao");
			for(Formation item : formationsAppelOffre){
				item.setAppelOffre(appelOffre);
				formationDao.ajouterFormation(item);
				appelOffre.getQualifications().add(item);
			}
			for(Experience item : experiencesAppelOffre){
				item.setAppelOffre(appelOffre);
				experienceDao.ajouterExperience(item);
				appelOffre.getQualifications().add(item);
			}
			
			AppelOffreDAO appelOffreDao =(AppelOffreDAO) context.getBean("appelOffreDao");
			appelOffreDao.modifierAppelOffre(appelOffre);
			((ConfigurableApplicationContext)context).close();
			appelOffres.add(appelOffre);
			return "afficherAppelsOffre";
		}
	}
	public String details(){
		formationsAppelOffre = new ArrayList<Formation>();
		experiencesAppelOffre = new ArrayList<Experience>();
		for(Qualification qualification : appelOffre.getQualifications()){
			if(qualification.getClass().equals(Formation.class)){
				System.out.println("quualif");
				this.formationsAppelOffre.add((Formation) qualification);
				
			}
			else this.experiencesAppelOffre.add((Experience)qualification);
		}
		return "detailsAppelOffre";
	}
	public String contrePropositions(){
		return "contrePropositions";
	}
	

}
