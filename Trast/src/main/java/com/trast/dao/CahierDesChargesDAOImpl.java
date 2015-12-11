package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.CahierDesCharges;

public class CahierDesChargesDAOImpl implements CahierDesChargesDAO {
	private SessionFactory sessionFactory;
	
	public CahierDesChargesDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<CahierDesCharges> getCahiersDesCharges() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CahierDesCharges> listeCahiersDesCharges = session.createQuery("FROM CahierDesCharges").list();
		return listeCahiersDesCharges;
	}

	@Override
	@Transactional
	public CahierDesCharges getCahierDesChargesParId(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		CahierDesCharges cahierDesCharges = (CahierDesCharges) session.get(CahierDesCharges.class, id);
		
		return cahierDesCharges;
	}

	@Override
	@Transactional
	public void ajouterCahierDesCharges(CahierDesCharges cahierDesCharges) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		session.save(cahierDesCharges);

	}

	@Override
	@Transactional
	public void modifierCahierDesCharges(CahierDesCharges cahierDesCharges) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
				
		session.update(cahierDesCharges);
		
	}

	@Override
	@Transactional
	public void supprimerCahierDesCharges(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		CahierDesCharges cahierDesCharges = getCahierDesChargesParId(id);
		
		session.delete(cahierDesCharges);
	}

}
