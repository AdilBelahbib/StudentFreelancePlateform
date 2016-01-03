package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Badge;

public class BadgeDAOImpl implements BadgeDAO {
	private SessionFactory sessionFactory;

	public BadgeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Badge> getBadges() {
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Badge> badges = session.createQuery("FROM Badge").list();

		return badges;
	}

	@Override
	@Transactional
	public Badge getBadgeById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Badge badge = (Badge) session.get(Badge.class, id);

		return badge;
	}

	@Override
	@Transactional
	public void ajouterBadge(Badge badge) {
		Session session = sessionFactory.getCurrentSession();

		session.save(badge);
	}

	@Override
	@Transactional
	public void modifierBadge(Badge badge) {
		Session session = sessionFactory.getCurrentSession();

		session.update(badge);

	}

	@Override
	@Transactional
	public void supprimerBadge(Badge badge) {
		Session session = sessionFactory.getCurrentSession();

		session.delete(badge);
	}

}
