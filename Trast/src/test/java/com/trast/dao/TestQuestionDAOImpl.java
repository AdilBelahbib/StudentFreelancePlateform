package com.trast.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Question;

public class TestQuestionDAOImpl {

	@Test
	public void testGetQuestionParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		  TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  test.setDuree(60);
		  test.setTitre("Test1");
		  test.setNombrePassage(0);
		  testDao.ajouterTest(test);
		  QuestionDAO questionDao = (QuestionDAO) context.getBean("questionDao");
		  Question question = (Question) context.getBean("question");
		  question.setQuestion("question");
		  question.setCoefficient(1);
		  question.setTest(test);
		  question.getReponsesFausses().add("reponse fausse");
		  question.getReponsesJustes().add("reponse juste");
		  questionDao.ajouterQuestion(question);
		  question = questionDao.getQuestionParId(question.getId());
		  Assert.assertNotNull(question);
		  
		  
		  /////////// Clean up /////////////
		  questionDao.supprimerQuestion(question);
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetQuestions() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		  TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  test.setDuree(60);
		  test.setTitre("Test1");
		  test.setNombrePassage(0);
		  testDao.ajouterTest(test);
		  QuestionDAO questionDao = (QuestionDAO) context.getBean("questionDao");
		  Question question = (Question) context.getBean("question");
		  question.setQuestion("question");
		  question.setCoefficient(1);
		  question.setTest(test);
		  question.getReponsesFausses().add("reponse fausse");
		  question.getReponsesJustes().add("reponse juste");
		  questionDao.ajouterQuestion(question);
		  List<Question> questions = questionDao.getQuestions();
		  Assert.assertEquals(14,questions.size());
		  Assert.assertEquals(1,question.getReponsesFausses().size());
		  /////////// Clean up /////////////
		  questionDao.supprimerQuestion(question);
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterQuestion() {
		  ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		  TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  test.setDuree(60);
		  test.setTitre("Test1");
		  test.setNombrePassage(0);
		  testDao.ajouterTest(test);
		  QuestionDAO questionDao = (QuestionDAO) context.getBean("questionDao");
		  Question question = (Question) context.getBean("question");
		  question.setQuestion("question");
		  question.setCoefficient(1);
		  question.setTest(test);
		  question.getReponsesFausses().add("reponse fausse");
		  question.getReponsesJustes().add("reponse juste");
		  questionDao.ajouterQuestion(question);
		  question = questionDao.getQuestionParId(question.getId());
		  Assert.assertNotNull(question);
		  Assert.assertEquals(1,question.getReponsesFausses().size());
		  
		  
		  /////////// Clean up /////////////
		  questionDao.supprimerQuestion(question);
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerQuestion() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		  TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  test.setDuree(60);
		  test.setTitre("Test1");
		  test.setNombrePassage(0);
		  testDao.ajouterTest(test);
		  QuestionDAO questionDao = (QuestionDAO) context.getBean("questionDao");
		  Question question = (Question) context.getBean("question");
		  question.setQuestion("question");
		  question.setCoefficient(1);
		  question.setTest(test);
		  question.getReponsesFausses().add("reponse fausse");
		  question.getReponsesJustes().add("reponse juste");
		  questionDao.ajouterQuestion(question);
		  question = questionDao.getQuestionParId(question.getId());
		  questionDao.supprimerQuestion(question);
		  question = questionDao.getQuestionParId(question.getId());
		  Assert.assertNull(question);
		 
		  
		  
		  /////////// Clean up /////////////
		  
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierQuestion() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	  
		  TestDAO testDao = (TestDAO) context.getBean("testDao");
		  com.trast.model.Test test = (com.trast.model.Test) context.getBean("test");	
		  test.setDuree(60);
		  test.setTitre("Test1");
		  test.setNombrePassage(0);
		  testDao.ajouterTest(test);
		  QuestionDAO questionDao = (QuestionDAO) context.getBean("questionDao");
		  Question question = (Question) context.getBean("question");
		  question.setQuestion("question");
		  question.setCoefficient(1);
		  question.setTest(test);
		  question.getReponsesFausses().add("reponse fausse");
		  questionDao.ajouterQuestion(question);
		  question = questionDao.getQuestionParId(question.getId());
		  question.getReponsesFausses().add("reponse juste");
		  questionDao.modifierQuestion(question);
		  question = questionDao.getQuestionParId(question.getId());
		  Assert.assertEquals(2,question.getReponsesFausses().size());
		  
		  
		  /////////// Clean up /////////////
		  questionDao.supprimerQuestion(question);
		  testDao.supprimerTest(test.getId());		  
		  ((ConfigurableApplicationContext)context).close();
	}

}
