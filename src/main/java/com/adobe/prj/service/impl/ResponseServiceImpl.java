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
	public List<Survey> getSurvey(String username) {
		return responseDao.getSurvey(username);
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
	public List<Survey> getClosedSurvey(String username) {
		return responseDao.getClosedSurvey(username);
		
	}

	@Override
	public List<Question> getQuestion(int id) {
		return responseDao.getQuestion(id);
	}

	

	@Override
	public Response getResponse(int qid, String username) {
	return responseDao.getResponse(qid,username);
	}

	@Override
	public void updateDistributionTable(int sid, String uname) {
		responseDao.updateDistributionTable(sid, uname);
		
	}

}
