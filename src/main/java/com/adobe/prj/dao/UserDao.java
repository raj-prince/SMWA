package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.User;

public interface UserDao {
	List<User> getUsers();
	int addUser(User user);
	User getUser(int userId);
	void updateUser(User user);
}
