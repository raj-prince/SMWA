package com.adobe.prj.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adobe.prj.dao.SurveyDao;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Survey;

@Repository
public class SurveyDaoJpaImpl implements SurveyDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Question> getQuestions(int id) {
		TypedQuery<Question> query = em.createQuery("select q from Question q where q.surveyId="+id, Question.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public int addSurvey(Survey survey) {
		em.persist(survey);
		return survey.getSurveyId();
		
		// TODO Auto-generated method stub
//		return 0;
	}
	
	@Override
	public List<Survey> getAllSurvey(String createdBy) {
		TypedQuery<Survey> query = em.createQuery("select s from Survey s  where s.createdBy=" + createdBy, Survey.class);
		return query.getResultList();
	}
	
	@Override
	public Survey getSurvey(int surveyId) {
		TypedQuery<Survey> query = em.createQuery("select s from Survey s where s.surveyId="+ surveyId, Survey.class);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public Survey getSurveyById(int surveyId){
		return em.find(Survey.class, surveyId);
	}
}
