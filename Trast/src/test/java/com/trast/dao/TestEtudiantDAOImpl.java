package com.trast.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Etudiant;

public class TestEtudiantDAOImpl {

	@Test
	public void testGetEtudiants() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		
		
		etudiant.setNombreBids(5);
		
		List<Etudiant> etudiants;
		
		etudiantDao.ajouterEtudiant(etudiant);
		etudiants = etudiantDao.getEtudiants();
		
		Assert.assertNotNull(etudiants);
		
		etudiantDao.supprimerEtudiant(etudiant.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterEtudiant() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		
		etudiant.setNom("nomEtudiant");
		etudiant.setPrenom("prenomEtudiant");
		
		etudiant.setNombreBids(5);
		
		etudiantDao.ajouterEtudiant(etudiant);
		etudiant = etudiantDao.getEtudiant(etudiant.getId());
		
		Assert.assertNotNull(etudiant);
		
		etudiantDao.supprimerEtudiant(etudiant.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetEtudiant() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		
		
		etudiant.setNombreBids(5);
		
		etudiantDao.ajouterEtudiant(etudiant);
		etudiant = etudiantDao.getEtudiant(etudiant.getId());
		
		Assert.assertNotNull(etudiant);
		
		etudiantDao.supprimerEtudiant(etudiant.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerEtudiant() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		
		
		etudiant.setNombreBids(5);
		
		etudiantDao.ajouterEtudiant(etudiant);
		etudiant = etudiantDao.getEtudiant(etudiant.getId());
		
		Assert.assertNotNull(etudiant);
		
		etudiantDao.supprimerEtudiant(etudiant.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierEtudiant() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		
		
		etudiant.setNombreBids(5);
		
		etudiantDao.ajouterEtudiant(etudiant);		
		etudiant.setNombreBids(4);
		
		etudiantDao.modifierEtudiant(etudiant);
		etudiant = etudiantDao.getEtudiant(etudiant.getId());
		
		Assert.assertNotNull(etudiant);
		
		etudiantDao.supprimerEtudiant(etudiant.getId());
		((ConfigurableApplicationContext)context).close();
	}

}
