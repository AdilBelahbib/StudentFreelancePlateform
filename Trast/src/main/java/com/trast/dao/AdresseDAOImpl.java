package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Adresse;

public class AdresseDAOImpl implements AdresseDAO {
	private SessionFactory sessionFactory;
	
	public AdresseDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Adresse> getAdresses(){
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Adresse> listeAdresses = session.createQuery("FROM Adresse").list();
		return listeAdresses;
	}
	
	@Override
	@Transactional
	public Adresse getAdresseParId(Long id){
		Session session = sessionFactory.getCurrentSession();
		
		Adresse adresse = (Adresse) session.get(Adresse.class, id);
		
		return adresse;
	}
	
	@Override
	@Transactional
	public void ajouterAdresse(Adresse adresse){
		Session session = sessionFactory.getCurrentSession();
		
		session.save(adresse);		
	}
	
	@Override
	@Transactional
	public void modifierAdresse(Long id){
		Session session = sessionFactory.getCurrentSession();
		
		Adresse adresse = getAdresseParId(id);
		
		session.update(adresse);
	}
	
	@Override
	@Transactional
	public void supprimerAdresse(Long id){
		Session session = sessionFactory.getCurrentSession();
		
		Adresse adresse = getAdresseParId(id);
		
		session.delete(adresse);
	}

}
