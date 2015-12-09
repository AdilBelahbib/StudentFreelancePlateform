package com.trast.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.trast.model.Remuneration;

public class RemunerationDAOImpl implements RemunerationDAO {

	private SessionFactory sessionFactory;
	
	public RemunerationDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Remuneration> getRemunerations() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Remuneration> etList = session.createQuery("FROM Remuneration").list();
		return etList;
	}

	@Override
	@Transactional
	public Remuneration getRemuneration(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Remuneration) session.get(Remuneration.class,id);
	}

	@Override
	@Transactional
	public void ajouterRemuneration(Remuneration remuneration) {
		Session session = sessionFactory.getCurrentSession();
		session.save(remuneration);
	}

	@Override
	@Transactional
	public void supprimerRemuneration(Long id) {
		Session session = sessionFactory.getCurrentSession();
		 Remuneration remuneration = (Remuneration) session.get(Remuneration.class,id);
		session.delete(remuneration);
		
	}

	@Override
	@Transactional
	public void modifierRemuneration(Remuneration remuneration) {
		Session session = sessionFactory.getCurrentSession();
		session.update(remuneration);
	}

}
