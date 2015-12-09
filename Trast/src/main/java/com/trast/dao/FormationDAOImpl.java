package com.trast.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.trast.model.Formation;

public class FormationDAOImpl implements FormationDAO {

	private SessionFactory sessionFactory;
	
	public FormationDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Formation> getFormations() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Formation> etList = session.createQuery("FROM Formation").list();
		return etList;
	}

	@Override
	public Formation getFormation(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(Formation) session.get(Formation.class,id);
	}

	@Override
	public void ajouterFormation(Formation formation) {
		Session session = sessionFactory.getCurrentSession();
		session.save(formation);
		
	}

	@Override
	public void supprimerFormation(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Formation formation = (Formation) session.get(Formation.class,id);
		session.delete(formation);
		
	}

	@Override
	public void modifierFormation(Formation formation) {
		Session session = sessionFactory.getCurrentSession();
		session.update(formation);
		
	}

}
