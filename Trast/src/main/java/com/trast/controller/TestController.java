package com.trast.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.trast.dao.TestDAO;
import com.trast.model.Test;

@ManagedBean(name = "testController", eager = true)
@RequestScoped
public class TestController {
	@ManagedProperty(value = "#{testDao}")
	private TestDAO testDao;
	
	private List<Test> tests;
	
	public TestDAO getTestDao() {
		return testDao;
	}

	public void setTestDao(TestDAO testDao) {
		this.testDao = testDao;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public void getAllTests()
	{
		tests = testDao.getTests();
		System.out.println(tests.size());
	}
	

}
