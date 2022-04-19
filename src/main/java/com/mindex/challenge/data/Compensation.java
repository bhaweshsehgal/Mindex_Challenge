package com.mindex.challenge.data;

import java.util.Date;


public class Compensation {
	private Employee employee;
	private int salary;
	private Date effectiveDate;


	public Compensation() {
	}

	
	public Employee getEmployee() {
		//System.out.println("getting"+employee.getEmployeeId());
		return employee;
	}

	public void setEmployee(Employee employee) {
		//System.out.print(employee.getDepartment());
		this.employee = employee;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getEffectiveDate() {
		
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

}
