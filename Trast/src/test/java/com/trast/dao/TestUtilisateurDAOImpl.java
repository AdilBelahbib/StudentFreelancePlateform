package com.trast.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Entreprise;
import com.trast.model.Utilisateur;

public class TestUtilisateurDAOImpl {

	@Test
	public void testGetUtilisateurs() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");
		Utilisateur utilisateur = (Utilisateur) context.getBean("utilisateur");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("email@entreprise.com");
		entreprise.setMotDePasse("motDePasse");
		entrepriseDao.ajouterEntreprise(entreprise);
		List<Utilisateur> utilisateurs = utilisateurDao.getUtilisateurs();
		Assert.assertNotNull(utilisateurs);
		utilisateur = utilisateurDao.getUtilisateurParId(entreprise.getId());
		utilisateurDao.supprimerUtilisateur(utilisateur.getId());
		((ConfigurableApplicationContext)context).close();
		
	}

	@Test
	public void testGetUtilisateurParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");
		Utilisateur utilisateur = (Utilisateur) context.getBean("utilisateur");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("email@entreprise.com");
		entreprise.setMotDePasse("motDePasse");
		entrepriseDao.ajouterEntreprise(entreprise);
		utilisateur = utilisateurDao.getUtilisateurParId(entreprise.getId());
		Assert.assertNotNull(utilisateur);
		utilisateurDao.supprimerUtilisateur(utilisateur.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterUtilisateur() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");
		Utilisateur utilisateur = (Utilisateur) context.getBean("utilisateur");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("email@entreprise.com");
		entreprise.setMotDePasse("motDePasse");
		entrepriseDao.ajouterEntreprise(entreprise);
		utilisateur = utilisateurDao.getUtilisateurParId(entreprise.getId());
		Assert.assertNotNull(utilisateur);
		utilisateurDao.supprimerUtilisateur(utilisateur.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierUtilisateur() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");
		Utilisateur utilisateur = (Utilisateur) context.getBean("utilisateur");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("email@entreprise.com");
		entreprise.setMotDePasse("motDePasse");
		entrepriseDao.ajouterEntreprise(entreprise);
		utilisateur = utilisateurDao.getUtilisateurParId(entreprise.getId());
		utilisateur.setMotDePasse("motDePasse2");
		utilisateurDao.modifierUtilisateur(utilisateur);
		utilisateur = utilisateurDao.getUtilisateurParId(entreprise.getId());
		Assert.assertEquals("motDePasse2",utilisateur.getMotDePasse());
		utilisateurDao.supprimerUtilisateur(utilisateur.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerUtilisateur() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");
		Utilisateur utilisateur = (Utilisateur) context.getBean("utilisateur");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("email@entreprise.com");
		entreprise.setMotDePasse("motDePasse");
		entrepriseDao.ajouterEntreprise(entreprise);
		utilisateur = utilisateurDao.getUtilisateurParId(entreprise.getId());
		utilisateurDao.supprimerUtilisateur(utilisateur.getId());
		utilisateur = utilisateurDao.getUtilisateurParId(entreprise.getId());
		Assert.assertNull(utilisateur);
		
		((ConfigurableApplicationContext)context).close();
	}
	
	@Test
	public void testgetByEmailAndMotDePasse(){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");
		Utilisateur utilisateur = (Utilisateur) context.getBean("utilisateur");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("email@entreprise.com");
		entreprise.setMotDePasse("motDePasse");
		entrepriseDao.ajouterEntreprise(entreprise);
		utilisateur = utilisateurDao.getByEmailAndMotDePasse("email@entreprise.com", "motDePasse");
		Assert.assertNotNull(utilisateur);
		utilisateurDao.supprimerUtilisateur(utilisateur.getId());
		((ConfigurableApplicationContext)context).close();
		
	}
	
	@Test
	public void testEmailExiste() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");
		Utilisateur utilisateur = (Utilisateur) context.getBean("utilisateur");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("email@entreprise.com");
		entreprise.setMotDePasse("motDePasse");
		entrepriseDao.ajouterEntreprise(entreprise);
		Assert.assertEquals(true,utilisateurDao.emailExiste("email@entreprise.com"));
		utilisateur = utilisateurDao.getUtilisateurParId(entreprise.getId());
		utilisateurDao.supprimerUtilisateur(utilisateur.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	
	@Test
	public void testGetByEmail() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise) context.getBean("entreprise");
		entreprise.setEmail("email@entreprise.com");
		entreprise.setMotDePasse("motDePasse");
		entrepriseDao.ajouterEntreprise(entreprise);
		
		Utilisateur utilisateur = utilisateurDao.getByEmail(entreprise.getEmail());
		
		junit.framework.Assert.assertEquals(entreprise, utilisateur);
		
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		
		((ConfigurableApplicationContext)context).close();
	}
}
