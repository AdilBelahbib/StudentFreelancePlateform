package com.trast.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import com.trast.model.Fichier;

@ManagedBean(name = "uploadFileService", eager = true)
@SessionScoped
public class UploadFileService {
	
	@ManagedProperty(value = "#{myFile}")
	 static Part myFile;
	
	/*****************************************/
	public static void uploadFichier(Fichier fichier){
		String extens="";
		int i = myFile.getSubmittedFileName().lastIndexOf('.');
		if (i > 0) {
		    extens =  myFile.getSubmittedFileName().substring(i+1);
		    fichier.setTitre(fichier.getTitre()+"."+extens);
		    
		}
		 try (InputStream input = myFile.getInputStream()) {
		        Files.copy(input, new File(fichier.getChemin(),fichier.getTitre()).toPath());
		    }
		    catch (IOException e) {
		    }
		
	}

	public static boolean fileSelected(){
		return (myFile!=null);
	}
	
	/*****************************************/
	
	public Part getMyFile() {
		return myFile;
	}

	public void setMyFile(Part myFile) {
		UploadFileService.myFile = myFile;
	}

}
