package com.trast.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Adresse;
import com.trast.model.Administrateur;

public class TestAdresseDAOImpl {

	@Test
	public void testGetAdresses() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AdresseDAO adresseDao = (AdresseDAO) context.getBean("adresseDao");
		Adresse adresse = (Adresse) context.getBean("adresse");
		
		Administrateur admin = (Administrateur)context.getBean("administrateur");
		AdministrateurDAO adminDao = (AdministrateurDAO) context.getBean("administrateurDao");
		
		admin.setEmail("admin@gmail.com");
		admin.setMotDePasse("mdp");
		
		adresse.setPays("Maroc");
		adresse.setVille("Rabat");
		adresse.setAdresse("Sidi Moussa");
		
		List<Adresse> adresses;
		
		adminDao.ajouterAdministrateur(admin);
						
		adresseDao.ajouterAdresse(adresse);
		
		adresses = adresseDao.getAdresses();
		Assert.assertNotNull(adresses);
		adresseDao.supprimerAdresse(adresse.getId());
		adminDao.supprimerAdministrateur(admin.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetAdresseParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AdresseDAO adresseDao = (AdresseDAO) context.getBean("adresseDao");
		Adresse adresse = (Adresse) context.getBean("adresse");

		adresse.setPays("Maroc");
		adresse.setVille("Rabat");
		adresse.setAdresse("Sidi Moussa");

		adresseDao.ajouterAdresse(adresse);
		adresse = adresseDao.getAdresseParId(adresse.getId());
		Assert.assertNotNull(adresse);
		adresseDao.supprimerAdresse(adresse.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterAdresse() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AdresseDAO adresseDao = (AdresseDAO) context.getBean("adresseDao");
		Adresse adresse = (Adresse) context.getBean("adresse");

		adresse.setPays("Maroc");
		adresse.setVille("Rabat");
		adresse.setAdresse("Sidi Moussa");
						
		adresseDao.ajouterAdresse(adresse);
		adresse = adresseDao.getAdresseParId(adresse.getId());
		Assert.assertNotNull(adresse);
		adresseDao.supprimerAdresse(adresse.getId());

		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierAdresse() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AdresseDAO adresseDao = (AdresseDAO) context.getBean("adresseDao");
		Adresse adresse = (Adresse) context.getBean("adresse");

		adresse.setPays("Maroc");
		adresse.setVille("Rabat");
		adresse.setAdresse("Sidi Moussa");
						
		adresseDao.ajouterAdresse(adresse);
		adresse.setVille("Sal�");
		adresseDao.modifierAdresse(adresse);
		adresse = adresseDao.getAdresseParId(adresse.getId());
		Assert.assertNotNull(adresse);
		adresseDao.supprimerAdresse(adresse.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerAdresse() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AdresseDAO adresseDao = (AdresseDAO) context.getBean("adresseDao");
		Adresse adresse = (Adresse) context.getBean("adresse");
		
		adresse.setPays("Maroc");
		adresse.setVille("Rabat");
		adresse.setAdresse("Sidi Moussa");
						
		adresseDao.ajouterAdresse(adresse);
		adresse = adresseDao.getAdresseParId(adresse.getId());
		Assert.assertNotNull(adresse);
		adresseDao.supprimerAdresse(adresse.getId());
		((ConfigurableApplicationContext)context).close();
	}

}
