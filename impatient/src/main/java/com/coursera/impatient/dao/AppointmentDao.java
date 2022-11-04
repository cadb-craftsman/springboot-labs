package com.coursera.impatient.dao;

import com.coursera.impatient.model.UserDate;

public interface AppointmentDao {
	
	public void insertAppointment(UserDate userDate);
	
	public void updateAppointment(UserDate userDate);

	public UserDate getAppointmentById(String userId);
	
	public void deleteAppointmentById(String userId);
}
