package com.trast.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trast.dao.EtudiantDAO;
import com.trast.model.Etudiant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ManagedBean(name = "testController", eager = true)
@RequestScoped
public class TestController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	private String attr;
	
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}

	@ManagedProperty(value = "#{etudiant}")
	Etudiant etudiant;
	
	
	@RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
	public String logoutPage() {
			return "logout";
	}
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
			return "login";
	}
	
	public void submit()
	{
		System.out.println(attr);
	}
	
	@RequestMapping(value = "/listetudiant", method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EtudiantDAO etudiantDao = (EtudiantDAO) context.getBean("etudiantDao");
		
		model.addAttribute("etudiantList",etudiantDao.getEtudiants());
			return "etudiant";
			}

	public String afficherDetailsEtudiant() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
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
