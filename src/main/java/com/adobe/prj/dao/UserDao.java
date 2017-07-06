package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.User;

public interface UserDao {
	List<User> getUsers();
	int addUser(User user);
	User getUser(String username);
	void updateUser(User user);
}
