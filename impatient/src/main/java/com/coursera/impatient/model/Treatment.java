package com.coursera.impatient.model;

public class Treatment {

	private int order;
	private String userId;
	private String drugName;
	private String description;

	public Treatment() {
		super();
	}

	public Treatment(int order, String userId, String drugName, String description) {
		super();
		this.order = order;
		this.userId = userId;
		this.drugName = drugName;
		this.description = description;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
