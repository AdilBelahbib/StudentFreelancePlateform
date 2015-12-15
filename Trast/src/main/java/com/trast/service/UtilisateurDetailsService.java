package com.trast.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.trast.dao.UtilisateurDAO;
import com.trast.model.Utilisateur;
import com.trast.model.RoleUtilisateur;

public class UtilisateurDetailsService implements UserDetailsService {

	private UtilisateurDAO utilisateurDao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur utilisateur = utilisateurDao.getByEmail(email);
		
		System.out.println("GETTING USER BY MAIL: "+email+" ...");
		System.out.println("ID: "+utilisateur.getId());
		
		List<GrantedAuthority> authorities = buildUserAuthority(utilisateur.getRoleUtilisateur());

		return buildUserForAuthentication(utilisateur, authorities);
	}

	private User buildUserForAuthentication(Utilisateur utilisateur, List<GrantedAuthority> authorities) {
		return new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(RoleUtilisateur userRole) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	public UtilisateurDAO getUtilisateurDao() {
		return utilisateurDao;
	}

	public void setUtilisateurDao(UtilisateurDAO utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

}
