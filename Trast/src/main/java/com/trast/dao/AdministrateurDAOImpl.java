package com.trast.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.trast.model.Administrateur;

public class AdministrateurDAOImpl implements AdministrateurDAO {
	private SessionFactory sessionFactory;
	
	public AdministrateurDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Administrateur> getAdministrateurs() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Administrateur> adminList = session.createQuery("FROM Administrateur").list();
		return adminList;
	}

	@Override
	@Transactional
	public Administrateur getAdministrateur(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(Administrateur) session.get(Administrateur.class,id);
	}

	@Override
	@Transactional
	public void ajouterAdministrateur(Administrateur admin) {
		Session session = sessionFactory.getCurrentSession();
		session.save(admin);

	}

	@Override
	@Transactional
	public void supprimerAdministrateur(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Administrateur admin = (Administrateur) session.get(Administrateur.class,id);
		session.delete(admin);

	}

	@Override
	@Transactional
	public void modifierAdministrateur(Administrateur admin) {
		Session session = sessionFactory.getCurrentSession();
		session.update(admin);

	}

}
