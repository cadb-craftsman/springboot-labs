package com.coursera.impatient.model;

import java.util.List;

public class TreatmentList {

	private List<Treatment> treatemntList;

	public TreatmentList() {
		super();		
	}

	public TreatmentList(List<Treatment> treatemntList) {
		super();
		this.treatemntList = treatemntList;
	}

	public List<Treatment> getTreatemntList() {
		return treatemntList;
	}

	public void setTreatemntList(List<Treatment> treatemntList) {
		this.treatemntList = treatemntList;
	}

}
