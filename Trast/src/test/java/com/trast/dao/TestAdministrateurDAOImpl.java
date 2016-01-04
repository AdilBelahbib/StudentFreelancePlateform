package com.trast.dao;



import java.util.List;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Administrateur;

public class TestAdministrateurDAOImpl {

	@Test
	public void testGetAdministrateurs() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AdministrateurDAO adminDao = (AdministrateurDAO) context.getBean("administrateurDao");
		Administrateur admin = (Administrateur) context.getBean("administrateur");
		admin.setEmail("admintest@mail.com");
		admin.setMotDePasse("mdp");
		admin.setNom("nomAdmin");
		admin.setPrenom("prenomAdmin");
		
		List<Administrateur> admins;
				
		adminDao.ajouterAdministrateur(admin);
		admins = adminDao.getAdministrateurs();
		Assert.assertNotNull(admins);
		adminDao.supprimerAdministrateur(admin.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetAdministrateur() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AdministrateurDAO adminDao = (AdministrateurDAO) context.getBean("administrateurDao");
		Administrateur admin = (Administrateur) context.getBean("administrateur");
		admin.setEmail("admintest@mail.com");
		admin.setMotDePasse("mdp");
		admin.setNom("nomAdmin");
		admin.setPrenom("prenomAdmin");
		
		adminDao.ajouterAdministrateur(admin);
		admin = adminDao.getAdministrateur(admin.getId());
		Assert.assertNotNull(admin);
		adminDao.supprimerAdministrateur(admin.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterAdministrateur() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AdministrateurDAO adminDao = (AdministrateurDAO) context.getBean("administrateurDao");
		Administrateur admin = (Administrateur) context.getBean("administrateur");
		admin.setEmail("admintest@mail.com");
		admin.setMotDePasse("mdp");
		admin.setNom("nomAdmin");
		admin.setPrenom("prenomAdmin");
		
		adminDao.ajouterAdministrateur(admin);
		admin = adminDao.getAdministrateur(admin.getId());
		Assert.assertNotNull(admin);
		adminDao.supprimerAdministrateur(admin.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerAdministrateur() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AdministrateurDAO adminDao = (AdministrateurDAO) context.getBean("administrateurDao");
		Administrateur admin = (Administrateur) context.getBean("administrateur");
		admin.setEmail("admintest@mail.com");
		admin.setMotDePasse("mdp");
		admin.setNom("nomAdmin");
		admin.setPrenom("prenomAdmin");
		
		adminDao.ajouterAdministrateur(admin);	
		admin = adminDao.getAdministrateur(admin.getId());
		Assert.assertNotNull(admin);
		adminDao.supprimerAdministrateur(admin.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierAdministrateur() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AdministrateurDAO adminDao = (AdministrateurDAO) context.getBean("administrateurDao");
		Administrateur admin = (Administrateur) context.getBean("administrateur");
		admin.setEmail("admintest@mail.com");
		admin.setMotDePasse("mdp");
		admin.setNom("nomAdmin");
		admin.setPrenom("prenomAdmin");
		
		adminDao.ajouterAdministrateur(admin);
		admin.setEmail("adminModifie@mail.com");
		adminDao.modifierAdministrateur(admin);
		admin = adminDao.getAdministrateur(admin.getId());		
		Assert.assertNotNull(admin);
		adminDao.supprimerAdministrateur(admin.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

}
