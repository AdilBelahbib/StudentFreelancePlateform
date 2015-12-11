package com.trast.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Administrateur;

public class TestAdministrateurDAOImpl {
	

	@Test
	public void testGetAdministrateurs() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdministrateur() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testAjouterAdministrateur() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		AdministrateurDAO adminDao = (AdministrateurDAO) context.getBean("administrateurDao");
		Administrateur admin = (Administrateur) context.getBean("administrateur");
		admin.setNomUtilisateur("admin");
		admin.setEmail("admin@mail.com");
		admin.setMotDePasse("mdp");
		admin.setNom("nomAdmin");
		admin.setPrenom("prenomAdmin");		
		adminDao.ajouterAdministrateur(admin);
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerAdministrateur() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifierAdministrateur() {
		fail("Not yet implemented");
	}

}
