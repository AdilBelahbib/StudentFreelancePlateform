package com.trast.service;

import java.util.Date;

public class DateCalculService {
	
	
	public static String calculDuree(Date dInf, Date dSup){
		System.out.println("date sys : "+dInf.toString());
		String duree="";
		int val=0;
		int coef =1000*60*60*24*30;
		long diffMs;
		if(dSup.getTime()>dInf.getTime())
			{
				diffMs = dSup.getTime() - dInf.getTime();
				duree = "il reste: ";
			}
		else 
			{
				diffMs = dInf.getTime() -  dSup.getTime() ;
				duree = "retard de: ";
			}
		val = (int) (diffMs/coef);
		/* recupere mois*/
		if(val>0) 
		{
				duree+=val+" mois, ";
				diffMs-=val*coef;
		}
		coef = 1000*60*60*24;
		val = (int) (diffMs/coef);
		/* recupere jours*/
		if(val>0) 
		{
				diffMs-=val*coef;
				if(diffMs>0) val+=1;
				duree+=val+" jours.";
		}
		else{/* reste ms*/
			duree+="1 jour.";
		}
		return duree;
	}

}
