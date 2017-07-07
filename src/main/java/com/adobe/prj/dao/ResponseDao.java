package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Response;
import com.adobe.prj.entity.Survey;

public interface ResponseDao {
	
	 List<Survey> getSurvey(String username);
	 int addResponse(Response response);
	 Survey getSurveyById(int id);
	 List<Survey> getClosedSurvey(String username);
	 List<Question>getQuestion(int id);
<<<<<<< HEAD
	Response getResponse(int qid,String username);
	 
	void updateDistributionTable(int sid,String uname);
=======
	 
	 // it returns that how many user responds ans for the given question id.
	 int count(int questionId, String ans);
	 
	 // it return responses of the given question id.
	 List<String> getResponse(int questionId);

	
>>>>>>> e555c361c6254ec4db8a69797c4e96cec56aa767

}
