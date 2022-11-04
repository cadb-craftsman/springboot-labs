package com.coursera.impatient.dao;

import java.util.List;

import com.coursera.impatient.model.Waiting;

public interface WaitingDao {
	
	public void insertWaiting(Waiting waiting);
	
	public void updateWaiting(Waiting waiting);

	public List<Waiting> getWaitingById(String userId);
	
	public void deleteWaitingById(String userId);
}
