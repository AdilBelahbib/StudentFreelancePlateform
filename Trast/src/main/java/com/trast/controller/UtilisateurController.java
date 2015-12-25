package com.trast.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.trast.dao.UtilisateurDAO;
import com.trast.model.Utilisateur;

@ManagedBean(name = "utilisateurController", eager = true)
@RequestScoped
public class UtilisateurController implements Serializable {
	private static final long serialVersionUID = -3503929045339827895L;
	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	private Utilisateur utilisateur;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void verifierSession() {
		
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && (utilisateur == null)) {
			for (GrantedAuthority ga : SecurityContextHolder.getContext().getAuthentication().getAuthorities())
				if(!ga.toString().equals("ROLE_ANONYMOUS"))
				{
					//Ajouter l'utilisateur connecté dans la session
					HttpServletRequest httpRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
					HttpSession session = httpRequest.getSession();
					
					//Appeler le context pour récupérer les DAOs
					ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		        	UtilisateurDAO utilisateurDAO = (UtilisateurDAO) context.getBean("utilisateurDao");

					session.setAttribute("utilisateur", utilisateurDAO.getByEmail(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));
					
					((ConfigurableApplicationContext)context).close();
					break;
				}
		}

	}

}
