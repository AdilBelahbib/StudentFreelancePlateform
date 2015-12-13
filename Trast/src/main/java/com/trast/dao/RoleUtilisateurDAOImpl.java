package com.trast.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.RoleUtilisateur;

public class RoleUtilisateurDAOImpl implements RoleUtilisateurDAO {

	private SessionFactory sessionFactory;
	
	public RoleUtilisateurDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<RoleUtilisateur> getRoles() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<RoleUtilisateur> roleList = session.createQuery("FROM RoleUtilisateur").list();
		return roleList;
	}

	@Override
	public RoleUtilisateur getRole(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(RoleUtilisateur) session.get(RoleUtilisateur.class,id);
	}

	@Override
	public void ajouterRole(RoleUtilisateur role) {
		Session session = sessionFactory.getCurrentSession();
		session.save(role);

	}

	@Override
	public void supprimerRole(RoleUtilisateur role) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(role);

	}

	@Override
	public void modifierRole(RoleUtilisateur role) {
		Session session = sessionFactory.getCurrentSession();
		session.update(role);

	}

}
