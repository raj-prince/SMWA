package com.adobe.prj.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.SurveyDao;

@Repository
public class SurveyDaoJpaImpl implements SurveyDao {
	@PersistenceContext
	private EntityManager em;
}
