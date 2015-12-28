package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Question;

public class QuestionDAOImpl implements QuestionDAO {
	private SessionFactory sessionFactory;
	
	public QuestionDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Question getQuestionParId(Long id) {
		Session session = sessionFactory.getCurrentSession();	
		return(Question) session.get(Question.class,id);
	}

	@Override
	@Transactional
	public List<Question> getQuestions() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Question> questions = session.createQuery("FROM Question").list();
		return questions;
	}

	@Override
	@Transactional
	public void ajouterQuestion(Question question) {
		Session session = sessionFactory.getCurrentSession();
		session.save(question);
		
	}

	@Override
	@Transactional
	public void supprimerQuestion(Question question) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(question);
		
	}

	@Override
	@Transactional
	public void modifierQuestion(Question question) {
		Session session = sessionFactory.getCurrentSession();
		session.update(question);
		
	}

}
