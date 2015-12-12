package com.trast.dao;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Particulier;


public class TestParticulierDAOImpl {

	@Test
	public void testGetParticuliers() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		ParticulierDAO particulierDao = (ParticulierDAO) context.getBean("particulierDao");
		Particulier particulier = (Particulier) context.getBean("particulier");
		particulier.setNom("nom");
		particulier.setEmail("email");
		particulier.setMotDePasse("motDePasse");
		particulier.setNomUtilisateur("nomUtilisateur");
		particulier.setPrenom("prenom");		
		particulierDao.ajouterParticulier(particulier);
		List<Particulier> particuliers = particulierDao.getParticuliers();
		Assert.assertNotNull(particuliers);
		particulierDao.supprimerParticulier(particulier.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetParticulier() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		ParticulierDAO particulierDao = (ParticulierDAO) context.getBean("particulierDao");
		Particulier particulier = (Particulier) context.getBean("particulier");
		particulier.setNom("nom");
		particulier.setEmail("email");
		particulier.setMotDePasse("motDePasse");
		particulier.setNomUtilisateur("nomUtilisateur");
		particulier.setPrenom("prenom");
		particulierDao.ajouterParticulier(particulier);
		particulier = particulierDao.getParticulier(particulier.getId());
		Assert.assertNotNull(particulier);
		particulierDao.supprimerParticulier(particulier.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterParticulier() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		ParticulierDAO particulierDao = (ParticulierDAO) context.getBean("particulierDao");
		Particulier particulier = (Particulier) context.getBean("particulier");
		particulier.setNom("nom");
		particulier.setEmail("email");
		particulier.setMotDePasse("motDePasse");
		particulier.setNomUtilisateur("nomUtilisateur");
		particulier.setPrenom("prenom");
		particulierDao.ajouterParticulier(particulier);
		particulier = particulierDao.getParticulier(particulier.getId());
		Assert.assertNotNull(particulier);
		particulierDao.supprimerParticulier(particulier.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerParticulier() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		ParticulierDAO particulierDao = (ParticulierDAO) context.getBean("particulierDao");
		Particulier particulier = (Particulier) context.getBean("particulier");
		particulier.setNom("nom");
		particulier.setEmail("email");
		particulier.setMotDePasse("motDePasse");
		particulier.setNomUtilisateur("nomUtilisateur");
		particulier.setPrenom("prenom");
		particulierDao.ajouterParticulier(particulier);
		particulier = particulierDao.getParticulier(particulier.getId());
		Assert.assertNotNull(particulier);
		particulierDao.supprimerParticulier(particulier.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierParticulier() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		ParticulierDAO particulierDao = (ParticulierDAO) context.getBean("particulierDao");
		Particulier particulier = (Particulier) context.getBean("particulier");
		particulier.setNom("nom");
		particulier.setEmail("email");
		particulier.setMotDePasse("motDePasse");
		particulier.setNomUtilisateur("nomUtilisateur");
		particulier.setPrenom("prenom");
		particulierDao.ajouterParticulier(particulier);
		particulier = particulierDao.getParticulier(particulier.getId());
		particulier.setNom("nom2");
		particulierDao.modifierParticulier(particulier);
		particulier = particulierDao.getParticulier(particulier.getId());
		Assert.assertNotNull(particulier);
		Assert.assertEquals("nom2",particulier.getNom());
		particulierDao.supprimerParticulier(particulier.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testNomUtilisateurExiste(){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		ParticulierDAO particulierDao = (ParticulierDAO) context.getBean("particulierDao");
		Particulier particulier = (Particulier) context.getBean("particulier");
		particulier.setNom("nom");
		particulier.setEmail("email");
		particulier.setMotDePasse("motDePasse");
		particulier.setNomUtilisateur("nomUtilisateur");
		particulier.setPrenom("prenom");
		particulierDao.ajouterParticulier(particulier);
		Assert.assertEquals("nomUtil existe: ",true,particulierDao.nomUtilisateurExiste("nomUtilisateur"));
		Assert.assertEquals("nomUtil n'existe pas: ",false,particulierDao.nomUtilisateurExiste("nomUtilisateur2"));
		particulierDao.supprimerParticulier(particulier.getId());
		((ConfigurableApplicationContext)context).close();
	}
}
