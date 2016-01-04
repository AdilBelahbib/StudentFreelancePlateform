package com.trast.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.CahierDesCharges;
import com.trast.model.EtatProjet;
import com.trast.model.Etudiant;
import com.trast.model.Projet;

public class TestProjetDAOImpl {

	@Test
	public void testGetProjets() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("email");
		  
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		Projet projet = (Projet) context.getBean("projet");
		  
		  projet.setCahierDesCharges(cahierDesCharges);
		 
		  
		  etudiantDao.ajouterEtudiant(etudiant);
		  projet.setEtudiant(etudiant);
		  cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		  projetDao.ajouterProjet(projet);
		  
		  List<Projet> projets = projetDao.getProjets();
		  
		  Assert.assertNotNull(projets);
		  projetDao.supprimerProjet(projet.getId());
		  cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetProjetParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("email");
		  
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		Projet projet = (Projet) context.getBean("projet");
		  
		  projet.setCahierDesCharges(cahierDesCharges);
		  projet.setEtudiant(etudiant);
		  
		  etudiantDao.ajouterEtudiant(etudiant);
		  cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		  projetDao.ajouterProjet(projet);
		  
		  
		  projet = projetDao.getProjetParId(projet.getId());
		  Assert.assertNotNull(projet);
		  projetDao.supprimerProjet(projet.getId());
		  cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterProjet() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("email");
		  
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		Projet projet = (Projet) context.getBean("projet");
		  
		  projet.setCahierDesCharges(cahierDesCharges);
		  projet.setEtudiant(etudiant);
		  
		  etudiantDao.ajouterEtudiant(etudiant);
		  cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		  projetDao.ajouterProjet(projet);
		  
		  
		  projet = projetDao.getProjetParId(projet.getId());
		  Assert.assertNotNull(projet);
		  projetDao.supprimerProjet(projet.getId());
		  cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierProjet() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("email");	  
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		Projet projet = (Projet) context.getBean("projet");		  
		  projet.setCahierDesCharges(cahierDesCharges);
		  projet.setEtudiant(etudiant);		  
		  etudiantDao.ajouterEtudiant(etudiant);
		  cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		  projetDao.ajouterProjet(projet);		  
		  
		  projet = projetDao.getProjetParId(projet.getId());
		  EtatProjet etat = EtatProjet.ENCOURS;
		  projet.setStatut(etat);
		  projetDao.modifierProjet(projet);
		  projet = projetDao.getProjetParId(projet.getId());
		  Assert.assertEquals(etat,projet.getStatut());
		  projetDao.supprimerProjet(projet.getId());
		  cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerProjet() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("email");
		  
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		Projet projet = (Projet) context.getBean("projet");
		  
		  projet.setCahierDesCharges(cahierDesCharges);
		  projet.setEtudiant(etudiant);
		  
		  etudiantDao.ajouterEtudiant(etudiant);
		  cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		  projetDao.ajouterProjet(projet);
		  
		  projetDao.supprimerProjet(projet.getId());
		  projet = projetDao.getProjetParId(projet.getId());
		  Assert.assertNull(projet);
		  
		  cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  ((ConfigurableApplicationContext)context).close();
	}

}
