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

public class TestEntrepriseDAOImpl {

	@Test
	public void testGetEntreprises() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
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
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetEntrepriseParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
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
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterEntreprise() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
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
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierEntreprise() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		
		Set<String> secteurs = new HashSet<String>();
		secteurs.add("Developpement");

		entreprise.setSigle("TRAST");
		entreprise.setApercu("Plateforme de gestion des appels d'offre");

		entrepriseDao.ajouterEntreprise(entreprise);
		entreprise.setEmail("entreprise@gmail.com");
		entrepriseDao.modifierEntreprise(entreprise);
		entreprise = entrepriseDao.getEntrepriseParId(entreprise.getId());
		
		Assert.assertNotNull(entreprise);
		
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerEntreprise() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
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
		((ConfigurableApplicationContext)context).close();
	}

}
