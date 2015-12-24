package com.trast.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.transaction.Transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.AppelOffreDAO;
import com.trast.model.AppelOffre;
import com.trast.model.ContreProposition;

@ManagedBean(name = "appelOffreControllerKhouloud", eager = true)
@SessionScoped
public class AppelOffreControllerKhouloud implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{appelOffre}")
	private AppelOffre appelOffre;
	
	@ManagedProperty(value = "#{appelOffreDao}")
	private AppelOffreDAO appelOffreDao;
	//LISTES DES APPELS D'OFFRE
	@ManagedProperty(value = "#{listes}")
	private List<AppelOffre> listes;
	
	@ManagedProperty(value = "#{contreProposition}")
	private ContreProposition contreProposition;
	
	public ContreProposition getContreProposition() {
		return contreProposition;
	}

	public void setContreProposition(ContreProposition contreProposition) {
		this.contreProposition = contreProposition;
	}

	public List<AppelOffre> getListes() {
		return listes;
	}

	public void setListes(List<AppelOffre> listes) {
		this.listes = listes;
	}

	public AppelOffre getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffre appelOffre) {
		this.appelOffre = appelOffre;
	}

	public AppelOffreDAO getAppelOffreDao() {
		return appelOffreDao;
	}

	public void setAppelOffreDao(AppelOffreDAO appelOffreDao) {
		this.appelOffreDao = appelOffreDao;
	}
	
	@Transactional
	public String listerAppelOffres(){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		this.appelOffreDao = (AppelOffreDAO) context.getBean("appelOffreDao");

		this.listes = this.appelOffreDao.getAppelOffres();
		//System.out.println(listes.get(0).getId()+" "+listes.get(0).getStatut());
		((ConfigurableApplicationContext)context).close();
		return "listeAppelOffres";
	}
	
	public void ajouterContreProposition() {
		//contreProposition.setEtudiant(etudiant);
		contreProposition.setAppelOffre(appelOffre);
		appelOffre.getContrePropositions().add(contreProposition);
		System.out.println(" size == "+appelOffre.getContrePropositions().size());
		// réinitialisation
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		contreProposition = (ContreProposition) context.getBean("contreProposition");
		((ConfigurableApplicationContext) context).close();
	}

}
