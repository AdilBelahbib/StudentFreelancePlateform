package com.trast.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trast.dao.ContrePropositionDAO;
import com.trast.dao.EtudiantDAO;
import com.trast.model.ContreProposition;
import com.trast.model.Etudiant;
import com.trast.model.Fichier;
import com.trast.service.UploadFileService;

@ManagedBean(name = "contrePropositionController", eager = true)
@RequestScoped
public class ContrePropositionController implements Serializable {

	private static final long serialVersionUID = 4726001098326245561L;
	
	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	private Etudiant etudiant;
	
	@ManagedProperty(value = "#{contreProposition}")
	private ContreProposition contreProposition;
	
	@ManagedProperty(value = "#{contrePropositionDao}")
	private ContrePropositionDAO contrePropositionDao;
	
	@ManagedProperty(value = "#{etudiantDao}")
	private EtudiantDAO etudiantDao;

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public ContreProposition getContreProposition() {
		return contreProposition;
	}

	public void setContreProposition(ContreProposition contreProposition) {
		this.contreProposition = contreProposition;
	}
	
	public ContrePropositionDAO getContrePropositionDao() {
		return contrePropositionDao;
	}

	public void setContrePropositionDao(ContrePropositionDAO contrePropositionDao) {
		this.contrePropositionDao = contrePropositionDao;
	}
	
	public EtudiantDAO getEtudiantDao() {
		return etudiantDao;
	}

	public void setEtudiantDao(EtudiantDAO etudiantDao) {
		this.etudiantDao = etudiantDao;
	}

	public void retirerContreProposition()
	{
		// suppression du File associé
				
			if(contreProposition.getFichier()!=null)
				UploadFileService.supprimerFile(contreProposition.getFichier());

		// fin suppr du File 		
				
		etudiant.getContrePropositions().remove(contreProposition);
		etudiant.setNombreBids(etudiant.getNombreBids()+1);
		
		contreProposition.setEtudiant(null);
		contrePropositionDao.modifierContreProposition(contreProposition);
		contrePropositionDao.supprimerContreProposition(contreProposition.getId());
		etudiantDao.modifierEtudiant(etudiant);
		
		// RÃ©initialiser l'experience par une nouvelle instance vide
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		contreProposition = (ContreProposition) context.getBean("contreProposition");
		((ConfigurableApplicationContext) context).close();
	}
	
}
