package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.EvenementBadge;

public class EvenementBadgeDAOImpl implements EvenementBadgeDAO {
	private SessionFactory sessionFactory;
	
	public EvenementBadgeDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public EvenementBadge getEvenementBadge(Long id) {
		Session session = sessionFactory.getCurrentSession();	
		return(EvenementBadge) session.get(EvenementBadge.class,id);
	}

	@Override
	@Transactional
	public List<EvenementBadge> getEvenementBadges() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<EvenementBadge> evenementBadges = session.createQuery("FROM EvenementBadge").list();
		return evenementBadges;
	}

	@Override
	@Transactional
	public void ajouterEvenementBadge(EvenementBadge evenementBadge) {
		Session session = sessionFactory.getCurrentSession();
		session.save(evenementBadge);
		
	}

	@Override
	@Transactional
	public void supprimerEvenementBadge(EvenementBadge evenementBadge) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(evenementBadge);
		
	}

	@Override
	@Transactional
	public void modifierEvenementBadge(EvenementBadge evenementBadge) {
		Session session = sessionFactory.getCurrentSession();
		session.update(evenementBadge);
		
	}

}
