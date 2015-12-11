package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.ContreProposition;

public class ContrePropositionDAOImpl implements ContrePropositionDAO {
	private SessionFactory sessionFactory;
	
	public ContrePropositionDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<ContreProposition> getContrePropositions() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ContreProposition> listeContrePropositions = session.createQuery("FROM ContreProposition").list();
		return listeContrePropositions;
	}

	@Override
	@Transactional
	public ContreProposition getContrePropositionParId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		
		ContreProposition contreProposition = (ContreProposition) session.get(ContreProposition.class, id);
		
		return contreProposition;
	}

	@Override
	@Transactional
	public void ajouterContreProposition(ContreProposition contreProposition) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		session.save(contreProposition);
	}

	@Override
	@Transactional
	public void modifierContreProposition(ContreProposition contreProposition) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
				
		session.update(contreProposition);
	}

	@Override
	@Transactional
	public void supprimerContreProposition(Long id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		ContreProposition contreProposition = getContrePropositionParId(id);
		
		session.delete(contreProposition);

	}

}
