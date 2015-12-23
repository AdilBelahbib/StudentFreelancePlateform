package com.trast.model;


import java.util.Date;
import java.util.Set;

public class Qualification {
	
	private Long id;
	private Date dateDebut;
	private Date dateFin;
	private Etudiant etudiant;
	private Set<Fichier> fichiers;
	private AppelOffre appelOffre;
	
	public Qualification() {

	}
	public Qualification(Long id, Date dateDebut, Date dateFin, Etudiant etudiant,Set<Fichier> fichiers,AppelOffre appelOffre) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etudiant = etudiant;
		this.fichiers = fichiers;
		this.appelOffre = appelOffre;
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
	public AppelOffre getAppelOffre() {
		return appelOffre;
	}
	public void setAppelOffre(AppelOffre appelOffre) {
		this.appelOffre = appelOffre;
	}
	@Override
	public int hashCode() {
		 final int prime = 31;
		  int result = 1;
		  if(id != null)
		   result = prime * result + id.intValue();
		  else 
		   result = prime * result + (dateDebut.hashCode()*dateFin.hashCode());
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