package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.RoleUtilisateur;

public class RoleUtilisateurDAOImpl implements RoleUtilisateurDAO {

	private SessionFactory sessionFactory;
	
	public RoleUtilisateurDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<RoleUtilisateur> getRoles() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<RoleUtilisateur> roleList = session.createQuery("FROM RoleUtilisateur").list();
		return roleList;
	}

	@Override
	@Transactional
	public RoleUtilisateur getRole(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(RoleUtilisateur) session.get(RoleUtilisateur.class,id);
	}
	
	@Override
	@Transactional
	public RoleUtilisateur getRoleByNom(String role) {
		Session session = sessionFactory.getCurrentSession();
		
		RoleUtilisateur roleUtilisateur = (RoleUtilisateur) session.createQuery(
				"from RoleUtilisateur roleU WHERE roleU.role = :role")
				.setString("role", role)
				.uniqueResult();
		
		return roleUtilisateur;
	}

	@Override
	@Transactional
	public void ajouterRole(RoleUtilisateur role) {
		Session session = sessionFactory.getCurrentSession();
		session.save(role);

	}

	@Override
	@Transactional
	public void supprimerRole(RoleUtilisateur role) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(role);

	}

	@Override
	@Transactional
	public void modifierRole(RoleUtilisateur role) {
		Session session = sessionFactory.getCurrentSession();
		session.update(role);

	}

}
