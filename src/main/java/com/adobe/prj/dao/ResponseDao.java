package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Response;
import com.adobe.prj.entity.Survey;

public interface ResponseDao {

	List<Survey> getSurvey(int username);
	int addResponse(Response response);
	Survey getSurveyById(int id);
	List<Survey> getClosedSurvey(int  username);
	List<Question>getQuestion(int id);
	List<Response> getResponse(int qid,int userid);
	Response getSingleResponse(int qid,int userid);
	void updateDistributionTable(int sid,int uname);
	 
	/*
	 *  It returns that how many user responds ans
	 *  for the given question id.
	 */
	long count(int questionId, String ans);
	 
	/*
	 *  It return responses of the given question id.
	 */
	List<String> getResponse(int questionId);

}
