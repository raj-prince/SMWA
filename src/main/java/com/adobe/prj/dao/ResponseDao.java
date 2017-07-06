package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Response;
import com.adobe.prj.entity.Survey;

public interface ResponseDao {
	
	 List<Survey> getSurvey();
	 int addResponse(Response response);
	 Survey getSurveyById(int id);
	 Survey getClosedSurvey();
	 List<Question>getQuestion(int id);
	 
	 // it returns that how many user responds ans for the given question id.
	 int count(int questionId, String ans);
	 
	 // it return responses of the given question id.
	 List<String> getResponse(int questionId);

	

}
