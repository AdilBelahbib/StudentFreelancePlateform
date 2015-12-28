package com.trast.dao;

import java.util.List;

import com.trast.model.Question;

public interface QuestionDAO {
	public Question getQuestionParId(Long id);
	public List<Question> getQuestions();
	public void ajouterQuestion(Question question);
	public void supprimerQuestion(Question question);
	public void modifierQuestion(Question question);

}
