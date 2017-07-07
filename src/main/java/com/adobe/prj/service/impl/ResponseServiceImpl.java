package com.adobe.prj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adobe.prj.dao.QuestionDao;
import com.adobe.prj.dao.ResponseDao;
import com.adobe.prj.dao.UserDao;
import com.adobe.prj.dto.ResponseDto;
import com.adobe.prj.entity.Response;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.entity.Question;
import com.adobe.prj.service.ResponseService;

@Service
@Transactional
public class ResponseServiceImpl implements ResponseService{

	@Autowired
	ResponseDao responseDao;
	
	@Autowired
	QuestionDao questionDao;
	@Autowired
	UserDao userDao;
	
	@Override
	public List<Survey> getSurvey(int username) {
		return responseDao.getSurvey(username);
	}

	@Override
	public Survey getSurveyById(int id) {
		return responseDao.getSurveyById(id);
	}

	@Override
	public int addResponse(ResponseDto response) {
		Response res=new Response();
		res.setQuestionId(getQuesById(response.getQuestionId()));
		res.setResponseText(response.getResponseText());
		
		System.out.println(response.getUserId().toString());
		
		res.setUserName(response.getUserId());
		//System.out.println(res.getUserId().getUserId());
		return responseDao.addResponse(res);
	}

	@Override
	public List<Survey> getClosedSurvey(int username) {
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
	public void updateDistributionTable(int sid, int uname) {
		responseDao.updateDistributionTable(sid, uname);
		
	}

	@Override
	public Question getQuesById(int qid) {
		return questionDao.getQuesById(qid);
	}
	

}
