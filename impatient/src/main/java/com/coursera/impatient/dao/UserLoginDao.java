package com.coursera.impatient.dao;

import com.coursera.impatient.model.UserLogin;

public interface UserLoginDao {
	
	public void insertUserLogin(UserLogin userLogin);
	
	public void updateUserLogin(UserLogin userLogin);

	public UserLogin getUserLoginById(String username, String password);
	
	public void deleteUserLoginById(String username);
}
