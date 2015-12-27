package com.trast.dao;

import java.util.List;

import com.trast.model.ResultatTest;


public interface ResultatTestDAO {
	public List<ResultatTest> getResultatsTest();
	public ResultatTest getResultatTestParId(Long id);
	public void ajouterResultatTest(ResultatTest resultat);
	public void modifierResultatTest(ResultatTest resultatTest);
	public void supprimerResultatTest(Long id);
}
