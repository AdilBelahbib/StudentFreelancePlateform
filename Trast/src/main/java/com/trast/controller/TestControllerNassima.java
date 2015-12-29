package com.trast.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.CompetenceDAO;
import com.trast.dao.QuestionDAO;
import com.trast.dao.TestDAO;
import com.trast.model.Competence;
import com.trast.model.Entreprise;
import com.trast.model.Question;
import com.trast.model.Test;

@ManagedBean(name = "testControllerNassima", eager = true)
@SessionScoped
public class TestControllerNassima implements Serializable{
	private static final long serialVersionUID = -6584428675356216970L;
	
	/***************** managed properties ********************/
	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	Entreprise entreprise;
	@ManagedProperty(value = "#{test}")
	Test test;
	@ManagedProperty(value = "#{competence}")
	Competence competence;
	@ManagedProperty(value = "#{question}")
	Question question;
	@ManagedProperty(value = "#{statut}")
	String statut;
	@ManagedProperty(value = "#{reponse}")
	String reponse;
	@ManagedProperty(value = "#{redirection}")
	int redirection;
	/************ getters & setters ***************/
	public int getRedirection() {
		return redirection;
	}
	public void setRedirection(int redirection) {
		this.redirection = redirection;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
		/*if(test!=null){
			System.out.println("ajout comp : "+competence.getIntitule()+" taille "+test.getCompetences().size());
			test.getCompetences().add(competence);
			competence = null;
		}*/
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	/*-------------------------------------------*/
	/******* method ***********************/
	public void creerTest(){
		if(this.getRedirection()==0){
			
		/* recuperer une instance test et l'initialiser */
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		test = (Test) context.getBean("test");
		test.setEntreprise(entreprise);
		test.setNombrePassage(0);
				
		((ConfigurableApplicationContext)context).close();
		}
		else this.setRedirection(0);
		
	}

	public void retirerCompetence(){
		System.out.println("suppr : "+test.getCompetences().size()+" ***");
		test.getCompetences().remove(competence);	
		System.out.println("fin supp");
	}
	public void ajouterCompetence(){
		System.out.println("ajout**************");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		/* verifier si ca existe deja*/
		CompetenceDAO competenceDao = (CompetenceDAO)context.getBean("competenceDao");
		competenceDao.ajouterCompetenceIfNotExist(competence);
		test.getCompetences().add(competence);
		competence = (Competence)context.getBean("competence");
		((ConfigurableApplicationContext) context).close();	
	}
	public void retirerQuestion(){
		test.getQuestions().remove(question);
		//System.out.println("sssssssssssss "+statut );
	}
	public void ajouterQuestion(){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		System.out.println("quest : "+question.getQuestion()+", coef "+question.getCoefficient());
		test.getQuestions().add(question);
		question = (Question) context.getBean("question");
		((ConfigurableApplicationContext) context).close();	
		System.out.println("size: "+test.getQuestions().size());
	}
	public void retirerReponseJuste(){
		question.getReponsesJustes().remove(reponse);
	}
	public void ajouterReponseJuste(){
		/*System.out.println("index : "+statut);
		int i=0;
		for(Question questionItem : test.getQuestions()){
			if(i==Integer.parseInt(statut)) 
			{
				questionItem.getReponsesJustes().add(reponse);
				System.out.println("nbr : "+questionItem.getReponsesJustes().size());
				break;
			}
			else i++;
		}*/
		question.getReponsesJustes().add(reponse);
	}
	
	public void retirerReponseFausse(){
		question.getReponsesFausses().remove(reponse);
	}
	public void ajouterReponseFausse(){
		question.getReponsesFausses().add(reponse);
	}
	public String modifierQuestion(){
		int i=0;
		for(Question questionItem : test.getQuestions()){
			
			if(i==Integer.parseInt(statut)) 
			{
				questionItem = question;
				System.out.println("nbr : "+questionItem.getReponsesJustes().size());
				break;
			}
			else i++;
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		question = (Question) context.getBean("question");
		((ConfigurableApplicationContext) context).close();	
		System.out.println("size: "+test.getQuestions().size());
		this.setRedirection(1);
		return "/views/entreprise/creerTest.xhtml?faces-redirect=true";
	}
	/* persister le test dans la BdD*/
	public String validerTest(){
		/* ajouter Test*/
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		TestDAO testDao = (TestDAO) context.getBean("testDao");
		testDao.ajouterTest(test);
		/* ajouter Questions*/
		QuestionDAO questionDao = (QuestionDAO) context.getBean("questionDao");
		for(Question questionItem : test.getQuestions()){
			questionItem.setTest(test);
			questionDao.ajouterQuestion(questionItem);
		}
		return "/views/entreprise/creerTest.xhtml?faces-redirect=true";
	}
	
}
