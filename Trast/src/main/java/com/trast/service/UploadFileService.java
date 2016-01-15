package com.trast.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import com.trast.dao.FichierDAO;
import com.trast.model.Fichier;

@ManagedBean(name = "uploadFileService", eager = true)
@SessionScoped
public class UploadFileService {

	@ManagedProperty(value = "#{myFile}")
	static Part myFile;

	@ManagedProperty(value = "#{proprietes['racineuploads']}")
	static String racine;

	/*****************************************/
	public static void uploadFichier(Fichier fichier) {
		String extens = "";
		int i = myFile.getSubmittedFileName().lastIndexOf('.');
		if (i > 0) {
			extens = myFile.getSubmittedFileName().substring(i + 1);
			fichier.setTitre(fichier.getTitre() + "." + extens);

		}
		 System.out.println("Upload ---- chemin: "+fichier.getChemin()+", titre: "+fichier.getTitre());

		/* créer repertoire si ca n'existe pas*/
		if((new File(racine+fichier.getChemin())).mkdirs()){
			
		try (InputStream input = myFile.getInputStream()) {
			Files.copy(input, (new File(racine+fichier.getChemin(), fichier.getTitre()).toPath()));
		} catch (IOException e) {
			System.out.println("exception " + e.toString());
		}
		}
		else System.out.println("failed to create folder");

	}

	public static boolean fileSelected() {
		return (myFile != null);
	}
	public static void definirPart(Part part){
		UploadFileService.myFile=part;
	}

	/*****************************************/

	public Part getMyFile() {
		return myFile;
	}

	public void setMyFile(Part myFile) {
		UploadFileService.myFile = myFile;
	}

	public String getRacine() {
		return racine;
	}

	public void setRacine(String racine) {
		UploadFileService.racine = racine;
	}
	
}
