package com.trast.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Competence;
import com.trast.model.Etudiant;
import com.trast.model.Niveau;


public class TestNiveauDAOImpl {

	@Test
	public void testGetNiveaux() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		Competence competence = (Competence) context.getBean("competence");	
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		NiveauDAO niveauDao = (NiveauDAO) context.getBean("niveauDao");
		Niveau niveau = (Niveau) context.getBean("niveau");	
		/* etudiant*/
		etudiant.setEmail("emailTest");	  
		etudiantDao.ajouterEtudiant(etudiant);
		Assert.assertNotNull(etudiant.getId());
		/* competence*/
		competence.setIntitule("competenceTest");
		competence = competenceDao.ajouterCompetenceIfNotExist(competence);
		/* niveau*/
		 niveau.setEtudiant(etudiant);
		 niveau.setCompetence(competence);		  
		  niveauDao.ajouterNiveau(niveau);	
		  /* recuperation*/
		  List<Niveau> niveaux = niveauDao.getNiveaux();	  
		  Assert.assertNotNull(niveaux);
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  competenceDao.supprimerCompetence(competence.getId());
		//niveauDao.supprimerNiveau(niveau.getId());
		 
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetNiveau() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		Competence competence = (Competence) context.getBean("competence");	
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		NiveauDAO niveauDao = (NiveauDAO) context.getBean("niveauDao");
		Niveau niveau = (Niveau) context.getBean("niveau");	
		
		/* etudiant*/
		etudiant.setEmail("emailTest");	  
		etudiantDao.ajouterEtudiant(etudiant);
		Assert.assertNotNull(etudiant.getId());
		/* competence*/
		competence.setIntitule("competenceTest");
		competence = competenceDao.ajouterCompetenceIfNotExist(competence);
		/* niveau*/
		 niveau.setEtudiant(etudiant);
		 niveau.setCompetence(competence);		  
		  niveauDao.ajouterNiveau(niveau);	
		  /* recuperer */
		  niveau = niveauDao.getNiveau(niveau.getId());	  
		  Assert.assertNotNull(niveau);

		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  competenceDao.supprimerCompetence(competence.getId());
		  //niveauDao.supprimerNiveau(niveau.getId());
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterNiveau() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		Competence competence = (Competence) context.getBean("competence");	
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		NiveauDAO niveauDao = (NiveauDAO) context.getBean("niveauDao");
		Niveau niveau = (Niveau) context.getBean("niveau");		  
		/* etudiant*/
		etudiant.setEmail("emailTest");	  
		etudiantDao.ajouterEtudiant(etudiant);
		Assert.assertNotNull(etudiant.getId());
		/* competence*/
		competence.setIntitule("competenceTest");
		competence = competenceDao.ajouterCompetenceIfNotExist(competence);
		/* niveau*/
		 niveau.setEtudiant(etudiant);
		 niveau.setCompetence(competence);		  
		  niveauDao.ajouterNiveau(niveau);	
		  /* recuperer */	  
		  niveau = niveauDao.getNiveau(niveau.getId());	  
		  Assert.assertNotNull(niveau);
		  //niveauDao.supprimerNiveau(niveau.getId());
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  competenceDao.supprimerCompetence(competence.getId());
		 
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierNiveau() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		Competence competence = (Competence) context.getBean("competence");	
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		NiveauDAO niveauDao = (NiveauDAO) context.getBean("niveauDao");
		Niveau niveau = (Niveau) context.getBean("niveau");	
		
		/* ajout etudiant*/
		etudiant.setEmail("email");	  
		etudiantDao.ajouterEtudiant(etudiant);
		 Assert.assertNotNull(etudiant.getId());
		/*ajout competence*/
		 competence.setIntitule("competenceTest");
		  competence = competenceDao.ajouterCompetenceIfNotExist(competence);
		  /**/	  
		 niveau.setCompetence(competence);	
		 niveau.setEtudiant(etudiant);
		  niveauDao.ajouterNiveau(niveau);		  
		  niveau = niveauDao.getNiveau(niveau.getId());	
		  niveau.setMaitrise(1);
		  niveauDao.modifierNiveau(niveau);
		  niveau = niveauDao.getNiveau(niveau.getId());	
		  Assert.assertNotNull(niveau);
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  competenceDao.supprimerCompetence(competence.getId());
		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerNiveau() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		Competence competence = (Competence) context.getBean("competence");	
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		NiveauDAO niveauDao = (NiveauDAO) context.getBean("niveauDao");
		Niveau niveau = (Niveau) context.getBean("niveau");	
		/* etudiant*/
		etudiant.setEmail("emailTest");	  
		etudiantDao.ajouterEtudiant(etudiant);
		Assert.assertNotNull(etudiant.getId());
		/* competence*/
		competence.setIntitule("competenceTest");
		competence = competenceDao.ajouterCompetenceIfNotExist(competence);
		/* niveau*/
		 niveau.setEtudiant(etudiant);
		 niveau.setCompetence(competence);		  
		  niveauDao.ajouterNiveau(niveau);	
		  /* supprimer */	
		  etudiant.getNiveaux().remove(niveau);
		  niveau.setEtudiant(null);
		  niveauDao.modifierNiveau(niveau);
		  niveauDao.supprimerNiveau(niveau.getId());
		  niveau = niveauDao.getNiveau(niveau.getId());	  
		  Assert.assertNull(niveau);
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  competenceDao.supprimerCompetence(competence.getId());
		 
		  ((ConfigurableApplicationContext)context).close();
	}

}
