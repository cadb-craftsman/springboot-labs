package com.coursera.impatient.model;

public class UserLogin {

	private String username;
	private String password;
	private String userId;
	private int userRole;

	public UserLogin() {

	}

	public UserLogin(String username, String password, String userId, int userRole) {
		super();
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.userRole = userRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
}
