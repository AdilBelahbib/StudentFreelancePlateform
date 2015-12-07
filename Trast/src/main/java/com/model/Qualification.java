package com.model;


import java.util.Date;
import java.util.Set;

public class Qualification {
	
	private Long id;
	private Date dateDebut;
	private Date dateFin;
	private Etudiant etudiant;
	private Set<Fichier> fichiers;
	private Set<AppelOffre> appelOffres;
	
	public Qualification() {
		super();
	}
	public Qualification(Long id, Date dateDebut, Date dateFin, Etudiant etudiant,Set<Fichier> fichiers,Set<AppelOffre> appelOffres) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etudiant = etudiant;
		this.fichiers = fichiers;
		this.appelOffres = appelOffres;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Set<Fichier> getFichiers() {
		return fichiers;
	}
	public void setFichiers(Set<Fichier> fichiers) {
		this.fichiers = fichiers;
	}
	public Set<AppelOffre> getAppelOffres() {
		return appelOffres;
	}
	public void setAppelOffres(Set<AppelOffre> appelOffres) {
		this.appelOffres = appelOffres;
	}
	@Override
	public int hashCode() {
		 final int prime = 31;
		  int result = 1;
		  if(id != null)
		   result = prime * result + id.intValue();
		  else 
		   result = prime * result + dateDebut.hashCode();
		  return result;

	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Qualification other = (Qualification) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
}