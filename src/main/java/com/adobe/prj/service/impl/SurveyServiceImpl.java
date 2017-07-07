package com.adobe.prj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adobe.prj.dao.DistributionDao;
import com.adobe.prj.dao.QuestionDao;
import com.adobe.prj.dao.ResponseDao;
import com.adobe.prj.dao.SurveyDao;
import com.adobe.prj.dao.UserDao;
import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.entity.User;
import com.adobe.prj.service.SurveyService;

@Service
@Transactional
public class SurveyServiceImpl implements SurveyService {
	@Autowired
	private SurveyDao surveyDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private DistributionDao distributionDao;
	
	@Autowired
	private ResponseDao responseDao;
	
	@Autowired
	private UserDao userDao;
	@Override
	public List<Question> getQuestions(int id) {
		
		return surveyDao.getQuestions(id);
	}

	@Override
	public int addSurvey(Survey survey) {
		// TODO Auto-generated method stub
		return surveyDao.addSurvey(survey);
	}

	@Override
	public int addQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDao.addQuestion(question);
	}

	@Override
	public int distributeSurvey(Distribution distribution) {
		
		return distributionDao.distributeSurvey(distribution);
	}
	
	@Override
	public List<Distribution> getDistributedSurveys() {
		return distributionDao.getDistributedSurveys();
	}
	
	// return list of all survey created by the given user.
	public List<Survey> getAllSurvey(String createdBy) {
		return surveyDao.getAllSurvey(createdBy);
	}
	
	@Override
	public int cntClosedStatus(int surveyId) {
		return distributionDao.cntClosedStatus(surveyId);
	}
			
	@Override
	public int cntOpenStatus(int surveyId) {
		return distributionDao.cntClosedStatus(surveyId);
	}
	
	@Override
	public Date getTimeStamp(int surveyId) {
		return distributionDao.getTimeStamp(surveyId);
	}
	
	@Override
	public List<Question> getQuestionsForReview(int surveyId) {
		return questionDao.getQuestions(surveyId);
	}
	
	@Override
	public int countResponse(int questionId, String res) {
		return responseDao.count(questionId, res);
	}
	
	@Override
	public Survey getSurvey(int surveyId) {
		return surveyDao.getSurvey(surveyId);
	}
	
	@Override
	public List<String> getResponseForId(int questionId) {
		return responseDao.getResponse(questionId);
	}
	
	public Survey getSurveyById(int sid){
		return surveyDao.getSurveyById(sid);
	}

	@Override
	public List<User> getUnsentUsers(Survey s) {
		return distributionDao.getUnsentUsers(s);
		
	}

	@Override
	public User getUserByName(String uname) {
		return userDao.getUserByName(uname);
//		return null;
	}
}
