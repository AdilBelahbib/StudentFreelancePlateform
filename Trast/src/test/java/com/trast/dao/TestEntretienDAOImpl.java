package com.trast.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.AppelOffre;
import com.trast.model.ContreProposition;
import com.trast.model.Entreprise;
import com.trast.model.Entretien;
import com.trast.model.Etudiant;

public class TestEntretienDAOImpl {

	@Test
	public void testGetEntretiens() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		EntretienDAO entretienDAO = (EntretienDAO) context.getBean("entretienDao");
		Entretien entretien = (Entretien) context.getBean("entretien");
		
		/**Création d'une contre-proposition**/
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant7@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise7@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
		
		appelOffre.setEntreprise(entreprise);
		appelOffreDao.ajouterAppelOffre(appelOffre);
		
		double enchere = 1.2;
		
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);
		contrePropositionDao.ajouterContreProposition(contreProposition);
		/**FIN: Création d'une contre-proposition**/
		
		entretien.setContreProposition(contreProposition);
		entretien.setDateEntretien(new Date());
		entretien.setTermine(false);
		entretien.getNotes().add("Note 1");
		entretien.getNotes().add("Note2");
		
		entretienDAO.ajouterEntretien(entretien);
				
		List<Entretien> entretiens = entretienDAO.getEntretiens();
		
		Assert.assertNotNull("Liste des entretiens est nulle", entretiens);
		
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		//entretienDAO.supprimerEntretien(entretien);
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetEntretien() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		EntretienDAO entretienDAO = (EntretienDAO) context.getBean("entretienDao");
		Entretien entretien = (Entretien) context.getBean("entretien");
		
		/**Création d'une contre-proposition**/
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant7@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise7@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
		
		appelOffre.setEntreprise(entreprise);
		appelOffreDao.ajouterAppelOffre(appelOffre);
		
		double enchere = 1.2;
		
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);
		contrePropositionDao.ajouterContreProposition(contreProposition);
		/**FIN: Création d'une contre-proposition**/
		
		entretien.setContreProposition(contreProposition);
		entretien.setDateEntretien(new Date());
		entretien.setTermine(false);
		entretien.getNotes().add("Note 1");
		entretien.getNotes().add("Note2");
		
		entretienDAO.ajouterEntretien(entretien);
				
		entretien = entretienDAO.getEntretien(entretien.getId());
		
		Assert.assertNotNull("Entretien introuvable", entretien);
		Assert.assertEquals("Nombre de notes est incorrecte", 2, entretien.getNotes().size());
		
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		//entretienDAO.supprimerEntretien(entretien);
		((ConfigurableApplicationContext)context).close();

	}

	@Test
	public void testAjouterEntretien() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		EntretienDAO entretienDAO = (EntretienDAO) context.getBean("entretienDao");
		Entretien entretien = (Entretien) context.getBean("entretien");
		
		/**Création d'une contre-proposition**/
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant7@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise7@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
		
		appelOffre.setEntreprise(entreprise);
		appelOffreDao.ajouterAppelOffre(appelOffre);
		
		double enchere = 1.2;
		
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);
		contrePropositionDao.ajouterContreProposition(contreProposition);
		/**FIN: Création d'une contre-proposition**/
		
		entretien.setContreProposition(contreProposition);
		entretien.setDateEntretien(new Date());
		entretien.setTermine(false);
		entretien.getNotes().add("Note 1");
		entretien.getNotes().add("Note2");
		
		entretienDAO.ajouterEntretien(entretien);
				
		entretien = entretienDAO.getEntretien(entretien.getId());
		
		Assert.assertNotNull("Entretien non inséré", entretien);
		
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		//entretienDAO.supprimerEntretien(entretien);
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerEntretien() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		EntretienDAO entretienDAO = (EntretienDAO) context.getBean("entretienDao");
		Entretien entretien = (Entretien) context.getBean("entretien");
		
		/**Création d'une contre-proposition**/
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant7@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise7@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
		
		appelOffre.setEntreprise(entreprise);
		appelOffreDao.ajouterAppelOffre(appelOffre);
		
		double enchere = 1.2;
		
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);
		contrePropositionDao.ajouterContreProposition(contreProposition);
		/**FIN: Création d'une contre-proposition**/
		
		entretien.setContreProposition(contreProposition);
		entretien.setDateEntretien(new Date());
		entretien.setTermine(false);
		entretien.getNotes().add("Note 1");
		entretien.getNotes().add("Note2");
		
		entretienDAO.ajouterEntretien(entretien);
		
		entretienDAO.supprimerEntretien(entretien);
		
		entretien = entretienDAO.getEntretien(entretien.getId());
		
		Assert.assertNull("Entretien non supprimé", entretien);
		
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierEntretien() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		EntretienDAO entretienDAO = (EntretienDAO) context.getBean("entretienDao");
		Entretien entretien = (Entretien) context.getBean("entretien");
		
		/**Création d'une contre-proposition**/
		ContrePropositionDAO contrePropositionDao = (ContrePropositionDAO) context.getBean("contrePropositionDao");
		ContreProposition contreProposition = (ContreProposition) context.getBean("contreProposition");
			
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		etudiant.setEmail("etudiant7@gmail.com");
		etudiantDao.ajouterEtudiant(etudiant);
		
		AppelOffreDAO appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");
		AppelOffre appelOffre = (AppelOffre) context.getBean("appelOffre");
		
		EntrepriseDAO entrepriseDao = (EntrepriseDAO) context.getBean("entrepriseDao");
		Entreprise entreprise = (Entreprise)context.getBean("entreprise");
		entreprise.setEmail("entreprise7@gmail.com");
		entrepriseDao.ajouterEntreprise(entreprise);
		
		appelOffre.setEntreprise(entreprise);
		appelOffreDao.ajouterAppelOffre(appelOffre);
		
		double enchere = 1.2;
		
		contreProposition.setEnchere(enchere);
		contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);
		contrePropositionDao.ajouterContreProposition(contreProposition);
		/**FIN: Création d'une contre-proposition**/
		
		entretien.setContreProposition(contreProposition);
		entretien.setDateEntretien(new Date());
		entretien.setTermine(false);
		entretien.getNotes().add("Note 1");
		entretien.getNotes().add("Note 2");
		
		entretienDAO.ajouterEntretien(entretien);
		
		entretien.getNotes().add("Note 3");
		entretien.setTermine(true);
		
		entretienDAO.modifierEntretien(entretien);
		entretien = entretienDAO.getEntretien(entretien.getId());
		
		Assert.assertEquals("Entretien.termine non modifié", true, entretien.isTermine());
		Assert.assertEquals("Nombre de notes non modifié (ajout)", 3, entretien.getNotes().size());
		
		entretien.getNotes().remove("Note 2");
		entretienDAO.modifierEntretien(entretien);
		entretien = entretienDAO.getEntretien(entretien.getId());
		Assert.assertEquals("Nombre de notes non modifié (suppression)", 2, entretien.getNotes().size());
		
		etudiantDao.supprimerEtudiant(etudiant.getId());
		appelOffreDao.supprimerAppelOffre(appelOffre.getId());
		entrepriseDao.supprimerEntreprise(entreprise.getId());
		//entretienDAO.supprimerEntretien(entretien);
		((ConfigurableApplicationContext)context).close();
	}

}
