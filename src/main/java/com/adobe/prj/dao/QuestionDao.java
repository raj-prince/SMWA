package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Question;

public interface QuestionDao {
	public int addQuestion(Question question);
	
	// return all question of a given survey.
	public List<Question> getQuestions(int surveyId);
	public Question getQuesById(int qid);
}
