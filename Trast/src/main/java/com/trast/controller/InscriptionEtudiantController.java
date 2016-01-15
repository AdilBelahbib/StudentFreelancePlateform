package com.trast.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.EtudiantDAO;
import com.trast.dao.FichierDAO;
import com.trast.model.Adresse;
import com.trast.model.Etudiant;
import com.trast.model.Experience;
import com.trast.model.Fichier;
import com.trast.model.Formation;
import com.trast.service.UploadFileService;

@ManagedBean(name = "inscriptionEtudiantController", eager = true)
@SessionScoped
public class InscriptionEtudiantController implements Serializable {

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
	
	
	// utiliser pour les fichiers de l'etudiant
	@ManagedProperty(value = "#{formationFiles}")
	Map<String,Part> formationFiles = new HashMap<String,Part>();
	
	@ManagedProperty(value = "#{experienceFiles}")
	Map<String,Part> experienceFiles = new HashMap<String,Part>();
	
	@ManagedProperty(value = "#{myFile}")
	Part myFile;

	public Part getMyFile() {
		return myFile;
	}

	public void setMyFile(Part myFile) {
		this.myFile = myFile;
	}

	

	

	public Map<String, Part> getFormationFiles() {
		return formationFiles;
	}

	public void setFormationFiles(Map<String, Part> formationFiles) {
		this.formationFiles = formationFiles;
	}

	

	public Map<String, Part> getExperienceFiles() {
		return experienceFiles;
	}

	public void setExperienceFiles(Map<String, Part> experienceFiles) {
		this.experienceFiles = experienceFiles;
	}

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
		
		
		/* ajout fichier*/
		if(myFile!=null) System.out.println("diffrent de null);");
		else System.out.println("file null");
		if(formation.getIntituleFormation()!=null) System.out.println("formation exis");
		if(formationFiles==null) formationFiles = new HashMap<String,Part>();
		formationFiles.put(formation.getIntituleFormation(),myFile);
		
		formation = (Formation) context.getBean("formation");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'étudiant ajoute une expérience à sa liste
	public void ajouterExperience() {
		experience.setEtudiant(etudiant);
		etudiant.getQualifications().add(experience);
		// Réinitialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		/* ajout fichier*/
		if(experienceFiles==null) experienceFiles = new HashMap<String,Part>();
		experienceFiles.put(experience.getSujet(),myFile);
		experience = (Experience) context.getBean("experience");
		((ConfigurableApplicationContext) context).close();
	}

	// La méthode appelée quand l'étudiant retire une formation
	public void retirerFormation() {
		etudiant.getQualifications().remove(formation);
		
		/* retirer fichier ???????????*/
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
		
		
		/*** ajouter les fichiers de l'etudiant**/
		/* formations:*/
		/*Fichier fichier = (Fichier)context.getBean("fichier");
		FichierDAO fichierDao = (FichierDAO)context.getBean("fichierDao");
		Iterator<Entry<String, Part>> it;
		if(formationFiles.size()>0) 
		{
			it= formationFiles.entrySet().iterator();
			while (it.hasNext()) {
				 Map.Entry<String,Part> pair = (Entry<String, Part>)it.next();
				 fichier.setChemin("/etudiant/"+etudiant.getId());
				 fichier.setTitre(pair.getKey());
				 System.out.println("chemin: "+fichier.getChemin()+", titre: "+fichier.getTitre());
				 UploadFileService.definirPart(pair.getValue());
				 UploadFileService.uploadFichier(fichier);
				 fichierDao.ajouterFichier(fichier);
				 fichier = (Fichier)context.getBean("fichier");
				 etudiant.getFichiers().add(fichier);
				 
			}
		}*/
		/*if(experienceFiles.size()>0){
			it = experienceFiles.entrySet().iterator();
			while (it.hasNext()) {
				 Map.Entry<String,Part> pair = (Entry<String, Part>)it.next();
				 fichier.setChemin("/etudiant/"+etudiant.getId());
				 fichier.setTitre(pair.getKey());
					/* set Part de service*/
				 /*UploadFileService.definirPart(pair.getValue());
				 UploadFileService.uploadFichier(fichier);
				 fichierDao.ajouterFichier(fichier);
				 fichier = (Fichier)context.getBean("fichier");
					/* associer a l'etudiant*/
				/* etudiant.getFichiers().add(fichier);
				 
			}
		}*/
		//modifier etudiant
		//etudiantDAO.modifierEtudiant(etudiant);
		//Réinitialiser l'étudiant
		etudiant = (Etudiant) context.getBean("etudiant");
		((ConfigurableApplicationContext) context).close();
		System.out.println("Inscription réussie.");
	}

}
