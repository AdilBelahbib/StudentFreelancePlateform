package com.trast.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.CompetenceDAO;
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
	/************ getters & setters ***************/
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
		/* recuperer une instance test et l'initialiser */
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		test = (Test) context.getBean("test");
		test.setEntreprise(entreprise);
		test.setNombrePassage(0);
				
		((ConfigurableApplicationContext)context).close();
		
	}

	public void retirerCompetence(){
		System.out.println("suppr : "+competence.getIntitule()+" ***");
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
		
	}
	public void ajouterReponseJuste(){
		System.out.println("index : "+statut);
		int i=0;
		for(Question questionItem : test.getQuestions()){
			if(i==Integer.parseInt(statut)) 
			{
				questionItem.getReponsesJustes().add(reponse);
				System.out.println("nbr : "+questionItem.getReponsesJustes().size());
				break;
			}
			else i++;
		}
	}
	
}
