package com.adobe.prj.dao;

<<<<<<< HEAD
import java.util.List;

import com.adobe.prj.entity.User;

public interface UserDao {
	List<User> getUsers();
	int addUser(User user);
	User getUser(int userId);
	void updateUser(User user);
=======
import com.adobe.prj.entity.User;

public interface UserDao {
	int addUser(User user);
>>>>>>> 6d5d481a0670d1848d686de9eab7e4baa943a994
}
