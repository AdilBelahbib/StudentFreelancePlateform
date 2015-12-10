package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Formation;

public class FormationDAOImpl implements FormationDAO {

	private SessionFactory sessionFactory;
	
	public FormationDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Formation> getFormations() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Formation> etList = session.createQuery("FROM Formation").list();
		return etList;
	}

	@Override
	@Transactional
	public Formation getFormation(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(Formation) session.get(Formation.class,id);
	}

	@Override
	@Transactional
	public void ajouterFormation(Formation formation) {
		Session session = sessionFactory.getCurrentSession();
		session.save(formation);
		
	}

	@Override
	@Transactional
	public void supprimerFormation(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Formation formation = (Formation) session.get(Formation.class,id);
		session.delete(formation);
		
	}

	@Override
	@Transactional
	public void modifierFormation(Formation formation) {
		Session session = sessionFactory.getCurrentSession();
		session.update(formation);
		
	}
	
}
