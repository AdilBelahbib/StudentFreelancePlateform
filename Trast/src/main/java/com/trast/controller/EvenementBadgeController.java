package com.trast.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.BadgeDAO;
import com.trast.dao.EvenementBadgeDAO;
import com.trast.dao.FichierDAO;
import com.trast.model.Administrateur;
import com.trast.model.EvenementBadge;
import com.trast.model.Fichier;
import com.trast.model.SourceEvenement;
import com.trast.service.UploadFileService;

@ManagedBean(name = "evenementBadgeController", eager = true)
@SessionScoped
public class EvenementBadgeController implements Serializable {

	private static final long serialVersionUID = 1931800391036448012L;

	@ManagedProperty(value = "#{evenementBadgeDao}")
	private EvenementBadgeDAO evenementBadgeDAO;

	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	private Administrateur administrateur;

	@ManagedProperty(value = "#{evenementBadge}")
	private EvenementBadge evenementBadge;

	@ManagedProperty(value = "#{fichierDao}")
	private FichierDAO fichierDao;

	@ManagedProperty(value = "#{badgeDao}")
	private BadgeDAO badgeDao;

	private List<EvenementBadge> evenementBadges;

	public EvenementBadgeDAO getEvenementBadgeDAO() {
		return evenementBadgeDAO;
	}

	public void setEvenementBadgeDAO(EvenementBadgeDAO evenementBadgeDAO) {
		this.evenementBadgeDAO = evenementBadgeDAO;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public List<EvenementBadge> getEvenementBadges() {
		return evenementBadges;
	}

	public void setEvenementBadges(List<EvenementBadge> evenementBadges) {
		this.evenementBadges = evenementBadges;
	}

	public EvenementBadge getEvenementBadge() {
		return evenementBadge;
	}

	public void setEvenementBadge(EvenementBadge evenementBadge) {
		this.evenementBadge = evenementBadge;
	}

	public FichierDAO getFichierDao() {
		return fichierDao;
	}

	public void setFichierDao(FichierDAO fichierDao) {
		this.fichierDao = fichierDao;
	}

	public BadgeDAO getBadgeDao() {
		return badgeDao;
	}

	public void setBadgeDao(BadgeDAO badgeDao) {
		this.badgeDao = badgeDao;
	}

	public void getAllEvenementBadges() {
		evenementBadges = evenementBadgeDAO.getEvenementBadges();
	}

	public SourceEvenement[] getSourceEvenementValues() {
		return SourceEvenement.values();
	}

	public String ajouterEvenementBadge() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		Fichier fichier = (Fichier) context.getBean("fichier");
		fichier.setChemin("/badges");
		fichier.setTitre(evenementBadge.getBadge().getIntitule() + administrateur.getId());
		
		UploadFileService.uploadFichier(fichier);
		
		fichierDao.ajouterFichier(fichier);

		evenementBadge.getBadge().setIcone(fichier);

		badgeDao.ajouterBadge(evenementBadge.getBadge());
		evenementBadgeDAO.ajouterEvenementBadge(evenementBadge);

		evenementBadge = (EvenementBadge) context.getBean("evenementBadge");

		((ConfigurableApplicationContext) context).close();

		return "/views/admin/listeBadges.xhtml?faces-redirect=true";
	}

	public String supprimerEvenementBadge() {
		
		evenementBadgeDAO.supprimerEvenementBadge(evenementBadge);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		evenementBadge = (EvenementBadge) context.getBean("evenementBadge");

		((ConfigurableApplicationContext) context).close();

		return "/views/admin/listeBadges.xhtml?faces-redirect=true";
	}

}
