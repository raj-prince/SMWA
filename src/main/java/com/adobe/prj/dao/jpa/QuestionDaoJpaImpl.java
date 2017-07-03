package com.adobe.prj.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.QuestionDao;

@Repository
public class QuestionDaoJpaImpl implements QuestionDao {

	@PersistenceContext
	private EntityManager em;
}
