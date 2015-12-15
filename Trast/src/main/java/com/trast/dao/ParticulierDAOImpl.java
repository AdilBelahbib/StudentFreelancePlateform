package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Particulier;

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

	@Override
	@Transactional
	public boolean nomUtilisateurExiste(String nomUtilisateur) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Particulier> particuliers =session.createQuery("FROM Particulier p WHERE p.nomUtilisateur = :nomUtilisateur")
				.setString("nomUtilisateur", nomUtilisateur).list();
		if(particuliers.size()>0) return true;
		return false;
	}
	
}
