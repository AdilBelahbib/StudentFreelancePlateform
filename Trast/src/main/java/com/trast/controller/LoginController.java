package com.trast.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ManagedBean(name = "loginController", eager = true)
@RequestScoped
public class LoginController {
	
	private String userName = null;
	private String password = null;
	
	@ManagedProperty(value="#{authenticationManager}")
	private AuthenticationManager authenticationManager = null;
	

	public String login() {
		       try {
		       Authentication request = new UsernamePasswordAuthenticationToken(this.getUserName(),this.getPassword());
		               Authentication result = authenticationManager.authenticate(request);
		               SecurityContextHolder.getContext().setAuthentication(result);
		           } catch (AuthenticationException e) {
		               e.printStackTrace();
		               return "incorrect";
		           }
		           return "correct";
		       }
		  
		       public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

			public String cancel() {
		           return null;
		       }
		  
		       public String logout(){
		           SecurityContextHolder.clearContext();
		           return "loggedout";
		       }
}
