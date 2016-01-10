package com.trast.dao;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Competence;
import com.trast.model.Question;

public class TestTestDAOImpl {

	@Test
	public void testGetTests() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  test.setDuree(60);
		  
		  test.setTitre("Test1");
		  test.setNombrePassage(0);
		  testDao.ajouterTest(test);
		  List<com.trast.model.Test> tests = testDao.getTests();
		  Assert.assertNotNull(tests);  
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetTestParId() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  test.setDuree(60);
		  test.setTitre("Test1");
		  test.setNombrePassage(0);
		  testDao.ajouterTest(test);
		  test = testDao.getTestParId(test.getId());
		  Assert.assertNotNull(test);  
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterTest() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  CompetenceDAO competenceDao = (CompetenceDAO) context.getBean("competenceDao");
		  Competence competence = (Competence) context.getBean("competence");
		  competence.setIntitule("Langage java EE");
		
		  competence = competenceDao.ajouterCompetenceIfNotExist(competence);
		  Assert.assertNotNull(competence.getId());
		  test.setDuree(60);
		  test.setTitre("Test1");
		  test.setNombrePassage(0);
		  test.getCompetences().add(competence);
		  Assert.assertEquals(1, test.getCompetences().size());
		  testDao.ajouterTest(test);
		  test = testDao.getTestParId(test.getId());
		  Assert.assertEquals(1, test.getCompetences().size());
		  Assert.assertNotNull(test);  
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerTest() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  test.setDuree(60);
		  test.setTitre("Test1");
		  test.setNombrePassage(0);
		  testDao.ajouterTest(test);  
		  testDao.supprimerTest(test.getId());	
		 
		  //List<com.trast.model.Test> tests = testDao.getTests();
		  //Assert.assertEquals("vide",tests.size(),0);
		  test = testDao.getTestParId(test.getId());
		  Assert.assertNull(test);
		  ((ConfigurableApplicationContext)context).close();
	}

}