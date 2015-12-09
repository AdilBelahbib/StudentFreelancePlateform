package com.trast.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.trast.model.AppelOffre;

public class AppelOffreDAOImpl implements AppelOffreDAO {
	private SessionFactory sessionFactory;
	
	public AppelOffreDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<AppelOffre> getAppelOffres() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<AppelOffre> appelOffreList = session.createQuery("FROM AppelOffre").list();
		return appelOffreList;
	}

	@Override
	@Transactional
	public AppelOffre getAppelOffre(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(AppelOffre) session.get(AppelOffre.class,id);
	}

	@Override
	@Transactional
	public void ajouterAppelOffre(AppelOffre appelOffre) {
		Session session = sessionFactory.getCurrentSession();
		session.save(appelOffre);
		
	}

	@Override
	@Transactional
	public void supprimerAppelOffre(Long id) {
		Session session = sessionFactory.getCurrentSession();
		AppelOffre appelOffre = (AppelOffre) session.get(AppelOffre.class,id);
		session.delete(appelOffre);
		
	}

	@Override
	@Transactional
	public void modifierAppelOffre(AppelOffre appelOffre) {
		Session session = sessionFactory.getCurrentSession();
		session.update(appelOffre);
		
	}

}
