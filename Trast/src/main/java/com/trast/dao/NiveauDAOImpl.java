package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Niveau;

public class NiveauDAOImpl implements NiveauDAO {

private SessionFactory sessionFactory;
	
	public NiveauDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Niveau> getNiveaux() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Niveau> niveauList = session.createQuery("FROM Niveau").list();
		return niveauList;
	}

	@Override
	@Transactional
	public Niveau getNiveau(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(Niveau) session.get(Niveau.class,id);
	}

	@Override
	@Transactional
	public void ajouterNiveau(Niveau niveau) {
		Session session = sessionFactory.getCurrentSession();
		session.save(niveau);

	}

	@Override
	@Transactional
	public void supprimerNiveau(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Niveau niveau = (Niveau) session.get(Niveau.class,id);
		session.delete(niveau);

	}

	@Override
	@Transactional
	public void modifierNiveau(Niveau niveau) {
		Session session = sessionFactory.getCurrentSession();
		session.update(niveau);

	}

}
