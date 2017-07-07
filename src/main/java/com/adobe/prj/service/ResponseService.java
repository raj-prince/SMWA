package com.adobe.prj.service;

import java.util.List;

import com.adobe.prj.dto.ResponseDto;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Response;
import com.adobe.prj.entity.Survey;

public interface ResponseService {

	List<Survey> getSurvey(int i);
	int addResponse(ResponseDto response);
	Survey getSurveyById(int id);
	List<Survey> getClosedSurvey(int username);
	List<Question> getQuestion(int id);
	Response getResponse(int qid,int username);
	void updateDistributionTable(int sid,int uname);
	Question getQuesById(int qid);
	
}
