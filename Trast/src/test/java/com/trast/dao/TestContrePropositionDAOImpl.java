package com.trast.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.AppelOffre;
import com.trast.model.ContreProposition;
import com.trast.model.Entreprise;
import com.trast.model.Etudiant;

public class TestContrePropositionDAOImpl {

	@Test
	public void testGetContrePropositions() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
				
		appelOffreDao.ajouterAppelOffre(appelOffre);
		
		double enchere = 1.2;
		
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);
		
		List<ContreProposition> contrePropositions;
		
		contrePropositionDao.ajouterContreProposition(contreProposition);
		contrePropositions = contrePropositionDao.getContrePropositions();
		Assert.assertNotNull(contrePropositions);
		contrePropositionDao.supprimerContreProposition(contreProposition.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetContrePropositionParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
				
		appelOffreDao.ajouterAppelOffre(appelOffre);
		
		double enchere = 1.2;
		
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);

		contrePropositionDao.ajouterContreProposition(contreProposition);
		contreProposition = contrePropositionDao.getContrePropositionParId(contreProposition.getId());
		Assert.assertNotNull(contreProposition);
		contrePropositionDao.supprimerContreProposition(contreProposition.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterContreProposition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
				
		appelOffreDao.ajouterAppelOffre(appelOffre);
		
		double enchere = 1.2;
		
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);

		contrePropositionDao.ajouterContreProposition(contreProposition);
		contreProposition = contrePropositionDao.getContrePropositionParId(contreProposition.getId());
		Assert.assertNotNull(contreProposition);
		contrePropositionDao.supprimerContreProposition(contreProposition.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierContreProposition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
				
		appelOffreDao.ajouterAppelOffre(appelOffre);
		
		double enchere = 1.2;
		
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);

		contrePropositionDao.ajouterContreProposition(contreProposition);
		contreProposition.setEnchere(2.5);
		contrePropositionDao.modifierContreProposition(contreProposition);
		contreProposition = contrePropositionDao.getContrePropositionParId(contreProposition.getId());
		Assert.assertNotNull(contreProposition);
		contrePropositionDao.supprimerContreProposition(contreProposition.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerContreProposition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
				
		appelOffreDao.ajouterAppelOffre(appelOffre);
		
		double enchere = 1.2;
		
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);

		contrePropositionDao.ajouterContreProposition(contreProposition);
		contreProposition = contrePropositionDao.getContrePropositionParId(contreProposition.getId());
		Assert.assertNotNull(contreProposition);
		contrePropositionDao.supprimerContreProposition(contreProposition.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

}
