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
	
	@Test
	public void testGetContrePropositionsByAppelOffre() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
		
		AppelOffre appelOffre1 = (AppelOffre) context.getBean("appelOffre");
		appelOffreDao.ajouterAppelOffre(appelOffre1);
		AppelOffre appelOffre2 = (AppelOffre) context.getBean("appelOffre");
		appelOffreDao.ajouterAppelOffre(appelOffre2);
		
		System.out.println("Appel 1: "+appelOffre1.getId());
		System.out.println("Appel 2: "+appelOffre2.getId());
		
		double enchere = 1.2;
		
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre1);
		contrePropositionDao.ajouterContreProposition(contreProposition);
		
		ContreProposition contreProposition2 = (ContreProposition) context.getBean("contreProposition");
		contreProposition2.setEnchere(enchere);
		contreProposition2.setEtudiant(etudiant);
		contreProposition2.setAppelOffre(appelOffre1);
		contrePropositionDao.ajouterContreProposition(contreProposition2);
		
		ContreProposition contreProposition3 = (ContreProposition) context.getBean("contreProposition");
		contreProposition3.setEnchere(enchere);
		contreProposition3.setEtudiant(etudiant);
		contreProposition3.setAppelOffre(appelOffre2);
		contrePropositionDao.ajouterContreProposition(contreProposition3);
		
		System.out.println("ContreProposition 1 => "+contreProposition.getId()+" | "+contreProposition.getAppelOffre().getId());
		System.out.println("ContreProposition 2 => "+contreProposition2.getId()+" | "+contreProposition2.getAppelOffre().getId());
		System.out.println("ContreProposition 3 => "+contreProposition3.getId()+" | "+contreProposition3.getAppelOffre().getId());
		
		List<ContreProposition> contrePropositions1 = contrePropositionDao.getContrePropositionsByAppelOffre(appelOffre1);
		List<ContreProposition> contrePropositions2 = contrePropositionDao.getContrePropositionsByAppelOffre(appelOffre2);

		Assert.assertEquals("Liste contre-propositions 1", 2, contrePropositions1.size());
		Assert.assertEquals("Liste contre-propositions 2", 1, contrePropositions2.size());
		
		contrePropositionDao.supprimerContreProposition(contreProposition.getId());
		contrePropositionDao.supprimerContreProposition(contreProposition2.getId());
		contrePropositionDao.supprimerContreProposition(contreProposition3.getId());
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre1.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre2.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

}
