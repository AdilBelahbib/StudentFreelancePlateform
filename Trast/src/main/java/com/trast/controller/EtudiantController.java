package com.trast.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Etudiant;
import com.trast.model.Experience;
import com.trast.model.Formation;

@ManagedBean(name = "etudiantController", eager = true)
@RequestScoped
public class EtudiantController {
	
	//L'étudiant concerné
	@ManagedProperty(value = "#{etudiant}")
	private Etudiant etudiant;
	
	//Utilisée pour récupérer les données d'une formation lors de l'inscription
	@ManagedProperty(value = "#{formation}")
	private Formation formation;
	//Utilisée pour récupérer les données d'une formation lors de l'inscription
	@ManagedProperty(value = "#{experience}")
	private Experience experience;
	
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

	//La méthode appelée quand l'étudiant ajoute une formation à sa liste des formations
	public void ajouterFormation()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		System.out.println(formation.getIntituleFormation().getIntitule()+" => "+formation.getDateDebut()+" "+formation.getDateFin()+" "+formation.getIntituleFormation().getEtablissement().getNomEtablissement());
	}
	
	//La méthode appelée quand l'étudiant ajoute une formation à sa liste des formations
	public void ajouterExperience()
	{
		System.out.println(experience.getResponsabilite()+" => "+experience.getDateDebut()+" "+experience.getDateFin()+" "+experience.getStructureAccueil());
	}
	
}
