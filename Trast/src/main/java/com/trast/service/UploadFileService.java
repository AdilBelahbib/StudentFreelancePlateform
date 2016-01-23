package com.trast.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.trast.model.Fichier;

@ManagedBean(name = "uploadFileService", eager = true)
@SessionScoped
public class UploadFileService {

	@ManagedProperty(value = "#{myFile}")
	static Part myFile;

	@ManagedProperty(value = "#{proprietes['racineuploads']}")
	static String racine;
	
	@ManagedProperty(value = "#{fileToDownload}")
	static String fileToDownload;

	


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
		 File rep = new File(racine+fichier.getChemin());
		 if(!rep.exists()) rep.mkdirs();
			
		 File oldFile = new File(racine+fichier.getChemin()+"/"+fichier.getTitre());
		 if(oldFile.exists()) oldFile.delete();
		try (InputStream input = myFile.getInputStream()) {
			Files.copy(input, (new File(racine+fichier.getChemin(), fichier.getTitre()).toPath()));
		} catch (IOException e) {
			System.out.println("exception " + e.toString());
		}

	}

	

	/*********************************************/
	/*cette fonction permet à l'utilisateur de télécharger le fichier : fileToDownload*/
	public void downloadFile() {
		System.out.println("download file");
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    
		try{  
			System.out.println("download file");
			File fichier = new File(fileToDownload);
		     System.out.println("mime: "+ec.getMimeType(fichier.getName())+" ,name: "+fichier.getName());
			
			 
		     HttpServletResponse response =(HttpServletResponse) ec.getResponse();
		     response.setContentType(ec.getMimeType(fichier.getName()));
		     response.setHeader("Content-Disposition", "attachment;filename="+fichier.getName());
		     response.setContentLength((int)fichier.length());
		     
		     OutputStream output = response.getOutputStream();
		     Files.copy(fichier.toPath(), output);
		     FacesContext.getCurrentInstance().responseComplete();
		}
		catch(IOException e){
			System.out.println("exception: "+e.toString());
		}
         
}

	public static void supprimerFile(Fichier fichier){
		// tester l'existence du fichier et le supprimer du dossier
		File fileASupprimer = new File(racine+fichier.getChemin()+"/"+fichier.getTitre());
		if(fileASupprimer.exists()) fileASupprimer.delete();
		
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
	
	public String getFileToDownload() {
		return fileToDownload;
	}



	public  void setFileToDownload(String fileToDownload) {
		UploadFileService.fileToDownload = fileToDownload;
	}

}
