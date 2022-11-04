package com.coursera.impatient.dao;

import com.coursera.impatient.model.CheckIn;

public interface CheckInDao {
	
	public void insertCheckIn(CheckIn checkIn);
	
	public void updateCheckIn(CheckIn checkIn);

	public CheckIn getCheckInById(String userId);
	
	public void deleteCheckInById(String userId);
}
