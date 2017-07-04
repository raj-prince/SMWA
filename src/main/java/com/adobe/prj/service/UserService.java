package com.adobe.prj.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.UserDao;

import com.adobe.prj.entity.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public int addUser(User user) {
		return userDao.addUser(user);
	}

}
