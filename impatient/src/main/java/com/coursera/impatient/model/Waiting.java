package com.coursera.impatient.model;

public class Waiting {

	private int idList;
	private String date;
	private String hour;
	private String fullName;
	private String state;

	public Waiting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Waiting(int idList, String date, String hour, String fullName, String state) {
		super();
		this.idList = idList;
		this.date = date;
		this.hour = hour;
		this.fullName = fullName;
		this.state = state;
	}

	public int getIdList() {
		return idList;
	}

	public void setIdList(int idList) {
		this.idList = idList;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
