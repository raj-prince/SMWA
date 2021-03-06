package com.adobe.prj.service;

import java.util.Date;
import java.util.List;

import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.entity.User;

//@Service
//@Transactional
public interface SurveyService {
	

	public List<Question> getQuestions(int id);
	public int addSurvey(Survey survey);
	public int addQuestion(Question question);
	public int distributeSurvey(Distribution distribution);

	/*
	 *  return list of distributed survey.
	 */
	public List<Distribution> getDistributedSurveys();
	
	/*
	 *  return list of all survey created by the given user.
	 */
	public List<Survey> getAllSurvey(String createdBy);
	
	/*
	 *  return count of the Responded user.
	 */
	public long cntClosedStatus(int surveyId);
		
	/*
	 *  return count of the not responded user.
	 */
	public long cntOpenStatus(int surveyId);
	
	/*
	 *  return time stamp of the survey at the time of distribution.
	 */
	public Date getTimeStamp(int surveyId);
	
	/*
	 *  return all question for a given survey.
	 */
	public List<Question> getQuestionsForReview(int surveyId);
	
	/*
	 *  return number of user response as res for given Question.
	 */
	public long countResponse(int questionId, String res);
	
	/*
	 *  return survey object for survey id.
	 */
	public Survey getSurvey(int surveyId);
	
	/*
	 *  return response for a given question id.
	 */
	public List<String> getResponseForId(int questionId);

	Survey getSurveyById(int sid);
	public List<User> getUnsentUsers(Survey s);
	public com.adobe.prj.entity.User getUserByName(String uname);
}
