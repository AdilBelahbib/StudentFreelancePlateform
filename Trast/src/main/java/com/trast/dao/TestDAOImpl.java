package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Test;

public class TestDAOImpl implements TestDAO{
	private SessionFactory sessionFactory;
	
	public TestDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Test> getTests() {
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Test> listeTests = session.createQuery("FROM Test").list();
		
		return listeTests;
	}

	@Override
	@Transactional
	public Test getTestParId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		
		return(Test) session.get(Test.class,id);
	}

	@Override
	@Transactional
	public void ajouterTest(Test test) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(test);
	}

	@Override
	@Transactional
	public void supprimerTest(Long id) {
		Session session = sessionFactory.getCurrentSession();
		
		Test test = (Test) session.get(Test.class,id);
		
		session.delete(test);		
	}

	@Override
	@Transactional
	public List<Test> getTestsAdmin() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Test> listeTests = session.createQuery("FROM Test T WHERE T.entreprise is null")
				.list();
		return listeTests;
	}

	@Override
	@Transactional
	public List<Test> getTestsEntreprises() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Test> listeTests = session.createQuery("FROM Test T WHERE T.entreprise is not null")
				.list();
		return listeTests;
	}

}
