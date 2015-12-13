package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trast.model.Entreprise;
import com.trast.model.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	private SessionFactory sessionFactory;
	
	public UtilisateurDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Utilisateur> getUtilisateurs() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Utilisateur> listeUtilisateurs = session.createQuery("FROM Utilisateur").list();
		return listeUtilisateurs;
	}

	@Override
	@Transactional
	public Utilisateur getUtilisateurParId(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Utilisateur utilisateur = (Utilisateur) session.get(Utilisateur.class, id);
		
		return utilisateur;
	}

	@Override
	@Transactional
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		session.save(utilisateur);
	}

	@Override
	@Transactional
	public void modifierUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();		
		session.update(utilisateur);
	}

	@Override
	@Transactional
	public void supprimerUtilisateur(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Utilisateur utilisateur = getUtilisateurParId(id);
		
		session.delete(utilisateur);
	}

	@Override
	@Transactional
	public Utilisateur getByEmailAndMotDePasse(String email, String motDePasse) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Utilisateur U WHERE U.email =:email and U.motDePasse =:mdp";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("mdp", motDePasse);
		if(query.list()!=null) return (Utilisateur) query.list().get(0);
		else return null;
	}

	@Override
	@Transactional
	public boolean emailExiste(String email) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Utilisateur> utilisateurs =session.createQuery("FROM Utilisateur u WHERE u.email = :email")
				.setString("email", email).list();
		if(utilisateurs.size()>0) return true;
		return false;
	}

	@Override
	@Transactional
	public Utilisateur getByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Utilisateur> utilisateurs =session.createQuery("FROM Utilisateur u WHERE u.email = :email")
				.setString("email", email).list();
		if(utilisateurs.size()>0) return utilisateurs.get(0);
		return null;
	}

}
