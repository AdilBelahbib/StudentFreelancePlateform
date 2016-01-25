package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Entreprise;
import com.trast.model.Entretien;
import com.trast.model.Etudiant;

public class EntretienDAOImpl implements EntretienDAO {
private SessionFactory sessionFactory;
	
	public EntretienDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Entretien getEntretien(Long id) {
		Session session = sessionFactory.getCurrentSession();	
		return(Entretien) session.get(Entretien.class,id);
	}

	@Override
	@Transactional
	public List<Entretien> getEntretiens() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Entretien> entretiens = session.createQuery("FROM Entretien").list();
		return entretiens;
	}

	@Override
	@Transactional
	public void ajouterEntretien(Entretien entretien) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entretien);
		
	}

	@Override
	@Transactional
	public void supprimerEntretien(Entretien entretien) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entretien);
		
	}

	@Override
	@Transactional
	public void modifierEntretien(Entretien entretien) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entretien);
		
	}
	
	

}
