package com.trast.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import javax.faces.bean.ManagedBean;
import javax.transaction.Transactional;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.trast.dao.EtudiantDAO;
import com.trast.model.Adresse;
import com.trast.model.Etudiant;

@ManagedBean(name = "etudiantControllerKhouloud", eager = true)
@SessionScoped
public class EtudiantControllerKhouloud implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//L'etudiant concerné
	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	Etudiant etudiant;
	
	@ManagedProperty(value = "#{etudiantDao}")
	EtudiantDAO etudiantDao;
	
	//Liste contenant les adresses de l'étudiant 
	@ManagedProperty(value = "#{listesAdresse}")
	List<Adresse> listesAdresse;

	
	@Transactional
	public String profileEtudiant() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		this.etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
		.getRequest();
		
		HttpSession session = request.getSession();
		this.etudiant = (Etudiant) session.getAttribute("utilisateur");
		//System.out.println("test" + etudiant.getId());
		Set<Adresse> listes = this.etudiant.getAdresses();
		this.listesAdresse = new ArrayList<Adresse>(listes);
		//System.out.println(" "+listesAdresse.get(0).getAdresse());
		((ConfigurableApplicationContext)context).close();
		return "profil";
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	public EtudiantDAO getEtudiantDao() {
		return etudiantDao;
	}

	public void setEtudiantDao(EtudiantDAO etudiantDao) {
		this.etudiantDao = etudiantDao;
	}

	public List<Adresse> getListesAdresse() {
		return listesAdresse;
	}

	public void setListesAdresse(List<Adresse> listesAdresse) {
		this.listesAdresse = listesAdresse;
	}


	
}
