package com.mindex.challenge.data;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ReportingStructure {
	
	private List<Employee> emp;
	private int numberOfReportees;
	

	@Override
	public String toString() {
		return "ReportingStructure [emp=" + emp + ", numberOfReportees=" + numberOfReportees + "]";
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emplheirarchy) {
		this.emp = emplheirarchy;
	}
	public int getNumberOfReportees() {
		return numberOfReportees;
	}
	public void setNumberOfReportees(int numberOfReportees) {
		this.numberOfReportees = numberOfReportees;
	}
	
	

}
