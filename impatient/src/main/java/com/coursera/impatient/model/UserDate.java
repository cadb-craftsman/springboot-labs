package com.coursera.impatient.model;

public class UserDate {

	private String date;
	private String hour;
	private String userId;
	private String doctorName;
	private boolean remember;

	public UserDate() {
		super();
	}

	public UserDate(String date, String hour, String userId, String doctorName, boolean remember) {
		super();
		this.date = date;
		this.hour = hour;
		this.userId = userId;
		this.doctorName = doctorName;
		this.remember = remember;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

}
