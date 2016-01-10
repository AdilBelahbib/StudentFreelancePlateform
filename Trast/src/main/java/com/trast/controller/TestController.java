package com.trast.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.NiveauDAO;
import com.trast.dao.ResultatTestDAO;
import com.trast.dao.TestDAO;
import com.trast.model.Competence;
import com.trast.model.Etudiant;
import com.trast.model.Niveau;
import com.trast.model.Question;
import com.trast.model.ResultatTest;
import com.trast.model.Test;

@ManagedBean(name = "testController", eager = true)
@SessionScoped
public class TestController implements Serializable {

	private static final long serialVersionUID = 6368526468221461747L;

	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	private Etudiant etudiant;

	@ManagedProperty(value = "#{resultatTestDao}")
	private ResultatTestDAO resultatTestDao;

	@ManagedProperty(value = "#{testDao}")
	private TestDAO testDao;

	@ManagedProperty(value = "#{niveauDao}")
	private NiveauDAO niveauDao;

	// Tous les tests existant
	private List<Test> tests;

	// Les réponses de l'étudiant
	// Un tableau 2D car chaque question peut avoir plusieurs réponses justes
	private String[][] reponses;

	// Le résultat du test passé
	private ResultatTest resultatTest;

	// Boolean indiquant si le test a été réussi pour la 1ère fois
	private boolean reussi;

	// Le score de l'étudiant
	private double score;

	// Le test en cours
	@ManagedProperty(value = "#{test}")
	private Test test;

	public TestDAO getTestDao() {
		return testDao;
	}

	public void setTestDao(TestDAO testDao) {
		this.testDao = testDao;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public ResultatTestDAO getResultatTestDao() {
		return resultatTestDao;
	}

	public void setResultatTestDao(ResultatTestDAO resultatTestDao) {
		this.resultatTestDao = resultatTestDao;
	}

	public ResultatTest getResultatTest() {
		return resultatTest;
	}

	public void setResultatTest(ResultatTest resultatTest) {
		this.resultatTest = resultatTest;
	}

	public String[][] getReponses() {
		return reponses;
	}

	public void setReponses(String[][] reponses) {
		this.reponses = reponses;
	}

	public NiveauDAO getNiveauDao() {
		return niveauDao;
	}

	public void setNiveauDao(NiveauDAO niveauDao) {
		this.niveauDao = niveauDao;
	}

	public boolean getReussi() {
		return reussi;
	}

	public void setReussi(boolean reussi) {
		this.reussi = reussi;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void getAllTests() {
		tests = testDao.getTests();
	}

	public String lancerTest() {

		// Mettre le test dans le scope Flash pour qu'il ne soit utilisable
		// qu'une seule fois
		Flash flash = (Flash) FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.putNow("test", test);

		// Changer aléatoirement l'ordre des réponses de chaque question
		for (Question question : test.getQuestions())
			question.melangerReponses();

		boolean found = false;

		// Vérifier si l'étudiant a déjà passé ce test
		for (ResultatTest resultat : etudiant.getResultatTests())
			if (resultat.getTest().equals(test)) {
				// Mettre à jour la date du dernier passage et incrémenter le
				// nombre d'essais
				resultat.setDateDernierPassage(new Date());
				resultat.setNbPassage(resultat.getNbPassage() + 1);
				resultatTestDao.modifierResultatTest(resultat);

				found = true;
				break;
			}

		// Si l'étudiant n'a pas déjà passé le test, lui affecter une instance
		// ResultatTest

		if (!found) {
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			ResultatTest resultatTest = (ResultatTest) context.getBean("resultatTest");
			((ConfigurableApplicationContext) context).close();

			resultatTest.setEtudiant(etudiant);
			resultatTest.setScore(0);
			resultatTest.setTest(test);
			resultatTest.setNbPassage(0);
			resultatTest.setDateDernierPassage(new Date());
			resultatTest.setNbPassage(1);

			resultatTestDao.ajouterResultatTest(resultatTest);
			etudiant.getResultatTests().add(resultatTest);
		}

		// Instancier le tableau qui va contenir les réponses de l'étudiant

		this.reponses = new String[test.getQuestions().size()][];
		int i = 0;

		for (Question question : test.getQuestions())
			this.reponses[i++] = new String[question.getReponsesMelangees().size()];

		return "/views/etudiant/passerTest.xhtml?faces-redirect=true";
	}

	public String evaluerTest() {
		double sommeCoefficient = 0;
		double sommeResultat = 0;
		int indiceQuestion = 0;
		boolean correct;

		for (Question question : test.getQuestions()) {
			System.out.println(question.getQuestion());
			correct = false;

			// Parcourir les réponses de la question en cours
			// correct devient true quand les réponses sont justes
			for (int i = 0; i < reponses[indiceQuestion].length; ++i)
				if (question.getReponsesJustes().contains(reponses[indiceQuestion][i]))
					correct = true;
				else {
					correct = false;
					break;
				}

			if (correct)
				sommeResultat += question.getCoefficient();

			sommeCoefficient += question.getCoefficient();
			indiceQuestion++;
		}

		this.score = (sommeResultat / sommeCoefficient) * 100.0;

		// Récupérer les resultat en cours
		for (ResultatTest resultat : etudiant.getResultatTests())
			if (resultat.getTest().equals(test)) {
				this.resultatTest = resultat;
				break;
			}

		// Augmenter le niveau de l'étudiant dans les compétences du test
		// uniquement s'il réussi le test pour la 1ère fois
		this.reussi = false;

		System.out.println("SCORE: " + score + " | resultatScore: " + this.resultatTest.getScore());

		if (score > this.resultatTest.getScore()) {
			// Si la première fois le test est réussi
			if ((this.resultatTest.getScore() < 85) && (score >= 85)) {
				boolean found;

				for (Competence competence : test.getCompetences()) {
					found = false;

					for (Niveau niveau : etudiant.getNiveaux()) {
						if (niveau.getCompetence().equals(competence)) {
							found = true;
							niveau.setMaitrise(niveau.getMaitrise() + 1);
							niveauDao.modifierNiveau(niveau);
						}
					}

					// Si l'étudiant n'a pas cette compétence, on en crée une
					// instance
					if (!found) {
						ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
						Niveau niveau = (Niveau) context.getBean("niveau");
						niveau.setEtudiant(etudiant);
						niveau.setCompetence(competence);
						niveau.setMaitrise(1);

						niveauDao.ajouterNiveau(niveau);

						etudiant.getNiveaux().add(niveau);

						((ConfigurableApplicationContext) context).close();
					}
				}

				this.reussi = true;
				
				/*** ajout badge*************/
				etudiant.getBadges().add(test.getBadge());
			}

			this.resultatTest.setScore(score);
			resultatTestDao.modifierResultatTest(this.resultatTest);
		}
		/*** Incrementer nbr passage test + modification test************/
		test.setNombrePassage(test.getNombrePassage()+1);
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		TestDAO testDao = (TestDAO) context.getBean("testDao");
		testDao.modifierTest(test);
		((ConfigurableApplicationContext) context).close();
		return "/views/etudiant/resultatTest.xhtml";
	}

	public String verifierValiditeTest() {
		// Vérifier s'il y a un test dans le scope Flash. Sinon, effectuer une redirection
		Flash flash = (Flash) FacesContext.getCurrentInstance().getExternalContext().getFlash();

		if(!flash.containsKey("test"))
			return "/views/etudiant/listeTests.xhtml";
		
		return null;
	}

}
