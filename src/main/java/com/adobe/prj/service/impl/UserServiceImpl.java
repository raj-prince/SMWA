package com.adobe.prj.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.UserDao;
import com.adobe.prj.entity.User;
import com.adobe.prj.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	public int addUser(User user) {
		return userDao.addUser(user);
	}
}
