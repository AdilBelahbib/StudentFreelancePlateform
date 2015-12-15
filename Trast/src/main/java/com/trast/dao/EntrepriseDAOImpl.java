package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Entreprise;
import com.trast.model.EtatCompte;
import com.trast.model.RoleUtilisateur;

public class EntrepriseDAOImpl implements EntrepriseDAO {
	private SessionFactory sessionFactory;

	public EntrepriseDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Entreprise> getEntreprises() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Entreprise> listeEntreprises = session.createQuery("FROM Entreprise").list();
		return listeEntreprises;
	}

	@Override
	@Transactional
	public Entreprise getEntrepriseParId(Long id) {
		Session session = sessionFactory.getCurrentSession();

		Entreprise entreprise = (Entreprise) session.get(Entreprise.class, id);

		return entreprise;
	}

	@Override
	@Transactional
	public boolean ajouterEntreprise(Entreprise entreprise) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");
		if(utilisateurDao.emailExiste(entreprise.getEmail()))
		{
			((ConfigurableApplicationContext)context).close();
			return false;
		}
		
		Session session = sessionFactory.getCurrentSession();

		RoleUtilisateur roleUtilisateur = (RoleUtilisateur) session.createQuery(
				"from RoleUtilisateur roleU WHERE roleU.role = 'ROLE_ENTREPRISE'")
				.uniqueResult();
		
		entreprise.setRoleUtilisateur(roleUtilisateur);
		session.save(entreprise);
		((ConfigurableApplicationContext)context).close();
		return true;
	}

	@Override
	@Transactional
	public void modifierEntreprise(Entreprise entreprise) {
		Session session = sessionFactory.getCurrentSession();

			session.update(entreprise);
		
	}

	@Override
	@Transactional
	public void supprimerEntreprise(Long id) {
		Session session = sessionFactory.getCurrentSession();

		Entreprise entreprise = getEntrepriseParId(id);

		session.delete(entreprise);
	}

	@Override
	@Transactional
	public List<Entreprise> getEntreprisesByEtatCompte(EtatCompte etatCompte) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Entreprise> listeEntreprises = session
				.createQuery("FROM Entreprise ent WHERE ent.etatCompte = :etatCompte")
				.setString("etatCompte", etatCompte.name()).list();
		return listeEntreprises;
	}

}
