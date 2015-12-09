package com.trast.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Entreprise;

public class EntrepriseDAOImpl implements EntrepriseDAO {
	private SessionFactory sessionFactory;
	
	public EntrepriseDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Entreprise> getEntreprises(){
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Entreprise> listeEntreprises = session.createQuery("FROM Entreprise").list();
		return listeEntreprises;
	}
	
	@Override
	@Transactional
	public Entreprise getEntrepriseParId(Long id){
		Session session = sessionFactory.getCurrentSession();
		
		Entreprise entreprise = (Entreprise) session.get(Entreprise.class, id);
		
		return entreprise;
	}
	
	@Override
	@Transactional
	public void ajouterEntreprise(Entreprise entreprise){
		Session session = sessionFactory.getCurrentSession();
		
		session.save(entreprise);		
	}
	
	@Override
	@Transactional
	public void modifierEntreprise(Long id){
		Session session = sessionFactory.getCurrentSession();
		
		Entreprise entreprise = getEntrepriseParId(id);
		
		session.update(entreprise);
	}
	
	@Override
	@Transactional
	public void supprimerEntreprise(Long id){
		Session session = sessionFactory.getCurrentSession();
		
		Entreprise entreprise = getEntrepriseParId(id);
		
		session.delete(entreprise);
	}
}
