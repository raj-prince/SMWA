package com.adobe.prj.service;

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

//@Service
//@Transactional
public interface SurveyService {
	

	public List<Question> getQuestions(int id);
	public int addSurvey(Survey survey);
	public int addQuestion(Question question);
	public int distributeSurvey(Distribution distribution);
	Survey getSurveyById(int sid);
}
