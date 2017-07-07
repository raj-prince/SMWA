package com.adobe.prj.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.QuestionDao;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Survey;

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

	@Override
	public Question getQuesById(int qid) {
		return em.find(Question.class, qid);

		
	}
}
