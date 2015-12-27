package com.trast.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTestDAOImpl {

	@Test
	public void testGetTests() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  test.setDuree(60);
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
		  test.setDuree(60);
		  test.setNombrePassage(0);
		  testDao.ajouterTest(test);
		  List<com.trast.model.Test> tests = testDao.getTests();
		  Assert.assertNotNull(tests);  
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerTest() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  test.setDuree(60);
		  test.setNombrePassage(0);
		  testDao.ajouterTest(test);  
		  testDao.supprimerTest(test.getId());	
		  List<com.trast.model.Test> tests = testDao.getTests();
		  Assert.assertEquals("vide",tests.size(),0);
		  ((ConfigurableApplicationContext)context).close();
	}

}