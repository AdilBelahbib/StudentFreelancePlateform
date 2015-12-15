package com.trast.dao;



import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.CahierDesCharges;
import com.trast.model.Entreprise;

public class TestCahierDesChargesDAOImpl {

	@Test
	public void testGetCahiersDesCharges() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		@SuppressWarnings("deprecation")
		Date dateDebut = new Date("10/12/2015");
		@SuppressWarnings("deprecation")
		Date dateFin = new Date("11/12/2015");
			
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		entreprise.setEmail("entreprise@gmail.com");
				
		cahierDesCharges.setSujet("cahier des charges 1");
		cahierDesCharges.setDateDebut(dateDebut);
		cahierDesCharges.setDateFin(dateFin);
		
		entrepriseDao.ajouterEntreprise(entreprise);	
		List<CahierDesCharges> cahiersDesCharges;
		
		cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		cahiersDesCharges = cahierDesChargesDao.getCahiersDesCharges();		
		
		Assert.assertNotNull(cahiersDesCharges);
		
		cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetCahierDesChargesParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		@SuppressWarnings("deprecation")
		Date dateDebut = new Date("10/12/2015");
		@SuppressWarnings("deprecation")
		Date dateFin = new Date("11/12/2015");
			
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		entreprise.setEmail("entreprise@gmail.com");
				
		cahierDesCharges.setSujet("cahier des charges 1");
		cahierDesCharges.setDateDebut(dateDebut);
		cahierDesCharges.setDateFin(dateFin);
		
		entrepriseDao.ajouterEntreprise(entreprise);	
		
		cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		cahierDesCharges = cahierDesChargesDao.getCahierDesChargesParId(cahierDesCharges.getId());		
		
		Assert.assertNotNull(cahierDesCharges);
		
		cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterCahierDesCharges() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		@SuppressWarnings("deprecation")
		Date dateDebut = new Date("10/12/2015");
		@SuppressWarnings("deprecation")
		Date dateFin = new Date("11/12/2015");
			
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		entreprise.setEmail("entreprise@gmail.com");
				
		cahierDesCharges.setSujet("cahier des charges 1");
		cahierDesCharges.setDateDebut(dateDebut);
		cahierDesCharges.setDateFin(dateFin);
		
		entrepriseDao.ajouterEntreprise(entreprise);	
		
		cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		cahierDesCharges = cahierDesChargesDao.getCahierDesChargesParId(cahierDesCharges.getId());		
		
		Assert.assertNotNull(cahierDesCharges);
		
		cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testModifierCahierDesCharges() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		Date dateDebut = new Date("10/12/2015");
		Date dateFin = new Date("11/12/2015");
			
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		entreprise.setEmail("entreprise@gmail.com");
				
		cahierDesCharges.setSujet("cahier des charges 1");
		cahierDesCharges.setDateDebut(dateDebut);
		cahierDesCharges.setDateFin(dateFin);
		
		entrepriseDao.ajouterEntreprise(entreprise);
		
		cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		cahierDesCharges.setDateFin(new Date("12/12/2015"));
		cahierDesChargesDao.modifierCahierDesCharges(cahierDesCharges);
		cahierDesCharges = cahierDesChargesDao.getCahierDesChargesParId(cahierDesCharges.getId());		
		
		Assert.assertNotNull(cahierDesCharges);
		
		cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerCahierDesCharges() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CahierDesChargesDAO cahierDesChargesDao = (CahierDesChargesDAO) context.getBean("cahierDesChargesDao");
		CahierDesCharges cahierDesCharges = (CahierDesCharges) context.getBean("cahierDesCharges");
		
		@SuppressWarnings("deprecation")
		Date dateDebut = new Date("10/12/2015");
		@SuppressWarnings("deprecation")
		Date dateFin = new Date("11/12/2015");
			
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		entreprise.setEmail("entreprise@gmail.com");
				
		cahierDesCharges.setSujet("cahier des charges 1");
		cahierDesCharges.setDateDebut(dateDebut);
		cahierDesCharges.setDateFin(dateFin);
		
		entrepriseDao.ajouterEntreprise(entreprise);	
		
		cahierDesChargesDao.ajouterCahierDesCharges(cahierDesCharges);
		cahierDesCharges = cahierDesChargesDao.getCahierDesChargesParId(cahierDesCharges.getId());		
		
		Assert.assertNotNull(cahierDesCharges);
		
		cahierDesChargesDao.supprimerCahierDesCharges(cahierDesCharges.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		((ConfigurableApplicationContext)context).close();
	}

}
