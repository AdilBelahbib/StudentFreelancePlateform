package com.trast.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.EtudiantDAO;
import com.trast.model.Adresse;
import com.trast.model.Etudiant;
import com.trast.model.Experience;
import com.trast.model.Formation;

@ManagedBean(name = "etudiantController", eager = true)
@SessionScoped
public class EtudiantController implements Serializable {

	private static final long serialVersionUID = 1754286458443067247L;

	// L'étudiant concerné
	@ManagedProperty(value = "#{etudiant}")
	private Etudiant etudiant;

	// Utilisée pour récupérer les données d'une formation lors de l'inscription
	@ManagedProperty(value = "#{formation}")
	private Formation formation;
	// Utilisée pour récupérer les données d'une formation lors de l'inscription
	@ManagedProperty(value = "#{experience}")
	private Experience experience;
	// Utilisée pour récupérer les données d'une adresse lors de l'inscription
	@ManagedProperty(value = "#{adresse}")
	private Adresse adresse;

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	// La méthode appelée quand l'étudiant ajoute une formation à sa liste des
	// formations
	public void ajouterFormation() {
		formation.setEtudiant(etudiant);
		etudiant.getQualifications().add(formation);
		// Réinitialiser la formation par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		formation = (Formation) context.getBean("formation");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'étudiant ajoute une expérience à sa liste
	public void ajouterExperience() {
		experience.setEtudiant(etudiant);
		etudiant.getQualifications().add(experience);
		// Réinitialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		experience = (Experience) context.getBean("experience");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'étudiant retire une formation
	public void retirerFormation() {
		etudiant.getQualifications().remove(formation);
	}

	// La méthode appelée quand l'étudiant retire une experience
	public void retirerExperience() {
		etudiant.getQualifications().remove(experience);
	}

	// La méthode appelée quand l'étudiant ajoute une adresse à sa liste
	public void ajouterAdresse() {
		etudiant.getAdresses().add(adresse);
		// Réinitialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		adresse = (Adresse) context.getBean("adresse");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'étudiant retire une adresse
	public void retirerAdresse() {
		etudiant.getAdresses().remove(adresse);
	}
	
	// La méthode appelée quand l'étudiant valide son inscription
	public void inscrire()
	{
		System.out.println("Inscription en cours ...");
		//Récupérer le DAO de l'étudiant et l'insérer dans la bdd
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EtudiantDAO etudiantDAO = (EtudiantDAO) context.getBean("etudiantDao");
		
		etudiantDAO.ajouterEtudiant(etudiant);
		
		//Réinitialiser l'étudiant
		etudiant = (Etudiant) context.getBean("etudiant");
		((ConfigurableApplicationContext) context).close();
		System.out.println("Inscription réussie.");
	}

}
