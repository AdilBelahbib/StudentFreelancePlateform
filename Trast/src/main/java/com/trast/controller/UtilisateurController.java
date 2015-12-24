package com.trast.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

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
					System.out.println("GETTING USER DATA FROM DATABASE");
					break;
				}
		}

	}

}
