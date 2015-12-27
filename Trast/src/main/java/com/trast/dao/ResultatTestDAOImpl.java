package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.ResultatTest;

public class ResultatTestDAOImpl implements ResultatTestDAO{
	private SessionFactory sessionFactory;
	
	public ResultatTestDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<ResultatTest> getResultatsTest() {
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<ResultatTest> listeResultats = session.createQuery("FROM ResultatTest").list();
		
		return listeResultats;
	}

	@Override
	@Transactional
	public ResultatTest getResultatTestParId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		
		return(ResultatTest) session.get(ResultatTest.class,id);
	}

	@Override
	@Transactional
	public void ajouterResultatTest(ResultatTest resultat) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(resultat);		
	}
	
	@Override
	@Transactional
	public void modifierResultatTest(ResultatTest resultatTest) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(resultatTest);
		
	}
	
	@Override
	@Transactional
	public void supprimerResultatTest(Long id) {
		Session session = sessionFactory.getCurrentSession();
		
		ResultatTest resultatTest = (ResultatTest) session.get(ResultatTest.class,id);
		
		session.delete(resultatTest);
	}

}
