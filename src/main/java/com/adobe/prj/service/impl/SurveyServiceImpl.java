package com.adobe.prj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adobe.prj.dao.DistributionDao;
import com.adobe.prj.dao.QuestionDao;
import com.adobe.prj.dao.SurveyDao;
import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Survey;
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

}
