package com.trast.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Experience;

public class TestExperienceDAOImpl {

	@Test
	public void testGetExperiences() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ExperienceDAO experienceDao = (ExperienceDAO) context.getBean("experienceDao");
		Experience experience = (Experience) context.getBean("experience");
		experience.setResponsabilite("responsabilite");
		experience.setTypeExperience("typeExperience");
		experience.setStructureAccueil("structureAccueil");
		experience.setSujet("sujet");
		experience.setSalaire((double) 10000);
		experienceDao.ajouterExperience(experience);
		List<Experience> experiences = experienceDao.getExperiences();
		Assert.assertNotNull(experiences);
		experienceDao.supprimerExperience(experience.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetExperience() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ExperienceDAO experienceDao = (ExperienceDAO) context.getBean("experienceDao");
		Experience experience = (Experience) context.getBean("experience");
		experience.setResponsabilite("responsabilite");
		experience.setTypeExperience("typeExperience");
		experience.setStructureAccueil("structureAccueil");
		experience.setSujet("sujet");
		experience.setSalaire((double) 10000);
		experienceDao.ajouterExperience(experience);
		experience = experienceDao.getExperience(experience.getId());
		Assert.assertNotNull(experience);
		experienceDao.supprimerExperience(experience.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterExperience() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ExperienceDAO experienceDao = (ExperienceDAO) context.getBean("experienceDao");
		Experience experience = (Experience) context.getBean("experience");
		experience.setResponsabilite("responsabilite");
		experience.setTypeExperience("typeExperience");
		experience.setStructureAccueil("structureAccueil");
		experience.setSujet("sujet");
		experience.setSalaire((double) 10000);
		experienceDao.ajouterExperience(experience);
		experience = experienceDao.getExperience(experience.getId());
		Assert.assertNotNull(experience);
		experienceDao.supprimerExperience(experience.getId());
		((ConfigurableApplicationContext)context).close();
		
		

	}

	@Test
	public void testSupprimerExperience() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ExperienceDAO experienceDao = (ExperienceDAO) context.getBean("experienceDao");
		Experience experience = (Experience) context.getBean("experience");
		experience.setResponsabilite("responsabilite");
		experience.setTypeExperience("typeExperience");
		experience.setStructureAccueil("structureAccueil");
		experience.setSujet("sujet");
		experience.setSalaire((double) 10000);
		experienceDao.ajouterExperience(experience);
		experienceDao.supprimerExperience(experience.getId());
		experience = experienceDao.getExperience(experience.getId());
		Assert.assertNull(experience);
		
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierExperience() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ExperienceDAO experienceDao = (ExperienceDAO) context.getBean("experienceDao");
		Experience experience = (Experience) context.getBean("experience");
		experience.setResponsabilite("responsabilite");
		experience.setTypeExperience("typeExperience");
		experience.setStructureAccueil("structureAccueil");
		experience.setSujet("sujet");
		experience.setSalaire((double) 10000);
		experienceDao.ajouterExperience(experience);
		experience = experienceDao.getExperience(experience.getId());
		experience.setSujet("sujet modifie");
		experienceDao.modifierExperience(experience);
		experience = experienceDao.getExperience(experience.getId());
		Assert.assertEquals("sujet modifie",experience.getSujet());
		experienceDao.supprimerExperience(experience.getId());
		((ConfigurableApplicationContext)context).close();
	}

}
