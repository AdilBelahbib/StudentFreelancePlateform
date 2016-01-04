package com.trast.dao;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Badge;


public class TestBadgeDAOImpl {

	@Test
	public void testGetBadges() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Badge badge = (Badge) context.getBean("badge");
		BadgeDAO badgeDao = (BadgeDAO) context.getBean("badgeDao");
		
		badge.setIntitule("badge1");
		badgeDao.ajouterBadge(badge);
		List<Badge> listeBadges = badgeDao.getBadges();
		Assert.assertNotNull(listeBadges); 
		
		badgeDao.supprimerBadge(badge);
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testGetBadgeById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Badge badge = (Badge) context.getBean("badge");
		BadgeDAO badgeDao = (BadgeDAO) context.getBean("badgeDao");
		
		badge.setIntitule("badge1");
		badgeDao.ajouterBadge(badge);
		badgeDao.getBadgeById(badge.getId());
		Assert.assertNotNull(badge);
		badgeDao.supprimerBadge(badge);
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testAjouterBadge() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Badge badge = (Badge) context.getBean("badge");
		BadgeDAO badgeDao = (BadgeDAO) context.getBean("badgeDao");
		
		badge.setIntitule("badge1");
		badgeDao.ajouterBadge(badge);
		badgeDao.getBadgeById(badge.getId());
		Assert.assertNotNull(badge);
		badgeDao.supprimerBadge(badge);
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testModifierBadge() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Badge badge = (Badge) context.getBean("badge");
		BadgeDAO badgeDao = (BadgeDAO) context.getBean("badgeDao");
		
		badge.setIntitule("badge1");
		badgeDao.ajouterBadge(badge);
		
		badge.setIntitule("badgeModif");
		badgeDao.getBadgeById(badge.getId());
		Assert.assertNotNull(badge);
		badgeDao.supprimerBadge(badge);
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testSupprimerBadge() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Badge badge = (Badge) context.getBean("badge");
		BadgeDAO badgeDao = (BadgeDAO) context.getBean("badgeDao");
		
		badge.setIntitule("badge1");
		badgeDao.ajouterBadge(badge);
				
		badgeDao.supprimerBadge(badge);
		badge = badgeDao.getBadgeById(badge.getId());
		
		Assert.assertNull(badge);
		((ConfigurableApplicationContext)context).close();
	}

}
