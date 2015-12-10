package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.IntituleFormation;

public class IntituleFormationDAOImpl implements IntituleFormationDAO {
	private SessionFactory sessionFactory;
	
	public IntituleFormationDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<IntituleFormation> getIntituleFormations() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<IntituleFormation> listeIntituleFormations = session.createQuery("FROM IntituleFormation").list();
		return listeIntituleFormations;
	}

	@Override
	@Transactional
	public IntituleFormation getIntituleFormationParId(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		IntituleFormation intituleFormation = (IntituleFormation) session.get(IntituleFormation.class, id);
		
		return intituleFormation;
	}

	@Override
	@Transactional
	public void ajouterIntituleFormation(IntituleFormation intituleFormation) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		session.save(intituleFormation);
	}

	@Override
	@Transactional
	public void modifierIntituleFormation(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		IntituleFormation intituleFormation = getIntituleFormationParId(id);
		
		session.update(intituleFormation);
	}

	@Override
	@Transactional
	public void supprimerIntituleFormation(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		IntituleFormation intituleFormation = getIntituleFormationParId(id);
		
		session.delete(intituleFormation);
	}
	
}
