package com.adobe.prj.service;

import java.util.List;

import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Response;
import com.adobe.prj.entity.Survey;

public interface ResponseService {

	List<Survey> getSurvey(String username);
	int addResponse(Response response);
	Survey getSurveyById(int id);
	List<Survey> getClosedSurvey(String username);
	List<Question> getQuestion(int id);
	Response getResponse(int qid,String username);
	void updateDistributionTable(int sid,String uname);
	
}
