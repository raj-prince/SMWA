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
	public int addUser(User user) {
		em.persist(user);
		return user.getUserId();
	}
	
	@Override
	public List<User> getUsers() {
		TypedQuery<User> query = em.createQuery("from User", User.class);
		return query.getResultList();
	}
	
	
	
	@Override
	public void updateUser(User user) {
		em.merge(user);
	}

	@Override

	public User getUser(String username) {
		
		TypedQuery<User> query = em.createQuery("select u from User u where u.userName=:username", User.class);
		query.setParameter("username", username);
		//return em.find(User.class, username);
	   return query.getSingleResult();
	}
	public User getUserByName(String uname) {
		TypedQuery<User> query=em.createQuery("select u from User u where u.userName="+"'"+uname+"'",User.class);
		
		return query.getResultList().get(0);

	}

	@Override
	public User getUserById(int uid) {
		TypedQuery<User> query = em.createQuery("select u from User u where u.userId="+uid, User.class);
		return query.getSingleResult();
	}
}
