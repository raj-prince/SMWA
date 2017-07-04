package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Question;

public interface SurveyDao {
	public List<Question> getQuestions();
}
