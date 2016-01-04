package com.trast.dao;



import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.CahierDesCharges;
import com.trast.model.Etudiant;
import com.trast.model.Livrable;
import com.trast.model.Projet;

public class TestLivrableDAOImpl {

	@Test
	public void testGetLivrables() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		LivrableDAO livrableDao = (LivrableDAO) context.getBean("livrableDao");
		
		Livrable livrable = (Livrable) context.getBean("livrable");
		
		@SuppressWarnings("deprecation")
		Date dateLivraison = new Date("11/12/2015");
		
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("email");
		  
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		Projet projet = (Projet) context.getBean("projet");
		
		projet.setCahierDesCharges(cahierDesCharges);
		projet.setEtudiant(etudiant);
		//etudiant.getProjets().add(projet);
		  
		etudiantDao.ajouterEtudiant(etudiant);
		cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		projetDao.ajouterProjet(projet);
		  
		livrable.setPourcentageAvancement(15);
		livrable.setDateLivraison(dateLivraison);
		livrable.setRemarqueEntreprise("Remarque");
		livrable.setProjet(projet);	
		
		livrableDao.ajouterLivrable(livrable);
		//livrable = livrableDao.getLivrableById(livrable.getId());
		List<Livrable> listeLivrables = livrableDao.getLivrables();
		Assert.assertNotNull(listeLivrables); 
		
		cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetLivrableById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		LivrableDAO livrableDao = (LivrableDAO) context.getBean("livrableDao");
		
		Livrable livrable = (Livrable) context.getBean("livrable");
		
		@SuppressWarnings("deprecation")
		Date dateLivraison = new Date("11/12/2015");
		
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("email");
		  
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		Projet projet = (Projet) context.getBean("projet");
		
		projet.setCahierDesCharges(cahierDesCharges);
		projet.setEtudiant(etudiant);
		//etudiant.getProjets().add(projet);
		  
		etudiantDao.ajouterEtudiant(etudiant);
		cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		projetDao.ajouterProjet(projet);
		  
		livrable.setPourcentageAvancement(15);
		livrable.setDateLivraison(dateLivraison);
		livrable.setRemarqueEntreprise("Remarque");
		livrable.setProjet(projet);	
		
		livrableDao.ajouterLivrable(livrable);
		livrable = livrableDao.getLivrableById(livrable.getId());
		
		Assert.assertNotNull(livrable);
		cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		((ConfigurableApplicationContext)context).close();

	}

	@Test
	public void testAjouterLivrable() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		LivrableDAO livrableDao = (LivrableDAO) context.getBean("livrableDao");
		
		Livrable livrable = (Livrable) context.getBean("livrable");
		
		@SuppressWarnings("deprecation")
		Date dateLivraison = new Date("11/12/2015");
		
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("email");
		  
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		Projet projet = (Projet) context.getBean("projet");
		
		projet.setCahierDesCharges(cahierDesCharges);
		projet.setEtudiant(etudiant);
		//etudiant.getProjets().add(projet);
		  
		etudiantDao.ajouterEtudiant(etudiant);
		cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		projetDao.ajouterProjet(projet);
		  
		livrable.setPourcentageAvancement(15);
		livrable.setDateLivraison(dateLivraison);
		livrable.setRemarqueEntreprise("Remarque");
		livrable.setProjet(projet);	
		
		livrableDao.ajouterLivrable(livrable);
		livrable = livrableDao.getLivrableById(livrable.getId());
		
		Assert.assertNotNull(livrable);
		cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierLivrable() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		LivrableDAO livrableDao = (LivrableDAO) context.getBean("livrableDao");
		
		Livrable livrable = (Livrable) context.getBean("livrable");
		
		@SuppressWarnings("deprecation")
		Date dateLivraison = new Date("11/12/2015");
		
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("email");
		  
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		Projet projet = (Projet) context.getBean("projet");
		
		projet.setCahierDesCharges(cahierDesCharges);
		projet.setEtudiant(etudiant);
		//etudiant.getProjets().add(projet);
		  
		etudiantDao.ajouterEtudiant(etudiant);
		cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		projetDao.ajouterProjet(projet);
		  
		livrable.setPourcentageAvancement(15);
		livrable.setDateLivraison(dateLivraison);
		livrable.setRemarqueEntreprise("Remarque");
		livrable.setProjet(projet);	
		
		livrableDao.ajouterLivrable(livrable);
		
		livrable.setPourcentageAvancement(25);
		livrable = livrableDao.getLivrableById(livrable.getId());
		Assert.assertNotNull(livrable);
		cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		((ConfigurableApplicationContext)context).close();

	}

	@Test
	public void testSupprimerLivrable() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		LivrableDAO livrableDao = (LivrableDAO) context.getBean("livrableDao");
		
		Livrable livrable = (Livrable) context.getBean("livrable");
		
		@SuppressWarnings("deprecation")
		Date dateLivraison = new Date("11/12/2015");
		
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("email");
		  
		ProjetDAO projetDao = (ProjetDAO) context.getBean("projetDao");
		Projet projet = (Projet) context.getBean("projet");
		
		projet.setCahierDesCharges(cahierDesCharges);
		projet.setEtudiant(etudiant);
		//etudiant.getProjets().add(projet);
		  
		etudiantDao.ajouterEtudiant(etudiant);
		cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		projetDao.ajouterProjet(projet);
		  
		livrable.setPourcentageAvancement(15);
		livrable.setDateLivraison(dateLivraison);
		livrable.setRemarqueEntreprise("Remarque");
		livrable.setProjet(projet);	
		
		livrableDao.ajouterLivrable(livrable);
		livrableDao.supprimerLivrable(livrable);
		livrable = livrableDao.getLivrableById(livrable.getId());
		Assert.assertNull(livrable);
		cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		((ConfigurableApplicationContext)context).close();
	}

}
