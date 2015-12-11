package com.trast.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Etablissement;
import com.trast.model.Formation;
import com.trast.model.IntituleFormation;

public class TestFormationDAOImpl {

	@Test
	public void testGetFormations() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
		Formation formation = (Formation) context.getBean("formation");
		IntituleFormationDAO intituleDao = (IntituleFormationDAO) context.getBean("intituleFormationDao");
		IntituleFormation intitule = (IntituleFormation) context.getBean("intituleFormation");
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		
		etablissement.setNomEtablissement("nomEtablissement");
		intitule.setIntitule("intitule");
		intitule.setEtablissement(etablissement);
		formation.setIntituleFormation(intitule);
		
		etablissementDao.ajouterEtablissement(etablissement);
		intituleDao.ajouterIntituleFormation(intitule);
		formationDao.ajouterFormation(formation);
		
		List<Formation> formations = formationDao.getFormations();
		Assert.assertNotNull(formations);
		formationDao.supprimerFormation(formation.getId());
		intituleDao.supprimerIntituleFormation(intitule.getId());
		etablissementDao.supprimerEtablissement(etablissement.getId());
		((ConfigurableApplicationContext)context).close();	
	}

	@Test
	public void testGetFormation() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
		Formation formation = (Formation) context.getBean("formation");
		IntituleFormationDAO intituleDao = (IntituleFormationDAO) context.getBean("intituleFormationDao");
		IntituleFormation intitule = (IntituleFormation) context.getBean("intituleFormation");
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		
		etablissement.setNomEtablissement("nomEtablissement");
		intitule.setIntitule("intitule");
		intitule.setEtablissement(etablissement);
		formation.setIntituleFormation(intitule);
		
		etablissementDao.ajouterEtablissement(etablissement);
		intituleDao.ajouterIntituleFormation(intitule);
		formationDao.ajouterFormation(formation);
		
		formation = formationDao.getFormation(formation.getId());
		Assert.assertNotNull(formation);
		formationDao.supprimerFormation(formation.getId());
		intituleDao.supprimerIntituleFormation(intitule.getId());
		etablissementDao.supprimerEtablissement(etablissement.getId());
		((ConfigurableApplicationContext)context).close();	
	}

	@Test
	public void testAjouterFormation() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
		Formation formation = (Formation) context.getBean("formation");
		IntituleFormationDAO intituleDao = (IntituleFormationDAO) context.getBean("intituleFormationDao");
		IntituleFormation intitule = (IntituleFormation) context.getBean("intituleFormation");
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		
		etablissement.setNomEtablissement("nomEtablissement");
		intitule.setIntitule("intitule");
		intitule.setEtablissement(etablissement);
		formation.setIntituleFormation(intitule);
		
		etablissementDao.ajouterEtablissement(etablissement);
		intituleDao.ajouterIntituleFormation(intitule);
		formationDao.ajouterFormation(formation);
		
		formation = formationDao.getFormation(formation.getId());
		Assert.assertNotNull(formation);
		formationDao.supprimerFormation(formation.getId());
		intituleDao.supprimerIntituleFormation(intitule.getId());
		etablissementDao.supprimerEtablissement(etablissement.getId());
		((ConfigurableApplicationContext)context).close();	
	}

	@Test
	public void testSupprimerFormation() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
		Formation formation = (Formation) context.getBean("formation");
		IntituleFormationDAO intituleDao = (IntituleFormationDAO) context.getBean("intituleFormationDao");
		IntituleFormation intitule = (IntituleFormation) context.getBean("intituleFormation");
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		
		etablissement.setNomEtablissement("nomEtablissement");
		intitule.setIntitule("intitule");
		intitule.setEtablissement(etablissement);
		formation.setIntituleFormation(intitule);
		
		etablissementDao.ajouterEtablissement(etablissement);
		intituleDao.ajouterIntituleFormation(intitule);
		formationDao.ajouterFormation(formation);
		formationDao.supprimerFormation(formation.getId());
		formation = formationDao.getFormation(formation.getId());
		Assert.assertNull(formation);
		
		intituleDao.supprimerIntituleFormation(intitule.getId());
		etablissementDao.supprimerEtablissement(etablissement.getId());
		((ConfigurableApplicationContext)context).close();	
	}

	@Test
	public void testModifierFormation() throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
		Formation formation = (Formation) context.getBean("formation");
		IntituleFormationDAO intituleDao = (IntituleFormationDAO) context.getBean("intituleFormationDao");
		IntituleFormation intitule = (IntituleFormation) context.getBean("intituleFormation");
		EtablissementDAO etablissementDao = (EtablissementDAO) context.getBean("etablissementDao");
		Etablissement etablissement = (Etablissement) context.getBean("etablissement");
		
		etablissement.setNomEtablissement("nomEtablissement");
		intitule.setIntitule("intitule");
		intitule.setEtablissement(etablissement);
		formation.setIntituleFormation(intitule);
		
		etablissementDao.ajouterEtablissement(etablissement);
		intituleDao.ajouterIntituleFormation(intitule);
		formationDao.ajouterFormation(formation);
		
		formation = formationDao.getFormation(formation.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date1 = sdf.parse("2009-12-31");
		formation.setDateDebut(date1);
		formationDao.modifierFormation(formation);
		formation = formationDao.getFormation(formation.getId());
		Assert.assertEquals(0, formation.getDateDebut().compareTo(date1));
		formationDao.supprimerFormation(formation.getId());
		intituleDao.supprimerIntituleFormation(intitule.getId());
		etablissementDao.supprimerEtablissement(etablissement.getId());
		((ConfigurableApplicationContext)context).close();
	}

}
