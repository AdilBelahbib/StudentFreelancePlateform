package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Competence;
import org.hibernate.Query;
public class CompetenceDAOImpl implements CompetenceDAO{
	private SessionFactory sessionFactory;
	
	public CompetenceDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Competence> getCompetences() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Competence> competenceList = session.createQuery("FROM Competence").list();
		return competenceList;
	}

	@Override
	@Transactional
	public Competence getCompetence(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(Competence) session.get(Competence.class,id);
	}

	@Override
	@Transactional
	public void ajouterCompetence(Competence competence) {
		Session session = sessionFactory.getCurrentSession();
		session.save(competence);
		
	}

	@Override
	@Transactional
	public void supprimerCompetence(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Competence competence = (Competence) session.get(Competence.class,id);
		session.delete(competence);
		
	}

	@Override
	@Transactional
	public void modifierCompetence(Competence competence) {
		Session session = sessionFactory.getCurrentSession();
		session.update(competence);
		
	}
	@Override
	@Transactional
	public Competence getCompetenceByIntitule(String intitule) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Competence C WHERE C.intitule =:intitule";
		Query query = session.createQuery(hql);
		query.setParameter("intitule", intitule);
		if(query.list()!=null) return (Competence) query.list().get(0);
		else return null;
	}

	@Override
	@Transactional
	public Competence ajouterCompetenceIfNotExist(Competence competence) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Competence C WHERE C.intitule =:intitule";
		Query query = session.createQuery(hql);
		query.setParameter("intitule", competence.getIntitule());
		if(query.list().size()>0)
		{
			return (Competence) query.list().get(0);
		}
		session.save(competence);
		return competence;
	}

}
