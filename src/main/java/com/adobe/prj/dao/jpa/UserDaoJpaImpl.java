package com.adobe.prj.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.UserDao;
import com.adobe.prj.entity.User;

@Repository
public class UserDaoJpaImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> getUsers() {
		TypedQuery<User> query = em.createQuery("from User", User.class);
		return query.getResultList();
	}
	
	@Override
	public int addUser(User user) {
		em.persist(user);
		return user.getUserId();
	}
	
	@Override
	public User getUser(int userId) {
		return em.find(User.class, userId);
	}
	
	@Override
	public void updateUser(User user) {
		em.merge(user);
	}
}
