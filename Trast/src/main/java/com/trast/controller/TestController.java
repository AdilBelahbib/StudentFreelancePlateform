package com.trast.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.EtudiantDAO;
import com.trast.model.Etudiant;

@ManagedBean(name = "testController", eager = true)
@RequestScoped
public class TestController {
	@ManagedProperty(value = "#{etudiant}")
	Etudiant etudiant;

	public String afficherDetailsEtudiant() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
		        .getRequest();

		Long id = Long.parseLong(request.getParameter("id"));

		this.etudiant = etudiantDao.getEtudiant(new Long(id));
		System.out.println(etudiant.getPrenom()+" "+etudiant.getNom());
		return "detailsEtudiant";
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

}
