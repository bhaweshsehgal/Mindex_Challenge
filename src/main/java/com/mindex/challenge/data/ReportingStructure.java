package com.mindex.challenge.data;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ReportingStructure {
	
	private List<List<Employee>> emp;
	private int numberOfReportees;
	

	public List<List<Employee>> getEmp() {
		return emp;
	}
	public void setEmp(List<List<Employee>> emp) {
		this.emp = emp;
	}
	public int getNumberOfReportees() {
		return numberOfReportees;
	}
	public void setNumberOfReportees(int numberOfReportees) {
		this.numberOfReportees = numberOfReportees;
	}
	
	

}
