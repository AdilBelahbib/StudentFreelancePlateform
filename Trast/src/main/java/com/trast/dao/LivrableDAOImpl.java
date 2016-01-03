package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Livrable;

public class LivrableDAOImpl implements LivrableDAO {

	private SessionFactory sessionFactory;

	public LivrableDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Livrable> getLivrables() {
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Livrable> livrables = session.createQuery("FROM Livrable").list();

		return livrables;
	}

	@Override
	@Transactional
	public Livrable getLivrableById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Livrable livrable = (Livrable) session.get(Livrable.class, id);

		return livrable;
	}

	@Override
	@Transactional
	public void ajouterLivrable(Livrable livrable) {
		Session session = sessionFactory.getCurrentSession();

		session.save(livrable);
	}

	@Override
	@Transactional
	public void modifierLivrable(Livrable livrable) {
		Session session = sessionFactory.getCurrentSession();

		session.update(livrable);

	}

	@Override
	@Transactional
	public void supprimerLivrable(Livrable livrable) {
		Session session = sessionFactory.getCurrentSession();

		session.delete(livrable);
	}
}
