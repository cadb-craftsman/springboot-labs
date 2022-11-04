package com.coursera.impatient.dao;

import java.util.List;

import com.coursera.impatient.model.Treatment;

public interface TreatementDao {
	
	public void insertTreatment(Treatment treatment);
	
	public void updateTreatment(Treatment treatment);

	public List<Treatment> getTreatmentById(String userId);
	
	public void deleteTreatmentById(String userId);
}
