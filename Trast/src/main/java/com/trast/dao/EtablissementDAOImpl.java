package com.trast.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Etablissement;

public class EtablissementDAOImpl implements EtablissementDAO {
	private SessionFactory sessionFactory;
	
	public EtablissementDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Etablissement> getEtablissements() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Etablissement> listeEtablissements = session.createQuery("FROM Etablissements").list();
		return listeEtablissements;
	}

	@Override
	@Transactional
	public Etablissement getEtablissementParId(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Etablissement etablissement = (Etablissement) session.get(Etablissement.class, id);
		
		return etablissement;
	}

	@Override
	@Transactional
	public void ajouterEtablissement(Etablissement etablissement) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		session.save(etablissement);
	}

	@Override
	@Transactional
	public void modifierEtablissement(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Etablissement etablissement = getEtablissementParId(id);
		
		session.update(etablissement);
	}

	@Override
	@Transactional
	public void supprimerEtablissement(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Etablissement etablissement = getEtablissementParId(id);
		
		session.delete(etablissement);
	}

}
