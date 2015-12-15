package com.trast.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Administrateur;
import com.trast.model.RoleUtilisateur;

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
	public boolean ajouterAdministrateur(Administrateur admin) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");
		ParticulierDAO particulierDao = (ParticulierDAO) context.getBean("particulierDao");
		if(utilisateurDao.emailExiste(admin.getEmail()) || particulierDao.nomUtilisateurExiste(admin.getNomUtilisateur()))
		{
			((ConfigurableApplicationContext)context).close();
			return false;
		}
		
		Session session = sessionFactory.getCurrentSession();
		
		RoleUtilisateur roleUtilisateur = (RoleUtilisateur) session.createQuery(
				"from RoleUtilisateur roleU WHERE roleU.role = 'ROLE_ADMIN'")
				.uniqueResult();
		
		admin.setRoleUtilisateur(roleUtilisateur);
		
		session.save(admin);
		
		return true;
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
