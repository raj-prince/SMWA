package com.adobe.prj.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.QuestionDao;
import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Question;

@Repository
public class QuestionDaoJpaImpl implements QuestionDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int addQuestion(Question question) {
		em.persist(question);
		return question.getQuestionId();
//		return 0;
	}
	
	@Override
	public List<Question> getQuestions(int surveyId) {
		TypedQuery<Question> query = em.createQuery("select q from Question q where q.surveyId=" + surveyId, Question.class);
		return query.getResultList();
	}
}
