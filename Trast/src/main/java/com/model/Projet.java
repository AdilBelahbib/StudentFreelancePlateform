package com.model;


public class Projet {
	
	private Long id;
	private Etudiant etudiant;
	private CahierDesCharges cahierDesCharges;
	
	
	public Projet(){
		
	}


	public Projet(Long id, Etudiant etudiant, CahierDesCharges cahierDesCharges) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.cahierDesCharges = cahierDesCharges;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}
}
