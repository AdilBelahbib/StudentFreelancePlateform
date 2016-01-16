package com.trast.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.AdresseDAO;
import com.trast.dao.CompetenceDAO;
import com.trast.dao.EtudiantDAO;
import com.trast.dao.ExperienceDAO;
import com.trast.dao.FormationDAO;
import com.trast.dao.NiveauDAO;
import com.trast.model.Adresse;
import com.trast.model.Competence;
import com.trast.model.Etudiant;
import com.trast.model.Experience;
import com.trast.model.Formation;
import com.trast.model.Niveau;

@ManagedBean(name = "etudiantController", eager = true)
@SessionScoped
public class EtudiantController implements Serializable {

	private static final long serialVersionUID = -2165350133251436328L;

	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	private Etudiant etudiant;

	@ManagedProperty(value = "#{etudiantDao}")
	private EtudiantDAO etudiantDao;

	@ManagedProperty(value = "#{adresseDao}")
	private AdresseDAO adresseDao;

	@ManagedProperty(value = "#{formationDao}")
	private FormationDAO formationDao;
	
	@ManagedProperty(value = "#{competenceDao}")
	private CompetenceDAO competenceDao;
	
	@ManagedProperty(value = "#{experienceDao}")
	private ExperienceDAO experienceDao;

	// Utilisée pour récupérer les données d'une adresse lors de l'inscription
	@ManagedProperty(value = "#{adresse}")
	private Adresse adresse;
	// Utilisée pour récupérer les données d'une formation lors de l'inscription
	@ManagedProperty(value = "#{formation}")
	private Formation formation;
	// Utilisée pour récupérer les données d'une formation lors de l'inscription
	@ManagedProperty(value = "#{competence}")
	private Competence competence;
	// Utilisée pour récupérer les données d'une formation lors de l'inscription
	@ManagedProperty(value = "#{experience}")
	private Experience experience;

	private String motDePasse;
	
	
	
	public CompetenceDAO getCompetenceDao() {
		return competenceDao;
	}

	public void setCompetenceDao(CompetenceDAO competenceDao) {
		this.competenceDao = competenceDao;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public EtudiantDAO getEtudiantDao() {
		return etudiantDao;
	}

	public void setEtudiantDao(EtudiantDAO etudiantDao) {
		this.etudiantDao = etudiantDao;
	}

	public AdresseDAO getAdresseDao() {
		return adresseDao;
	}

	public void setAdresseDao(AdresseDAO adresseDao) {
		this.adresseDao = adresseDao;
	}

	public FormationDAO getFormationDao() {
		return formationDao;
	}

	public void setFormationDao(FormationDAO formationDao) {
		this.formationDao = formationDao;
	}

	public ExperienceDAO getExperienceDao() {
		return experienceDao;
	}

	public void setExperienceDao(ExperienceDAO experienceDao) {
		this.experienceDao = experienceDao;
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
	
	
	// La méthode appelée quand l'étudiant ajoute une adresse à sa liste
	public void ajouterAdresse() {
		adresse.setUtilisateur(etudiant);

		// Mettre à jour l'étudiant
		adresseDao.ajouterAdresse(adresse);

		etudiant.getAdresses().add(adresse);

		// Réinitialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		adresse = (Adresse) context.getBean("adresse");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'étudiant retire une adresse
	public void retirerAdresse() {
		etudiant.getAdresses().remove(adresse);

		adresse.setUtilisateur(null);
		adresseDao.modifierAdresse(adresse);
		adresseDao.supprimerAdresse(adresse.getId());

		// Réinitialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		adresse = (Adresse) context.getBean("adresse");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'étudiant ajoute une formation à sa liste des
	// formations
	public void ajouterFormation() {
		formation.setEtudiant(etudiant);
		etudiant.getQualifications().add(formation);

		formationDao.ajouterFormation(formation);

		// Réinitialiser la formation par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		formation = (Formation) context.getBean("formation");
		((ConfigurableApplicationContext) context).close();
	}
	
	// La méthode appelée quand l'étudiant ajoute une competence à sa liste des
		// competences
		public void ajouterCompetence() {
			// Réinitialiser la formation par une nouvelle instance vide
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			
			Niveau niveau = (Niveau)context.getBean("niveau"); 
			NiveauDAO niveauDao = (NiveauDAO) context.getBean("niveauDao");
			
			competence = competenceDao.ajouterCompetenceIfNotExist(competence);
			
			niveau.setCompetence(competence);
			niveau.setMaitrise(0);
			niveau.setEtudiant(etudiant);
			//System.out.println("id Competence ==> "+competence.getId());
			//System.out.println("id Etud ==> "+etudiant.getId());
			niveauDao.ajouterNiveau(niveau);
			etudiant.getNiveaux().add(niveau);
			etudiantDao.modifierEtudiant(etudiant);
			competence = (Competence)context.getBean("competence");
			//maitrise a voir 
			((ConfigurableApplicationContext) context).close();
		}

	// La méthode appelée quand l'étudiant retire une formation
	public void retirerFormation() {
		etudiant.getQualifications().remove(formation);

		formation.setEtudiant(null);
		formationDao.modifierFormation(formation);
		
		formationDao.supprimerFormation(formation.getId());

		// Réinitialiser la formation par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		formation = (Formation) context.getBean("formation");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'étudiant ajoute une expérience à sa liste
	public String ajouterExperience() {
		
		experience.setEtudiant(etudiant);
		etudiant.getQualifications().add(experience);
		
		experienceDao.ajouterExperience(experience);
		
		// Réinitialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		experience = (Experience) context.getBean("experience");
		((ConfigurableApplicationContext) context).close();
		return "/views/etudiant/profil.xhtml?faces-redirect=true";
	}

	// La méthode appelée quand l'étudiant retire une experience
	public void retirerExperience() {
		etudiant.getQualifications().remove(experience);
		
		experience.setEtudiant(null);
		experienceDao.modifierExperience(experience);
		
		experienceDao.supprimerExperience(experience.getId());

		// Réinitialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		experience = (Experience) context.getBean("experience");
		((ConfigurableApplicationContext) context).close();
	}
	
	public void modifierEtudiant()
	{
		if(motDePasse != null)
			if(!motDePasse.equals(""))
				etudiant.setMotDePasse(motDePasse);
		
		etudiantDao.modifierEtudiant(etudiant);
	}

}
