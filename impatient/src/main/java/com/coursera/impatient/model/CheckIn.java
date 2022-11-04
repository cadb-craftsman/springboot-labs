package com.coursera.impatient.model;

public class CheckIn {

	private int checkInId;
	private String userId;
	private String fullName;
	private String date;
	private String hour;

	public CheckIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckIn(int checkInId, String userId, String fullName, String date, String hour) {
		super();
		this.checkInId = checkInId;
		this.userId = userId;
		this.fullName = fullName;
		this.date = date;
		this.hour = hour;
	}

	public int getCheckInId() {
		return checkInId;
	}

	public void setCheckInId(int checkInId) {
		this.checkInId = checkInId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

}
