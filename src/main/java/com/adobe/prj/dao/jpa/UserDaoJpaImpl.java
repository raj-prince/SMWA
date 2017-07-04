package com.adobe.prj.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.UserDao;
import com.adobe.prj.entity.User;

@Repository
public class UserDaoJpaImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int addUser(User user) {
		em.persist(user);
		return user.getUserId();
		//return 0;
	}
	
	
	
	
}
