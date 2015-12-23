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

import com.trast.model.Formation;

public class TestFormationDAOImpl {

	@Test
	public void testGetFormations() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
		Formation formation = (Formation) context.getBean("formation");
		
		formation.setEtablissement("nomEtablissement");
		formation.setIntituleFormation("intitule");

		formationDao.ajouterFormation(formation);
		
		List<Formation> formations = formationDao.getFormations();
		Assert.assertNotNull(formations);
		formationDao.supprimerFormation(formation.getId());

		((ConfigurableApplicationContext)context).close();	
	}

	@Test
	public void testGetFormation() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
		Formation formation = (Formation) context.getBean("formation");
		
		formation.setEtablissement("nomEtablissement");
		formation.setIntituleFormation("intitule");

		formationDao.ajouterFormation(formation);
		
		formation = formationDao.getFormation(formation.getId());
		Assert.assertNotNull(formation);
		formationDao.supprimerFormation(formation.getId());

		((ConfigurableApplicationContext)context).close();	
	}

	@Test
	public void testAjouterFormation() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
		Formation formation = (Formation) context.getBean("formation");

		formation.setEtablissement("nomEtablissement");
		formation.setIntituleFormation("intitule");

		formationDao.ajouterFormation(formation);
		
		formation = formationDao.getFormation(formation.getId());
		Assert.assertNotNull(formation);
		formationDao.supprimerFormation(formation.getId());

		((ConfigurableApplicationContext)context).close();	
	}

	@Test
	public void testSupprimerFormation() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
		Formation formation = (Formation) context.getBean("formation");

		formation.setEtablissement("nomEtablissement");
		formation.setIntituleFormation("intitule");
		
		formationDao.ajouterFormation(formation);
		formationDao.supprimerFormation(formation.getId());
		formation = formationDao.getFormation(formation.getId());
		Assert.assertNull(formation);

		((ConfigurableApplicationContext)context).close();	
	}

	@Test
	public void testModifierFormation() throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		FormationDAO formationDao = (FormationDAO) context.getBean("formationDao");
		Formation formation = (Formation) context.getBean("formation");

		formation.setEtablissement("nomEtablissement");
		formation.setIntituleFormation("intitule");
		formationDao.ajouterFormation(formation);
		
		formation = formationDao.getFormation(formation.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date1 = sdf.parse("2009-12-31");
		formation.setDateDebut(date1);
		formationDao.modifierFormation(formation);
		formation = formationDao.getFormation(formation.getId());
		Assert.assertEquals(0, formation.getDateDebut().compareTo(date1));
		formationDao.supprimerFormation(formation.getId());

		((ConfigurableApplicationContext)context).close();
	}

}
