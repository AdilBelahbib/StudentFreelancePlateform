package com.trast.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.trast.model.Fichier;

public class TestFichierDAOImpl {

	@Test
	public void testGetFichiers() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		FichierDAO fichierDao = (FichierDAO) context.getBean("fichierDao");
		Fichier fichier = (Fichier) context.getBean("fichier");
		fichier.setTitre("titre");
		fichier.setChemin("chemin");
		fichierDao.ajouterFichier(fichier);
		List<Fichier> fichiers = fichierDao.getFichiers();
		Assert.assertNotNull(fichiers);
		fichierDao.supprimerFichier(fichier.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetFichierParId() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		FichierDAO fichierDao = (FichierDAO) context.getBean("fichierDao");
		Fichier fichier = (Fichier) context.getBean("fichier");
		fichier.setTitre("titre");
		fichier.setChemin("chemin");
		fichierDao.ajouterFichier(fichier);
		fichier = fichierDao.getFichierParId(fichier.getId());
		Assert.assertNotNull(fichier);
		fichierDao.supprimerFichier(fichier.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterFichier() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		FichierDAO fichierDao = (FichierDAO) context.getBean("fichierDao");
		Fichier fichier = (Fichier) context.getBean("fichier");
		fichier.setTitre("titre");
		fichier.setChemin("chemin");
		fichierDao.ajouterFichier(fichier);
		fichier = fichierDao.getFichierParId(fichier.getId());
		Assert.assertNotNull(fichier);
		fichierDao.supprimerFichier(fichier.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierFichier() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		FichierDAO fichierDao = (FichierDAO) context.getBean("fichierDao");
		Fichier fichier = (Fichier) context.getBean("fichier");
		fichier.setTitre("titre");
		fichier.setChemin("chemin");
		fichierDao.ajouterFichier(fichier);
		fichier = fichierDao.getFichierParId(fichier.getId());
		Assert.assertNotNull(fichier);
		fichier.setTitre("titre2");
		fichier.setChemin("chemin2");
		fichierDao.modifierFichier(fichier);
		fichier = fichierDao.getFichierParId(fichier.getId());
		Assert.assertEquals("titre2",fichier.getTitre());
		fichierDao.supprimerFichier(fichier.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerFichier() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		FichierDAO fichierDao = (FichierDAO) context.getBean("fichierDao");
		Fichier fichier = (Fichier) context.getBean("fichier");
		fichier.setTitre("titre");
		fichier.setChemin("chemin");
		fichierDao.ajouterFichier(fichier);
		fichier = fichierDao.getFichierParId(fichier.getId());
		Assert.assertNotNull(fichier);
		fichierDao.supprimerFichier(fichier.getId());
		fichier = fichierDao.getFichierParId(fichier.getId());
		Assert.assertNull(fichier);
		((ConfigurableApplicationContext)context).close();
		
	}

}
