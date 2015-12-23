package com.trast.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.model.Etudiant;
import com.trast.model.RoleUtilisateur;
public class EtudiantDAOImpl implements EtudiantDAO {

	private SessionFactory sessionFactory;
	
	public EtudiantDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Etudiant> getEtudiants() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Etudiant> etList = session.createQuery("FROM Etudiant").list();
		return etList;
		}

	@SuppressWarnings("resource")
	@Override
	@Transactional
	public boolean ajouterEtudiant(Etudiant etudiant) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");		
		UtilisateurDAO utilisateurDao = (UtilisateurDAO) context.getBean("utilisateurDao");

		if(utilisateurDao.emailExiste(etudiant.getEmail()))
		{
			((ConfigurableApplicationContext)context).close();
			return false;
		}
		
		Session session = sessionFactory.getCurrentSession();
		
		RoleUtilisateur roleUtilisateur = (RoleUtilisateur) session.createQuery(
				"from RoleUtilisateur roleU WHERE roleU.role = 'ROLE_ETUDIANT'")
				.uniqueResult();
		
		etudiant.setRoleUtilisateur(roleUtilisateur);
		
		session.save(etudiant);
		
		return true;
	}

	@Override
	@Transactional
	public Etudiant getEtudiant(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return(Etudiant) session.get(Etudiant.class,id);
	}

	@Override
	@Transactional
	public void supprimerEtudiant(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Etudiant etudiant = (Etudiant) session.get(Etudiant.class,id);
		session.delete(etudiant);
	}

	@Override
	@Transactional
	public void modifierEtudiant(Etudiant etudiant) {
		Session session = sessionFactory.getCurrentSession();
		session.update(etudiant);
		
	}

}
