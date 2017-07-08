package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Question;

public interface QuestionDao {
	
	/*
	 * Insert Question object in DataBase and
	 * return id of that question object.
	 */
	public int addQuestion(Question question);
	
	/*
	 *  return all question of a given survey.
	 */
	public List<Question> getQuestions(int surveyId);
	
	/*
	 * return Question object with given question id.
	 */
	public Question getQuesById(int qid);
}
