package com.adobe.prj.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.ResponseDao;

@Repository
public class ResponseDaoJpaImpl implements ResponseDao {

	@PersistenceContext
	private EntityManager em;
}
