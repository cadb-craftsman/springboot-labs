package com.coursera.impatient.model;

import java.util.List;

public class WaitingList {

	private String date;
	private List<Waiting> waitingList;

	public WaitingList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WaitingList(String date, List<Waiting> waitingList) {
		super();
		this.date = date;
		this.waitingList = waitingList;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Waiting> getWaitingList() {
		return waitingList;
	}

	public void setWaitingList(List<Waiting> waitingList) {
		this.waitingList = waitingList;
	}

}
