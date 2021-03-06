package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.AppelOffre;
import com.trast.model.EtatAppelOffre;

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
	
	@Override
	@Transactional
	public List<AppelOffre> getAppelOffresByStatus(EtatAppelOffre statut) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<AppelOffre> listeAppelOffres = session
				.createQuery("FROM AppelOffre apOf WHERE apOf.statut = :statut")
				.setString("statut", statut.name()).list();
		return listeAppelOffres;
	}
	

}
