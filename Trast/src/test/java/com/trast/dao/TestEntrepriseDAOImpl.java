package com.trast.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Entreprise;
import com.trast.model.EtatCompte;

public class TestEntrepriseDAOImpl {

	@Test
	public void testGetEntreprises() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");

		Set<String> secteurs = new HashSet<String>();
		secteurs.add("Developpement");

		entreprise.setSigle("TRAST");
		entreprise.setApercu("Plateforme de gestion des appels d'offre");

		List<Entreprise> entreprises;
		entrepriseDao.ajouterEntreprise(entreprise);
		entreprises = entrepriseDao.getEntreprises();

		Assert.assertNotNull(entreprises);

		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testGetEntrepriseParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");

		Set<String> secteurs = new HashSet<String>();
		secteurs.add("Developpement");

		entreprise.setSigle("TRAST");
		entreprise.setApercu("Plateforme de gestion des appels d'offre");

		entrepriseDao.ajouterEntreprise(entreprise);
		entreprise = entrepriseDao.getEntrepriseParId(entreprise.getId());

		Assert.assertNotNull(entreprise);

		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testAjouterEntreprise() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("trast@gmail.com");
		entreprise.setSigle("TRAST");
		entreprise.setApercu("Plateforme de gestion des appels d'offre");
		
		Assert.assertEquals("Entreprise 1 ajoutée ",true,entrepriseDao.ajouterEntreprise(entreprise) );
		
		entreprise = entrepriseDao.getEntrepriseParId(entreprise.getId());

		Assert.assertNotNull(entreprise);

		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testModifierEntreprise() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setSigle("TRAST");
		entreprise.setApercu("Plateforme de gestion des appels d'offre");

		entrepriseDao.ajouterEntreprise(entreprise);
		entreprise.setEmail("entreprise@gmail.com");
		entrepriseDao.modifierEntreprise(entreprise);
		entreprise = entrepriseDao.getEntrepriseParId(entreprise.getId());
		Assert.assertNotNull(entreprise);
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testSupprimerEntreprise() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");

		Set<String> secteurs = new HashSet<String>();
		secteurs.add("Developpement");

		entreprise.setSigle("TRAST");
		entreprise.setApercu("Plateforme de gestion des appels d'offre");

		entrepriseDao.ajouterEntreprise(entreprise);
		entreprise = entrepriseDao.getEntrepriseParId(entreprise.getId());

		Assert.assertNotNull(entreprise);

		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testGetEntreprisesByEtatCompte() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise1 = (Entreprise) context.getBean("entreprise");

		Set<String> secteurs = new HashSet<String>();
		secteurs.add("Developpement");

		entreprise1.setSigle("TRAST");
		entreprise1.setEmail("entreprise1@gmail.com");
		entreprise1.setApercu("Plateforme de gestion des appels d'offre");
		entreprise1.setSecteurActivites(secteurs);
		entrepriseDao.ajouterEntreprise(entreprise1);

		Entreprise entreprise2 = (Entreprise) context.getBean("entreprise");

		entreprise2.setSigle("TRAST");
		entreprise2.setApercu("Plateforme de gestion des appels d'offre");
		entreprise2.setSecteurActivites(secteurs);
		entreprise2.setEmail("entreprise2@gmail.com");
		entreprise2.setEtatCompte(EtatCompte.ACTIVE);
		entrepriseDao.ajouterEntreprise(entreprise2);
		
		Entreprise entreprise3 = (Entreprise) context.getBean("entreprise");

		entreprise3.setSigle("TRAST");
		entreprise3.setApercu("Plateforme de gestion des appels d'offre");
		entreprise3.setEmail("entreprise3@gmail.com");
		entreprise3.setSecteurActivites(secteurs);
		entrepriseDao.ajouterEntreprise(entreprise3);

		List<Entreprise> entreprisesEnAttente = entrepriseDao.getEntreprisesByEtatCompte(EtatCompte.EN_ATTENTE);
		List<Entreprise> entreprisesActivees = entrepriseDao.getEntreprisesByEtatCompte(EtatCompte.ACTIVE);

		Assert.assertEquals("Entreprises en attente", 3, entreprisesEnAttente.size());
		Assert.assertEquals("Entreprises activée", 1, entreprisesActivees.size());

		entrepriseDao.supprimerEntreprise(entreprise1.getId());
		entrepriseDao.supprimerEntreprise(entreprise2.getId());
		entrepriseDao.supprimerEntreprise(entreprise3.getId());
		((ConfigurableApplicationContext) context).close();
	}

}
