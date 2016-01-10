package com.trast.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Badge;
import com.trast.model.EvenementBadge;
import com.trast.model.SourceEvenement;

public class TestEvenementBadgeDAOImpl {

	@Test
	public void testGetEvenementBadge() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		EvenementBadgeDAO evenementBadgeDAO = (EvenementBadgeDAO) context.getBean("evenementBadgeDao");
		EvenementBadge evenementBadge = (EvenementBadge) context.getBean("evenementBadge");
		Badge badge = (Badge) context.getBean("badge");
		
		badge.setIntitule("Badge de test");
		
		evenementBadge.setSourceEvenement(SourceEvenement.AVISPOSITIF);
		evenementBadge.setBadge(badge);
		
		evenementBadgeDAO.ajouterEvenementBadge(evenementBadge);
		
		List<EvenementBadge> evenementBadges = evenementBadgeDAO.getEvenementBadges();
		
		Assert.assertNotNull("Liste des EvenementBadge est nulle", evenementBadges);
		
		evenementBadgeDAO.supprimerEvenementBadge(evenementBadge);
		((ConfigurableApplicationContext)context).close();	
	}

	@Test
	public void testGetEvenementBadges() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		EvenementBadgeDAO evenementBadgeDAO = (EvenementBadgeDAO) context.getBean("evenementBadgeDao");
		EvenementBadge evenementBadge = (EvenementBadge) context.getBean("evenementBadge");
		Badge badge = (Badge) context.getBean("badge");
		
		badge.setIntitule("Badge de test");
		
		evenementBadge.setSourceEvenement(SourceEvenement.AVISPOSITIF);
		evenementBadge.setBadge(badge);
		
		evenementBadgeDAO.ajouterEvenementBadge(evenementBadge);
				
		evenementBadge = evenementBadgeDAO.getEvenementBadge(evenementBadge.getId());
		
		Assert.assertNotNull("EvenementBadge est nul", evenementBadge);
		
		evenementBadgeDAO.supprimerEvenementBadge(evenementBadge);
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterEvenementBadge() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		EvenementBadgeDAO evenementBadgeDAO = (EvenementBadgeDAO) context.getBean("evenementBadgeDao");
		EvenementBadge evenementBadge = (EvenementBadge) context.getBean("evenementBadge");
		Badge badge = (Badge) context.getBean("badge");
		
		badge.setIntitule("Badge de test");
		
		evenementBadge.setSourceEvenement(SourceEvenement.AVISPOSITIF);
		evenementBadge.setBadge(badge);
		
		evenementBadgeDAO.ajouterEvenementBadge(evenementBadge);
				
		evenementBadge = evenementBadgeDAO.getEvenementBadge(evenementBadge.getId());
		
		Assert.assertNotNull("EvenementBadge est nul", evenementBadge);
		
		evenementBadgeDAO.supprimerEvenementBadge(evenementBadge);
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerEvenementBadge() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		EvenementBadgeDAO evenementBadgeDAO = (EvenementBadgeDAO) context.getBean("evenementBadgeDao");
		EvenementBadge evenementBadge = (EvenementBadge) context.getBean("evenementBadge");
		Badge badge = (Badge) context.getBean("badge");
		
		badge.setIntitule("Badge de test");
		
		evenementBadge.setSourceEvenement(SourceEvenement.AVISPOSITIF);
		evenementBadge.setBadge(badge);
		
		evenementBadgeDAO.ajouterEvenementBadge(evenementBadge);
				
		evenementBadge = evenementBadgeDAO.getEvenementBadge(evenementBadge.getId());
		evenementBadgeDAO.supprimerEvenementBadge(evenementBadge);
		evenementBadge = evenementBadgeDAO.getEvenementBadge(evenementBadge.getId());
		
		Assert.assertNull("EvenementBadge n'est pas nul", evenementBadge);
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierEvenementBadge() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		EvenementBadgeDAO evenementBadgeDAO = (EvenementBadgeDAO) context.getBean("evenementBadgeDao");
		EvenementBadge evenementBadge = (EvenementBadge) context.getBean("evenementBadge");
		Badge badge = (Badge) context.getBean("badge");
		
		badge.setIntitule("Badge de test");
		
		evenementBadge.setSourceEvenement(SourceEvenement.AVISPOSITIF);
		evenementBadge.setBadge(badge);
		
		evenementBadgeDAO.ajouterEvenementBadge(evenementBadge);
		
		evenementBadge.setSourceEvenement(SourceEvenement.COMPETENCE);
		evenementBadgeDAO.modifierEvenementBadge(evenementBadge);
		
		evenementBadge = evenementBadgeDAO.getEvenementBadge(evenementBadge.getId());
		
		Assert.assertEquals(SourceEvenement.COMPETENCE, evenementBadge.getSourceEvenement());
		evenementBadgeDAO.supprimerEvenementBadge(evenementBadge);
		
		((ConfigurableApplicationContext)context).close();
	}

}
