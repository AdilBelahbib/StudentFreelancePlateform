package com.trast.dao;

import java.util.List;
import com.trast.model.Particulier;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ParticulierDAOImpl implements ParticulierDAO{

	private SessionFactory sessionFactory;
	
	public ParticulierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Particulier> getParticuliers() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Particulier> etList = session.createQuery("FROM Particulier").list();
		return etList;
	}

	@Override
	@Transactional
	public Particulier getParticulier(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(Particulier) session.get(Particulier.class,id);
	}

	@Override
	@Transactional
	public void ajouterParticulier(Particulier particulier) {
		Session session = sessionFactory.getCurrentSession();
		session.save(particulier);
		
	}

	@Override
	@Transactional
	public void supprimerParticulier(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Particulier particulier = (Particulier) session.get(Particulier.class,id);
		session.delete(particulier);
		
		
	}

	@Override
	@Transactional
	public void modifierParticulier(Particulier particulier) {
		Session session = sessionFactory.getCurrentSession();
		session.update(particulier);
		
	}
	

}
