package com.trast.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.*;

public class TestAppelOffreDAOImpl {

	@Test
	public void testGetAppelOffres() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		
		@SuppressWarnings("deprecation")
		Date dateExpiration = new Date("11/12/2015");
		@SuppressWarnings("deprecation")
		Date dateDebut = new Date("10/12/2015");
		
		appelOffre.setEntreprise(entreprise);

		appelOffre.setDateDebut(dateDebut);
		appelOffre.setDateExpiration(dateExpiration);
		
		entrepriseDao.ajouterEntreprise(entreprise);
		List<AppelOffre> appelOffres;
		
		appelOffreDao.ajouterAppelOffre(appelOffre);
		appelOffres = appelOffreDao.getAppelOffres();
		Assert.assertNotNull(appelOffres);
		
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetAppelOffre() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		
		@SuppressWarnings("deprecation")
		Date dateExpiration = new Date("11/12/2015");
		@SuppressWarnings("deprecation")
		Date dateDebut = new Date("10/12/2015");
		
		appelOffre.setEntreprise(entreprise);

		appelOffre.setDateDebut(dateDebut);
		appelOffre.setDateExpiration(dateExpiration);
		
		entrepriseDao.ajouterEntreprise(entreprise);
		
		appelOffreDao.ajouterAppelOffre(appelOffre);
		appelOffre = appelOffreDao.getAppelOffre(appelOffre.getId());
		Assert.assertNotNull(appelOffre);
		
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterAppelOffre() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		
		@SuppressWarnings("deprecation")
		Date dateExpiration = new Date("11/12/2015");
		@SuppressWarnings("deprecation")
		Date dateDebut = new Date("10/12/2015");
		
		appelOffre.setEntreprise(entreprise);

		appelOffre.setDateDebut(dateDebut);
		appelOffre.setDateExpiration(dateExpiration);
		
		entrepriseDao.ajouterEntreprise(entreprise);
		
		appelOffreDao.ajouterAppelOffre(appelOffre);
		appelOffre = appelOffreDao.getAppelOffre(appelOffre.getId());
		Assert.assertNotNull(appelOffre);
		
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerAppelOffre() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		
		@SuppressWarnings("deprecation")
		Date dateExpiration = new Date("11/12/2015");
		@SuppressWarnings("deprecation")
		Date dateDebut = new Date("10/12/2015");
		
		appelOffre.setEntreprise(entreprise);

		appelOffre.setDateDebut(dateDebut);
		appelOffre.setDateExpiration(dateExpiration);
		
		entrepriseDao.ajouterEntreprise(entreprise);
		
		appelOffreDao.ajouterAppelOffre(appelOffre);
		appelOffre = appelOffreDao.getAppelOffre(appelOffre.getId());
		Assert.assertNotNull(appelOffre);
		
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testModifierAppelOffre() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("entreprise@gmail.com");
		
		Date dateExpiration = new Date("11/12/2015");
		Date dateDebut = new Date("10/12/2015");
		
		appelOffre.setEntreprise(entreprise);

		appelOffre.setDateDebut(dateDebut);
		appelOffre.setDateExpiration(dateExpiration);
		
		entrepriseDao.ajouterEntreprise(entreprise);
		
		appelOffreDao.ajouterAppelOffre(appelOffre);
		appelOffre.setDateDebut(new Date("12/12/2015"));
		appelOffreDao.modifierAppelOffre(appelOffre);
		appelOffre = appelOffreDao.getAppelOffre(appelOffre.getId());
		Assert.assertNotNull(appelOffre);
		
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

}
