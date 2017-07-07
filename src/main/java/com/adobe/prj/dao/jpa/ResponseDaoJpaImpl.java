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
	public List<Survey> getSurvey(int username) {
		
				System.out.println(username);
		TypedQuery<Survey> query = em.createQuery("select s from Survey s where s.surveyId in (select d.surveyId from Distribution d where d.surveyStatus='0' and d.userId="+"'"+username +"'"+")", Survey.class);
		return query.getResultList();
	}

	@Override
	public int addResponse(Response response) {
		//System.out.println(response.getUserName().getUserId() + "    " + response.getQuestionId().getQuestionId() );
		em.persist(response);
		return response.getResponseId();
	}

	@Override
	public Survey getSurveyById(int id) {
		
		return em.find(Survey.class, id);
		
	}

	@Override
	public List<Survey> getClosedSurvey(int username) {
		TypedQuery<Survey> query = em.createQuery("select s from Survey s where s.surveyId in (select d.surveyId from Distribution d where d.surveyStatus='1' and  d.userId="+username+")", Survey.class);
		
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
	public List<Response> getResponse(int qid, int userid) {
		System.out.println(qid +"   "+userid );
		TypedQuery<Response> query = em.createQuery("select r from Response r where r.questionId="+qid +"and r.userId="+userid,Response.class);
		return query.getResultList();
	}

	@Override
	public void updateDistributionTable(int sid, int uname) {
		Query query = em.createQuery("update Distribution d set d.surveyStatus='1' where d.userId="+"'"+uname+"'" +"and d.surveyId="+sid);
			    
			   query.executeUpdate();
		
	}
	
	@Override
	public long count(int questionId, String ans) {
		TypedQuery<Long> query = 
				em.createQuery("select count(*) from Response res where res.questionId="+questionId+" and res.responseText="+"'" +ans+"'", Long.class);
		return query.getResultList().size() == 0 ? 0 : query.getResultList().get(0);
	}
	
	@Override
	public List<String> getResponse(int questionId) {
		TypedQuery<String> query = 
				em.createQuery("select res.responseText from Response res where res.questionId="+questionId, String.class);
		return query.getResultList();
	}

	@Override
	public Response getSingleResponse(int qid, int userid) {
		TypedQuery<Response> query = em.createQuery("select r from Response r where r.questionId="+qid +"and r.userId="+userid,Response.class);
		return query.getSingleResult();
	}
	
}
