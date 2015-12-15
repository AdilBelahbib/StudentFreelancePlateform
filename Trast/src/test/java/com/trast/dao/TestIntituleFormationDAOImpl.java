package com.trast.dao;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Etablissement;
import com.trast.model.IntituleFormation;

import junit.framework.Assert;

public class TestIntituleFormationDAOImpl {

	@Test
	public void testGetIntituleFormations() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		etablissement.setNomEtablissement("nomEtablissement");
		etablissementDao.ajouterEtablissement(etablissement);
		IntituleFormationDAO intituleDao = (IntituleFormationDAO) context.getBean("intituleFormationDao");
		IntituleFormation intitule = (IntituleFormation) context.getBean("intituleFormation");
		intitule.setIntitule("intitule");
		intitule.setEtablissement(etablissement);
		intituleDao.ajouterIntituleFormation(intitule);
		List<IntituleFormation> intitules = intituleDao.getIntituleFormations();
		Assert.assertNotNull(intitules);
		intituleDao.supprimerIntituleFormation(intitule.getId());
		etablissementDao.supprimerEtablissement(etablissement.getId());
		
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetIntituleFormationParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		etablissement.setNomEtablissement("nomEtablissement");
		etablissementDao.ajouterEtablissement(etablissement);
		IntituleFormationDAO intituleDao = (IntituleFormationDAO) context.getBean("intituleFormationDao");
		IntituleFormation intitule = (IntituleFormation) context.getBean("intituleFormation");
		intitule.setIntitule("intitule");
		intitule.setEtablissement(etablissement);
		intituleDao.ajouterIntituleFormation(intitule);
		intitule = intituleDao.getIntituleFormationParId(intitule.getId());
		Assert.assertNotNull(intitule);
		intituleDao.supprimerIntituleFormation(intitule.getId());
		etablissementDao.supprimerEtablissement(etablissement.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterIntituleFormation() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		etablissement.setNomEtablissement("nomEtablissement");
		etablissementDao.ajouterEtablissement(etablissement);
		IntituleFormationDAO intituleDao = (IntituleFormationDAO) context.getBean("intituleFormationDao");
		IntituleFormation intitule = (IntituleFormation) context.getBean("intituleFormation");
		intitule.setIntitule("intitule");
		intitule.setEtablissement(etablissement);
		intituleDao.ajouterIntituleFormation(intitule);
		intitule = intituleDao.getIntituleFormationParId(intitule.getId());
		Assert.assertNotNull(intitule);
		intituleDao.supprimerIntituleFormation(intitule.getId());
		etablissementDao.supprimerEtablissement(etablissement.getId());
		
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierIntituleFormation() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		etablissement.setNomEtablissement("nomEtablissement");
		etablissementDao.ajouterEtablissement(etablissement);
		IntituleFormationDAO intituleDao = (IntituleFormationDAO) context.getBean("intituleFormationDao");
		IntituleFormation intitule = (IntituleFormation) context.getBean("intituleFormation");
		intitule.setIntitule("intitule");
		intitule.setEtablissement(etablissement);
		intituleDao.ajouterIntituleFormation(intitule);
		intitule = intituleDao.getIntituleFormationParId(intitule.getId());
		intitule.setIntitule("intitule2");
		intituleDao.modifierIntituleFormation(intitule);
		Assert.assertEquals("intitule2", intitule.getIntitule());
		
		intituleDao.supprimerIntituleFormation(intitule.getId());
		etablissementDao.supprimerEtablissement(etablissement.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerIntituleFormation() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		etablissement.setNomEtablissement("nomEtablissement");
		etablissementDao.ajouterEtablissement(etablissement);
		IntituleFormationDAO intituleDao = (IntituleFormationDAO) context.getBean("intituleFormationDao");
		IntituleFormation intitule = (IntituleFormation) context.getBean("intituleFormation");
		intitule.setIntitule("intitule");
		intitule.setEtablissement(etablissement);
		intituleDao.ajouterIntituleFormation(intitule);
		intituleDao.supprimerIntituleFormation(intitule.getId());
		intitule = intituleDao.getIntituleFormationParId(intitule.getId());
		Assert.assertNull(intitule);
		etablissementDao.supprimerEtablissement(etablissement.getId());
		((ConfigurableApplicationContext)context).close();
	}

}
