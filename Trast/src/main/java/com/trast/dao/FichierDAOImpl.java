package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Fichier;

public class FichierDAOImpl implements FichierDAO {
	private SessionFactory sessionFactory;
	
	public FichierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Fichier> getFichiers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Fichier> listeFichiers = session.createQuery("FROM Fichier").list();
		return listeFichiers;
	}

	@Override
	@Transactional
	public Fichier getFichierParId(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Fichier fichier = (Fichier) session.get(Fichier.class, id);
		
		return fichier;
	}

	@Override
	@Transactional
	public void ajouterFichier(Fichier fichier) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		session.save(fichier);
	}

	@Override
	@Transactional
	public void modifierFichier(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Fichier fichier = getFichierParId(id);
		
		session.update(fichier);
	}

	@Override
	@Transactional
	public void supprimerFichier(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Fichier fichier = getFichierParId(id);
		
		session.delete(fichier);
	}

}
