package com.adobe.prj.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.UserDao;

@Repository
public class UserDaoJpaImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;
	
}
