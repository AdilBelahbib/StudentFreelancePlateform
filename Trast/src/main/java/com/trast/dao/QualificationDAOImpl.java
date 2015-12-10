package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Qualification;

public class QualificationDAOImpl implements QualificationDAO {
	private SessionFactory sessionFactory;
	
	public QualificationDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Qualification> getQualifications() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Qualification> listeQualifications = session.createQuery("FROM Qualification").list();
		return listeQualifications;
	}

	@Override
	@Transactional
	public Qualification getQualificationParId(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Qualification qualification = (Qualification) session.get(Qualification.class, id);
		
		return qualification;
	}

	@Override
	@Transactional
	public void ajouterQualification(Qualification qualification) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		session.save(qualification);
	}

	@Override
	@Transactional
	public void modifierQualification(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Qualification qualification = getQualificationParId(id);
		
		session.update(qualification);

	}

	@Override
	@Transactional
	public void supprimerQualification(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Qualification qualification = getQualificationParId(id);
		
		session.delete(qualification);
	}

}
