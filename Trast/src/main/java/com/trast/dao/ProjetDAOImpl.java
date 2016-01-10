package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.AppelOffre;
import com.trast.model.Entreprise;
import com.trast.model.EtatAppelOffre;
import com.trast.model.Etudiant;
import com.trast.model.Projet;

public class ProjetDAOImpl implements ProjetDAO {
	private SessionFactory sessionFactory;
	
	public ProjetDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Projet> getProjets() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Projet> listeProjets = session.createQuery("FROM Projet").list();
		return listeProjets;
	}

	@Override
	@Transactional
	public Projet getProjetParId(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Projet projet = (Projet) session.get(Projet.class, id);
		
		return projet;
	}

	@Override
	@Transactional
	public void ajouterProjet(Projet projet) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		session.save(projet);
	}

	@Override
	@Transactional
	public void modifierProjet(Projet projet) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();		
		session.update(projet);
	}

	@Override
	@Transactional
	public void supprimerProjet(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Projet projet = getProjetParId(id);
		
		session.delete(projet);
		
	}
	
	@Override
	@Transactional
	public List<Projet> getProjetsByEtudiant(Etudiant etudiant) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Projet> listeProjets =  session
				.createQuery("FROM Projet pr WHERE pr.etudiant = :etudiant")
				.setEntity("etudiant",etudiant).list();
		return listeProjets;
	}
	
	@Override
	@Transactional
	public List<Projet> getProjetsByEntreprise(Entreprise entreprise) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Projet> listeProjets =  session
				.createQuery("FROM Projet pr WHERE pr.entreprise = :entreprise")
				.setEntity("entreprise",entreprise).list();
		return listeProjets;
	}

}
