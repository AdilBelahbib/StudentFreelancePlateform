package com.trast.dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.trast.model.Etudiant;
public class EtudiantDAOImpl implements EtudiantDAO {

	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Etudiant> getEtudiants() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Etudiant> etList = session.createQuery("FROM Etudiant").list();
		return etList;
		}

	@Override
	@Transactional
	public void ajouterEtudiant(Etudiant etudiant) {
		Session session = sessionFactory.getCurrentSession();
		session.save(etudiant);

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
