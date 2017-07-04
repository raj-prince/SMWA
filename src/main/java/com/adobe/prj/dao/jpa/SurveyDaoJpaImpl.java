package com.adobe.prj.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.SurveyDao;
import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Question;

@Repository
public class SurveyDaoJpaImpl implements SurveyDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Question> getQuestions() {
		TypedQuery<Question> query = em.createQuery("select c from Question c", Question.class);
		return query.getResultList();
	}
}
