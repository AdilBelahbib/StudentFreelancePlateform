package com.trast.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import com.trast.model.Etudiant;
import com.trast.model.ResultatTest;

@ManagedBean(name = "calendrierController", eager = true)
@ViewScoped
public class CalendrierController implements Serializable {

	private static final long serialVersionUID = 8560844709856632356L;

	@ManagedProperty(value = "#{sessionScope.utilisateur}")
	private Etudiant etudiant;
	private ScheduleModel eventModel;

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	@PostConstruct
	public void init() {
		System.out.println("INIT STARTING ...");
		eventModel = new DefaultScheduleModel();

		for (ResultatTest resultat : etudiant.getResultatTests())
			eventModel.addEvent(new DefaultScheduleEvent(resultat.getTest().getTitre(),
					resultat.getDateDernierPassage(), resultat.getDateDernierPassage()));

		System.out.println("INIT FINISHED.");
	}

}
