package com.trast.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.BadgeDAO;
import com.trast.dao.CompetenceDAO;
import com.trast.dao.FichierDAO;
import com.trast.dao.QuestionDAO;
import com.trast.dao.TestDAO;
import com.trast.model.Administrateur;
import com.trast.model.Badge;
import com.trast.model.Competence;
import com.trast.model.Entreprise;
import com.trast.model.Fichier;
import com.trast.model.Question;
import com.trast.model.Test;
import com.trast.model.Utilisateur;
import com.trast.service.UploadFileService;

@ManagedBean(name = "testControllerNassima", eager = true)
@SessionScoped
public class TestControllerNassima implements Serializable{
	private static final long serialVersionUID = -6584428675356216970L;
	
	/***************** managed properties ********************/
	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	Utilisateur utilisateur;
	//Entreprise entreprise;
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
	@ManagedProperty(value = "#{tests}")
	List<Test> tests;
	@ManagedProperty(value = "#{badge}")
	Badge badge;
	/************ getters & setters ***************/
	public Badge getBadge() {
		return badge;
	}
	public void setBadge(Badge badge) {
		this.badge = badge;
	}
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
	/*public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}*/
	
	public Test getTest() {
		return test;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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
	
	public List<Test> getTests() {
		return tests;
	}
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	/*-------------------------------------------*/
	/******* method ***********************/
	public void creerTest(){
		if(this.getRedirection()==0){
			
		/* recuperer une instance test et l'initialiser */
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		test = (Test) context.getBean("test");
		if(utilisateur instanceof Entreprise) test.setEntreprise((Entreprise) utilisateur);
		test.setNombrePassage(0);
		((ConfigurableApplicationContext)context).close();
		}
		else this.setRedirection(0);
		
	}

	public void retirerCompetence(){
		test.getCompetences().remove(competence);	
	}
	public void ajouterCompetence(){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		/* verifier si ca existe deja*/
		CompetenceDAO competenceDao = (CompetenceDAO)context.getBean("competenceDao");
		competence = competenceDao.ajouterCompetenceIfNotExist(competence);
		test.getCompetences().add(competence);
		competence = (Competence)context.getBean("competence");
		((ConfigurableApplicationContext) context).close();	
	}
	public void retirerQuestion(){
		test.getQuestions().remove(question);
	}
	public void ajouterQuestion(){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		test.getQuestions().add(question);
		question = (Question) context.getBean("question");
		((ConfigurableApplicationContext) context).close();	
	}
	public void retirerReponseJuste(){
		question.getReponsesJustes().remove(reponse);
		reponse = "";
	}
	public void ajouterReponseJuste(){
		
		question.getReponsesJustes().add(reponse);
		reponse = "";
	}
	
	public void retirerReponseFausse(){
		question.getReponsesFausses().remove(reponse);
		reponse = "";
	}
	public void ajouterReponseFausse(){
		question.getReponsesFausses().add(reponse);
		reponse = "";
	}
	public String modifierQuestion(){
		int i=0;
		for(Question questionItem : test.getQuestions()){
			
			if(i==Integer.parseInt(statut)) 
			{
				questionItem = question;
				break;
			}
			else i++;
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		question = (Question) context.getBean("question");
		((ConfigurableApplicationContext) context).close();	
		this.setRedirection(1);
		if(utilisateur instanceof Entreprise)
		return "/views/entreprise/creerTest.xhtml?faces-redirect=true";
		else return "/views/admin/creerTest.xhtml?faces-redirect=true";
	}
	/* persister le test dans la BdD*/
	public String validerTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		/* recupere icone */
		if(UploadFileService.fileSelected()){
		Fichier fichier = (Fichier)context.getBean("fichier");
		FichierDAO fichierDao = (FichierDAO)context.getBean("fichierDao");

		/* intitule badge*/
		badge.setIntitule("Test "+test.getTitre());
		/** chemin ????**/
		fichier.setChemin("../../resources/uploadedImages");
		fichier.setTitre(badge.getIntitule()+utilisateur.getId());
		UploadFileService.uploadFichier(fichier);
		
		fichierDao.ajouterFichier(fichier);
		/* ajout Badge*/
		badge.setIcone(fichier);
		BadgeDAO badgeDao = (BadgeDAO) context.getBean("badgeDao");
		badgeDao.ajouterBadge(badge);
		
		test.setBadge(badge);
		}
		
		
		/* ajouter Test*/
		TestDAO testDao = (TestDAO) context.getBean("testDao");
		testDao.ajouterTest(test);
		
		/**/
		CompetenceDAO competenceDao = (CompetenceDAO)context.getBean("competenceDao");
		for(Competence compItem : test.getCompetences())
		{
			compItem = competenceDao.ajouterCompetenceIfNotExist(compItem);

		}
		/**/
		/* ajouter Questions*/
		QuestionDAO questionDao = (QuestionDAO) context.getBean("questionDao");
		for(Question questionItem : test.getQuestions()){
			questionItem.setTest(test);
			questionDao.ajouterQuestion(questionItem);
		}
		
		/* fichier */
		badge = (Badge) context.getBean("badge");
	
		((ConfigurableApplicationContext) context).close();
		
		
		
		if(utilisateur instanceof Entreprise){
			((Entreprise)utilisateur).getTests().add(test);
			return "/views/entreprise/listeTests.xhtml?faces-redirect=true";
		}
		
		else return "/views/admin/listeTests.xhtml?faces-redirect=true";
	}
	
	
	/* recuperer liste de tests*/
	public void listTests(){
		if(utilisateur instanceof Administrateur)
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			TestDAO testDao = (TestDAO) context.getBean("testDao");
			tests = testDao.getTestsAdmin();
			((ConfigurableApplicationContext) context).close();
		}	
		else tests = new ArrayList<Test>(((Entreprise)utilisateur).getTests());
	}
	public void listTestsEntreprises(){
		if(utilisateur instanceof Administrateur)
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			TestDAO testDao = (TestDAO) context.getBean("testDao");
			tests = testDao.getTestsEntreprises();
			((ConfigurableApplicationContext) context).close();
		}	
	}
	public void supprimerTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		TestDAO testDao = (TestDAO) context.getBean("testDao");
		testDao.supprimerTest(test.getId());
		tests.remove(test);
		if(utilisateur instanceof Entreprise)
			((Entreprise)utilisateur).getTests().remove(test);
		((ConfigurableApplicationContext) context).close();
		
		
	}
	
}
