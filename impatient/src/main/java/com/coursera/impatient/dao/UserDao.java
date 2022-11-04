package com.coursera.impatient.dao;

import com.coursera.impatient.model.User;

public interface UserDao {
	
	public void insertUser(User user);
	
	public void updateUser(User user);

	public User getUserById(String userId);
	
	public void deleteUserById(String userId);
}
