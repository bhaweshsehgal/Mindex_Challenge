package com.mindex.challenge.data;

import java.util.Date;

//import javax.persistence.Embedded;


public class Compensation {
//	private int employeeId;
	//@Embedded
	private Employee employee;
	private int salary;
	private Date effectiveDate;


	@Override
	public String toString() {
		return "Compensation [employee=" + employee + ", salary=" + salary + ", effectiveDate=" + effectiveDate + "]";
	}


	public Compensation() {
	}

	
//	public int getEmployeeId() {
//		return employeeId;
//	}
//
//
//	public void setEmployeeId(int employeeId) {
//		this.employeeId = employeeId;
//	}



	public Employee getEmployee() {
		//System.out.println("getting"+employee.getEmployeeId());
		return employee;
	}

	
	public void setEmployee(Employee employee) {
		//employee.getEmployeeId();
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
