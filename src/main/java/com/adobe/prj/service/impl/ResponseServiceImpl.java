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
import com.adobe.prj.entity.QuestionType;
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
		
		
		int qid=response.getQuestionId();
		Question ques=questionDao.getQuesById(qid);
		String ans,parsedAns;
		ans=response.getResponseText();
		int idx=ans.indexOf(',');
		if(ques.getQuestionType()==QuestionType.MORE_CORRECT && idx!=-1)
		{
			
			
			System.out.println(idx);
			
			while((idx!=-1))
			    {
				parsedAns=ans.substring(0,idx);
				System.out.println(parsedAns+"  ");
				Response res=new Response();
				res.setQuestionId(getQuesById(response.getQuestionId()));
				res.setResponseText(parsedAns);
				res.setUserId(response.getUserId());
				responseDao.addResponse(res);
				ans=ans.substring(idx+1);
				idx=ans.indexOf(',');
				
					}
			Response res=new Response();
			res.setQuestionId(getQuesById(response.getQuestionId()));
			res.setResponseText(ans);
			res.setUserId(response.getUserId());
			return responseDao.addResponse(res);
			
		}
		
		else{
			Response res=new Response();
		res.setQuestionId(getQuesById(response.getQuestionId()));
		res.setResponseText(response.getResponseText());
		
		
		
		res.setUserId(response.getUserId());
		
		
		return responseDao.addResponse(res);
		}
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
	public List<Response> getResponse(int qid, int userid) {
	return responseDao.getResponse(qid,userid);
	}

	@Override
	public void updateDistributionTable(int sid, int uname) {
		responseDao.updateDistributionTable(sid, uname);
		
	}

	@Override
	public Question getQuesById(int qid) {
		return questionDao.getQuesById(qid);
	}

	@Override
	public Response getSingleResponse(int qid, int userid) {
	
		return responseDao.getSingleResponse(qid,userid);
	}
	

}
