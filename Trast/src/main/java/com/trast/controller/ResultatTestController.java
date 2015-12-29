package com.trast.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.trast.dao.ResultatTestDAO;
import com.trast.model.ResultatTest;


@ManagedBean(name = "resultatTestController", eager = true)
@RequestScoped
public class ResultatTestController {
		
	@ManagedProperty(value = "#{resultatTestDao}")
	private ResultatTestDAO resultatTestDao;
	
	private List<ResultatTest> listeResultats;

	public ResultatTestDAO getResultatTestDao() {
		return resultatTestDao;
	}

	public void setResultatTestDao(ResultatTestDAO resultatTestDao) {
		this.resultatTestDao = resultatTestDao;
	}

	public List<ResultatTest> getListeResultats() {
		return listeResultats;
	}

	public void setListeResultats(List<ResultatTest> listeResultats) {
		this.listeResultats = listeResultats;
	}
	
	public void getAllResultatsTests(){
		listeResultats = resultatTestDao.getResultatsTest();
	}
	
}
