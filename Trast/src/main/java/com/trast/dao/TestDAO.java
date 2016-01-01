package com.trast.dao;

import java.util.List;

import com.trast.model.Test;

public interface TestDAO {
	public List<Test> getTests();
	public Test getTestParId(Long id);
	public void ajouterTest(Test test);
	public void supprimerTest(Long id);
	public List<Test> getTestsAdmin();
	public List<Test> getTestsEntreprises();
}
