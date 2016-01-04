package com.trast.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Etudiant;
import com.trast.model.ResultatTest;


public class TestResultatTestDAOImpl {

	@Test
	public void testGetResultatsTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 /* test*/
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		 com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		 test.setTitre("test1");
		 testDao.ajouterTest(test);
		  /* etudiant*/
		 EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		 Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		 etudiant.setEmail("etudiant2@mail.com");
		 etudiantDao.ajouterEtudiant(etudiant);
		 	/* resultatTest*/
		 ResultatTestDAO resultatTestDao = (ResultatTestDAO) context.getBean("resultatTestDao");
		 ResultatTest resultatTest = (ResultatTest) context.getBean("resultatTest");
		 resultatTest.setScore(100);
		 resultatTest.setEtudiant(etudiant);
		 resultatTest.setTest(test);
		 resultatTestDao.ajouterResultatTest(resultatTest);
		 List<ResultatTest> resultatsTest = resultatTestDao.getResultatsTest();
		  Assert.assertNotNull(resultatsTest); 
		  
		  /* clean up*/
		  resultatTestDao.supprimerResultatTest(resultatTest.getId());
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetResultatTestParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 /* test*/
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		 com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		 test.setTitre("test1");
		 testDao.ajouterTest(test);
		  /* etudiant*/
		 EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		 Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		 etudiant.setEmail("etudiant2@mail.com");
		 etudiantDao.ajouterEtudiant(etudiant);
		 	/* resultatTest*/
		 ResultatTestDAO resultatTestDao = (ResultatTestDAO) context.getBean("resultatTestDao");
		 ResultatTest resultatTest = (ResultatTest) context.getBean("resultatTest");
		 resultatTest.setScore(100);
		 resultatTest.setEtudiant(etudiant);
		 resultatTest.setTest(test);
		 resultatTestDao.ajouterResultatTest(resultatTest);
		 resultatTest = resultatTestDao.getResultatTestParId(resultatTest.getId());
		  Assert.assertNotNull(resultatTest); 
		  
		  /* clean up*/
		  resultatTestDao.supprimerResultatTest(resultatTest.getId());
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterResultatTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 /* test*/
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		 com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		 test.setTitre("test1");
		 testDao.ajouterTest(test);
		  /* etudiant*/
		 EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		 Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		 etudiant.setEmail("etudiant2@mail.com");
		 etudiantDao.ajouterEtudiant(etudiant);
		 	/* resultatTest*/
		 ResultatTestDAO resultatTestDao = (ResultatTestDAO) context.getBean("resultatTestDao");
		 ResultatTest resultatTest = (ResultatTest) context.getBean("resultatTest");
		 resultatTest.setScore(100);
		 resultatTest.setEtudiant(etudiant);
		 resultatTest.setTest(test);
		 resultatTestDao.ajouterResultatTest(resultatTest);
		 resultatTest = resultatTestDao.getResultatTestParId(resultatTest.getId());
		 //List<ResultatTest> resultatsTest = resultatTestDao.getResultatsTest();
		  Assert.assertNotNull(resultatTest); 
		  
		  /* clean up*/
		  resultatTestDao.supprimerResultatTest(resultatTest.getId());
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testModifierResultatTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 /* test*/
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		 com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		 test.setTitre("test1");
		 testDao.ajouterTest(test);
		  /* etudiant*/
		 EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		 Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		 etudiant.setEmail("etudiant2@mail.com");
		 etudiantDao.ajouterEtudiant(etudiant);
		 	/* resultatTest*/
		 ResultatTestDAO resultatTestDao = (ResultatTestDAO) context.getBean("resultatTestDao");
		 ResultatTest resultatTest = (ResultatTest) context.getBean("resultatTest");
		 resultatTest.setScore(100);
		 resultatTest.setEtudiant(etudiant);
		 resultatTest.setTest(test);
		 resultatTestDao.ajouterResultatTest(resultatTest);
		 resultatTest = resultatTestDao.getResultatTestParId(resultatTest.getId());
		 resultatTest.setScore(200);
		 resultatTestDao.modifierResultatTest(resultatTest);
		 Assert.assertEquals(new Double(resultatTest.getScore()),new Double(200));
		 
		  
		  /* clean up*/
		  resultatTestDao.supprimerResultatTest(resultatTest.getId());
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerResultatTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		 /* test*/
		 TestDAO testDao = (TestDAO) context.getBean("testDao");
		 com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		 test.setTitre("test1");
		 testDao.ajouterTest(test);
		  /* etudiant*/
		 EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		 Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		 etudiant.setEmail("etudiant2@mail.com");
		 etudiantDao.ajouterEtudiant(etudiant);
		 	/* resultatTest*/
		 ResultatTestDAO resultatTestDao = (ResultatTestDAO) context.getBean("resultatTestDao");
		 ResultatTest resultatTest = (ResultatTest) context.getBean("resultatTest");
		 resultatTest.setScore(100);
		 resultatTest.setEtudiant(etudiant);
		 resultatTest.setTest(test);
		 resultatTestDao.ajouterResultatTest(resultatTest);
		 resultatTestDao.supprimerResultatTest(resultatTest.getId());
		 //List<ResultatTest> resultatsTest = resultatTestDao.getResultatsTest();
		 //Assert.assertEquals(resultatsTest.size(),0); 
		 resultatTest = resultatTestDao.getResultatTestParId(resultatTest.getId());
		 Assert.assertNull(resultatTest);
		  etudiantDao.supprimerEtudiant(etudiant.getId());
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

}