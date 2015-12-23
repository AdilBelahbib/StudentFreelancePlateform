package com.trast.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.trast.dao.UtilisateurDAO;

@ManagedBean(name = "loginController", eager = true)
@RequestScoped
public class LoginController {

	@Inject
	private LoginBean loginBean;
	private AuthenticationManager authenticationManager;

	/**
	 * the login action called by the view
	 * 
	 * @return
	 */
	@Transactional
	public void login() {
		System.out.println(loginBean.getUserName()+" "+loginBean.getPassword());
		try {
			System.out.println("Login started for User with Name: " + getLoginBean().getUserName());
			// check if userdata is given
			if (getLoginBean().getUserName() == null || getLoginBean().getPassword() == null) {
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "login.failed");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				System.out.println("Login not started because userName or Password is empty: " + getLoginBean().getUserName());
			}

			// authenticate afainst spring security
			Authentication request = new UsernamePasswordAuthenticationToken(getLoginBean().getUserName(),
					getLoginBean().getPassword());

			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
			
			//Ajouter l'utilisateur connecté dans la session
			HttpServletRequest httpRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			HttpSession session = httpRequest.getSession();
			
			//Appeler le context pour récupérer les DAOs
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        	UtilisateurDAO utilisateurDAO = (UtilisateurDAO) context.getBean("utilisateurDao");

			session.setAttribute("utilisateur", utilisateurDAO.getByEmail(((User)result.getPrincipal()).getUsername()));
			
			((ConfigurableApplicationContext)context).close();
			
		} catch (AuthenticationException e) {
			System.out.println("Login failed: " + e.getMessage());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "login.failed");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}
		
	}

	/**
	 * @return the loginBean
	 */
	public LoginBean getLoginBean() {
		return loginBean;
	}

	/**
	 * @param loginBean
	 * the loginBean to set
	 */
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	/**
	 * @return the authenticationManager
	 */
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	/**
	 * @param authenticationManager
	 *            the authenticationManager to set
	 */
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}


}
