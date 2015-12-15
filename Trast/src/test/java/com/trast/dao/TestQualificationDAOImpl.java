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


import com.trast.model.Qualification;

public class TestQualificationDAOImpl {

	@Test
	public void testGetQualifications() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		QualificationDAO qualificationDao = (QualificationDAO) context.getBean("qualificationDao");
		Qualification qualification = (Qualification) context.getBean("qualification");
		qualificationDao.ajouterQualification(qualification);
		List<Qualification> qualifications = qualificationDao.getQualifications();
		Assert.assertNotNull(qualifications);
		qualificationDao.supprimerQualification(qualification.getId());
		((ConfigurableApplicationContext)context).close();		
	}

	@Test
	public void testGetQualificationParId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		QualificationDAO qualificationDao = (QualificationDAO) context.getBean("qualificationDao");
		Qualification qualification = (Qualification) context.getBean("qualification");
		qualificationDao.ajouterQualification(qualification);
		qualification = qualificationDao.getQualificationParId(qualification.getId());
		Assert.assertNotNull(qualification);
		qualificationDao.supprimerQualification(qualification.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterQualification() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		QualificationDAO qualificationDao = (QualificationDAO) context.getBean("qualificationDao");
		Qualification qualification = (Qualification) context.getBean("qualification");
		qualificationDao.ajouterQualification(qualification);
		qualification = qualificationDao.getQualificationParId(qualification.getId());
		Assert.assertNotNull(qualification);
		qualificationDao.supprimerQualification(qualification.getId());
		((ConfigurableApplicationContext)context).close();
		
	}

	@Test
	public void testModifierQualification() throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		QualificationDAO qualificationDao = (QualificationDAO) context.getBean("qualificationDao");
		Qualification qualification = (Qualification) context.getBean("qualification");
		qualificationDao.ajouterQualification(qualification);
		qualification = qualificationDao.getQualificationParId(qualification.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date1 = sdf.parse("2009-12-31");
		qualification.setDateDebut(date1);
		qualificationDao.modifierQualification(qualification);
		Assert.assertEquals(0, qualification.getDateDebut().compareTo(date1));
		qualificationDao.supprimerQualification(qualification.getId());
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerQualification() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		QualificationDAO qualificationDao = (QualificationDAO) context.getBean("qualificationDao");
		Qualification qualification = (Qualification) context.getBean("qualification");
		qualificationDao.ajouterQualification(qualification);
		qualification = qualificationDao.getQualificationParId(qualification.getId());
		qualificationDao.supprimerQualification(qualification.getId());
		qualification = qualificationDao.getQualificationParId(qualification.getId());
		Assert.assertNull(qualification);
		((ConfigurableApplicationContext)context).close();
	}

}
