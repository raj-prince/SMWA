package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Survey;

public interface SurveyDao {
	public List<Question> getQuestions(int id);
	public int addSurvey(Survey survey);
	Survey getSurveyById(int surveyId);
}
