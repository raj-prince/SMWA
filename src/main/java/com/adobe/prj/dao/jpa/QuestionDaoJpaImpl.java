package com.adobe.prj.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.QuestionDao;
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
}
