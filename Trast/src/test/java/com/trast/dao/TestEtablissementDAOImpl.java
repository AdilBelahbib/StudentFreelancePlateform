package com.trast.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Etablissement;

public class TestEtablissementDAOImpl {

	@Test
	public void testGetEtablissements() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); 
		
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		
		etablissement.setNomEtablissement("nomEtablissement");		
		etablissementDao.ajouterEtablissement(etablissement);
		
		List<Etablissement>	etablissements;
		
		etablissements = etablissementDao.getEtablissements();	
		
		Assert.assertNotNull(etablissements);
		
		etablissementDao.supprimerEtablissement(etablissement.getId());

		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetEtablissementParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); 
		
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		
		etablissement.setNomEtablissement("nomEtablissement");
		
		etablissementDao.ajouterEtablissement(etablissement);
		
		etablissement = etablissementDao.getEtablissementParId(etablissement.getId());	
		
		Assert.assertNotNull(etablissement);
		
		etablissementDao.supprimerEtablissement(etablissement.getId());

		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterEtablissement() {		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); 
		
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		
		etablissement.setNomEtablissement("nomEtablissement");
		
		etablissementDao.ajouterEtablissement(etablissement);
		etablissement = etablissementDao.getEtablissementParId(etablissement.getId());	
		
		Assert.assertNotNull(etablissement);
		
		etablissementDao.supprimerEtablissement(etablissement.getId());

		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierEtablissement() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); 
		
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		
		etablissement.setNomEtablissement("nomEtablissement");
		
		etablissementDao.ajouterEtablissement(etablissement);
		etablissement.setNomEtablissement("nouveauNom");		
		etablissementDao.modifierEtablissement(etablissement);
		
		etablissement = etablissementDao.getEtablissementParId(etablissement.getId());	
		
		Assert.assertNotNull(etablissement);
		
		etablissementDao.supprimerEtablissement(etablissement.getId());

		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerEtablissement() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); 
		
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		
		etablissement.setNomEtablissement("nomEtablissement");
		
		etablissementDao.ajouterEtablissement(etablissement);
				
		etablissement = etablissementDao.getEtablissementParId(etablissement.getId());	
		
		Assert.assertNotNull(etablissement);
		
		etablissementDao.supprimerEtablissement(etablissement.getId());

		((ConfigurableApplicationContext)context).close();
	}

}
