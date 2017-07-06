package com.adobe.prj.service;

import java.util.List;

import com.adobe.prj.entity.User;

public interface UserService {
	List<User> getUsers();
	int addUser(User user);
	User getUser(String username);

}
