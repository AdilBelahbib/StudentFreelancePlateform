package com.trast.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Competence;

public class TestCompetenceDAOImpl {

	@Test
	public void testGetCompetences() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		Competence competence = (Competence) context.getBean("competence");
		
		competence.setIntitule("Langage java EE");
		List<Competence> competences;
		
		competenceDao.ajouterCompetence(competence);
		competences = competenceDao.getCompetences();
		Assert.assertNotNull(competences);
		competenceDao.supprimerCompetence(competence.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetCompetence() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		Competence competence = (Competence) context.getBean("competence");
		
		competence.setIntitule("Langage java EE");
	
		competenceDao.ajouterCompetence(competence);
		competence = competenceDao.getCompetence(competence.getId());
		Assert.assertNotNull(competence);
		competenceDao.supprimerCompetence(competence.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterCompetence() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		Competence competence = (Competence) context.getBean("competence");
		
		competence.setIntitule("Langage java EE");
	
		competenceDao.ajouterCompetence(competence);
		competence = competenceDao.getCompetence(competence.getId());
		Assert.assertNotNull(competence);
		competenceDao.supprimerCompetence(competence.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerCompetence() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		Competence competence = (Competence) context.getBean("competence");
		
		competence.setIntitule("Langage java EE");
	
		competenceDao.ajouterCompetence(competence);
		competence = competenceDao.getCompetence(competence.getId());
		Assert.assertNotNull(competence);
		competenceDao.supprimerCompetence(competence.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierCompetence() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		Competence competence = (Competence) context.getBean("competence");
		
		competence.setIntitule("Langage java EE");
	
		competenceDao.ajouterCompetence(competence);
		competence.setIntitule("SPRING");
		competence = competenceDao.getCompetence(competence.getId());
		Assert.assertNotNull(competence);
		competenceDao.supprimerCompetence(competence.getId());
		((ConfigurableApplicationContext)context).close();
	}

}
