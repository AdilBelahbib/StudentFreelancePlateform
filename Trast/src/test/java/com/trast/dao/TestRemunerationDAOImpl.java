package com.trast.dao;


import org.junit.Test;

import java.util.List;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.AppelOffre;
import com.trast.model.Entreprise;
import com.trast.model.Remuneration;
public class TestRemunerationDAOImpl {

	@Test
	public void testGetRemunerations() {
		  ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		  AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		  AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");		  
		  EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		  Entreprise entreprise = (Entreprise) context.getBean("entreprise");		  
		  RemunerationDAO remunerationDao = (RemunerationDAO) context.getBean("remunerationDao");
		  Remuneration remuneration = (Remuneration) context.getBean("remuneration");		  
		  entreprise.setEmail("entreprise@gmail.com");
		  appelOffre.setEntreprise(entreprise);		  
		  remuneration.setAppelOffre(appelOffre);
		  remuneration.setSomme(10000);	  
		  entrepriseDao.ajouterEntreprise(entreprise);
		  appelOffreDao.ajouterAppelOffre(appelOffre);
		  remunerationDao.ajouterRemuneration(remuneration);
		  List<Remuneration> remunerations = remunerationDao.getRemunerations();
		  Assert.assertNotNull(remunerations);  
		  remunerationDao.supprimerRemuneration(remuneration.getId());
		  appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		  entrepriseDao.supprimerEntreprise(entreprise.getId());
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetRemuneration() {
		  ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		  AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		  AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");	  
		  EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		  Entreprise entreprise = (Entreprise) context.getBean("entreprise");		  
		  RemunerationDAO remunerationDao = (RemunerationDAO) context.getBean("remunerationDao");
		  Remuneration remuneration = (Remuneration) context.getBean("remuneration");		  
		  entreprise.setEmail("entreprise@gmail.com");
		  appelOffre.setEntreprise(entreprise);		  
		  remuneration.setAppelOffre(appelOffre);
		  remuneration.setSomme(10000);		  
		  entrepriseDao.ajouterEntreprise(entreprise);
		  appelOffreDao.ajouterAppelOffre(appelOffre);
		  remunerationDao.ajouterRemuneration(remuneration);
		  remuneration = remunerationDao.getRemuneration(remuneration.getId());
		  Assert.assertNotNull(remuneration);	  
		  remunerationDao.supprimerRemuneration(remuneration.getId());
		  appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		  entrepriseDao.supprimerEntreprise(entreprise.getId());
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterRemuneration() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		  
		  AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		  AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		  
		  EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		  Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		  
		  RemunerationDAO remunerationDao = (RemunerationDAO) context.getBean("remunerationDao");
		  Remuneration remuneration = (Remuneration) context.getBean("remuneration");
		  
		  entreprise.setEmail("entreprise@gmail.com");
		  appelOffre.setEntreprise(entreprise);
		  
		  remuneration.setAppelOffre(appelOffre);
		  remuneration.setSomme(10000);
		  
		  entrepriseDao.ajouterEntreprise(entreprise);
		  appelOffreDao.ajouterAppelOffre(appelOffre);
		  remunerationDao.ajouterRemuneration(remuneration);
		  remuneration = remunerationDao.getRemuneration(remuneration.getId());
		  Assert.assertNotNull(remuneration);
		  
		  remunerationDao.supprimerRemuneration(remuneration.getId());
		  appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		  entrepriseDao.supprimerEntreprise(entreprise.getId());
		  ((ConfigurableApplicationContext)context).close();

	}

	@Test
	public void testSupprimerRemuneration() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		  
		  AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		  AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		  
		  EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		  Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		  
		  RemunerationDAO remunerationDao = (RemunerationDAO) context.getBean("remunerationDao");
		  Remuneration remuneration = (Remuneration) context.getBean("remuneration");
		  
		  entreprise.setEmail("entreprise@gmail.com");
		  appelOffre.setEntreprise(entreprise);
		  
		  remuneration.setAppelOffre(appelOffre);
		  remuneration.setSomme(10000);
		  
		  entrepriseDao.ajouterEntreprise(entreprise);
		  appelOffreDao.ajouterAppelOffre(appelOffre);
		  remunerationDao.ajouterRemuneration(remuneration);
		  remunerationDao.supprimerRemuneration(remuneration.getId());
		  remuneration = remunerationDao.getRemuneration(remuneration.getId());
		  Assert.assertNull(remuneration);
		  appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		  entrepriseDao.supprimerEntreprise(entreprise.getId());
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierRemuneration() {
		  ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		  AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		  AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");		  
		  EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		  Entreprise entreprise = (Entreprise) context.getBean("entreprise");		  
		  RemunerationDAO remunerationDao = (RemunerationDAO) context.getBean("remunerationDao");
		  Remuneration remuneration = (Remuneration) context.getBean("remuneration");	  
		  entreprise.setEmail("entreprise@gmail.com");
		  appelOffre.setEntreprise(entreprise);		  
		  remuneration.setAppelOffre(appelOffre);
		  remuneration.setSomme(10000);		  
		  entrepriseDao.ajouterEntreprise(entreprise);
		  appelOffreDao.ajouterAppelOffre(appelOffre);
		  remunerationDao.ajouterRemuneration(remuneration);
		  remuneration = remunerationDao.getRemuneration(remuneration.getId());
		  remuneration.setSomme(40000);
		  remunerationDao.modifierRemuneration(remuneration);
		  remuneration = remunerationDao.getRemuneration(remuneration.getId());
		  Assert.assertEquals(40000, remuneration.getSomme(),0);
		  remunerationDao.supprimerRemuneration(remuneration.getId());
		  appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		  entrepriseDao.supprimerEntreprise(entreprise.getId());
		  ((ConfigurableApplicationContext)context).close();
	}

}
