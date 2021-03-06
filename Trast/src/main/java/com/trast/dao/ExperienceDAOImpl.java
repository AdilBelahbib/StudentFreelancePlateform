package com.trast.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Experience;

public class ExperienceDAOImpl implements ExperienceDAO {
	private SessionFactory sessionFactory;
	
	public ExperienceDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Experience> getExperiences() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Experience> etList = session.createQuery("FROM Experience").list();
		return etList;
	}

	@Override
	@Transactional
	public Experience getExperience(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(Experience) session.get(Experience.class,id);
	}

	@Override
	@Transactional
	public void ajouterExperience(Experience experience) {
		Session session = sessionFactory.getCurrentSession();
		session.save(experience);
		
	}

	@Override
	@Transactional
	public void supprimerExperience(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Experience experience = (Experience) session.get(Experience.class,id);
		session.delete(experience);
		
	}

	@Override
	@Transactional
	public void modifierExperience(Experience experience) {
		Session session = sessionFactory.getCurrentSession();
		session.update(experience);
		
	}

}
