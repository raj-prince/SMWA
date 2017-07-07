package com.adobe.prj.dao.jpa;

import java.util.List;
import org.springframework.security.core.Authentication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.ResponseDao;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Response;
import com.adobe.prj.entity.Survey;

@Repository
public class ResponseDaoJpaImpl implements ResponseDao {

	@PersistenceContext
	private EntityManager em;

	
	public int id;// should be set to the respondent userId 
	


	
	@Override
	public List<Survey> getSurvey(String username) {
		
				System.out.println(username);
		TypedQuery<Survey> query = em.createQuery("select s from Survey s where s.surveyId in (select d.surveyId from Distribution d where d.surveyStatus='1' and d.userName="+"'"+username+"'"+")", Survey.class);
		return query.getResultList();
	}

	@Override
	public int addResponse(Response response) {
		em.persist(response);
		return response.getResponseId();
	}

	@Override
	public Survey getSurveyById(int id) {
		
		return em.find(Survey.class, id);
		
	}

	@Override
	public List<Survey> getClosedSurvey(String username) {
		TypedQuery<Survey> query = em.createQuery("select s from Survey s where s.surveyId in (select d.surveyId from Distribution d where d.surveyStatus='0' and  d.userName="+"'"+username+"'"+")", Survey.class);
		
		System.out.println(username);
		return query.getResultList();
	}

	@Override
	public List<Question> getQuestion(int id) {
		
		TypedQuery<Question> query = em.createQuery("select q from Question q where q.surveyId="+id,Question.class);
		System.out.println(query);
		return query.getResultList();
		
	}


	@Override
	public Response getResponse(int qid, String username) {
		TypedQuery<Response> query = em.createQuery("select r from Response r where r.questionId=."+id +"and r.userName="+"'"+username+"'",Response.class);
		return query.getSingleResult();
	}

	@Override
	public void updateDistributionTable(int sid, String uname) {
		Query query = em.createQuery("update Distribution d set d.surveyStatus='0' where d.userName="+"'"+uname+"'");
			    
			   query.executeUpdate();
		
	}
	
	

	
	
}
