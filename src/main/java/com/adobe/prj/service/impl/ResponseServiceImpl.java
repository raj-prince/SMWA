package com.adobe.prj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adobe.prj.dao.ResponseDao;
import com.adobe.prj.entity.Response;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.entity.Question;
import com.adobe.prj.service.ResponseService;

@Service
@Transactional
public class ResponseServiceImpl implements ResponseService{

	@Autowired
	ResponseDao responseDao;
	
	@Override
	public List<Survey> getSurvey() {
		return responseDao.getSurvey();
	}

	@Override
	public Survey getSurveyById(int id) {
		return responseDao.getSurveyById(id);
	}

	@Override
	public int addResponse(Response response) {
		return responseDao.addResponse(response);
	}

	@Override
	public Survey getClosedSurvey() {
		return responseDao.getClosedSurvey();
		
	}

	@Override
	public List<Question> getQuestion(int id) {
		return responseDao.getQuestion(id);
	}

}
