package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ReportingStructure reportingstructure;
	@Override
	public ReportingStructure getReportingStructure(String employeeId) {
		// TODO Auto-generated method stub
		int numberOfAllReportees=0;
		Employee emp = employeeRepository.findByEmployeeId(employeeId);
		
		List<List<Employee>> emplheirarchy = new ArrayList<List<Employee>>();
		emplheirarchy = calculateHeirarchy(employeeId, emp, emplheirarchy,numberOfAllReportees);
		for(List<Employee> e:emplheirarchy) {
			numberOfAllReportees+=e.size();
		}
		reportingstructure.setEmp(emplheirarchy);
		reportingstructure.setNumberOfReportees(numberOfAllReportees);
		return reportingstructure;
	}

	private List<List<Employee>> calculateHeirarchy(String employeeId,Employee emp,List<List<Employee>> emplheirarchy,
			int numberOfAllReportees) {
		// TODO Auto-generated method stub
		if(emp.getDirectReports()==null) {
			return emplheirarchy;
		}
		else {
			List<Employee> s=emp.getDirectReports();
			System.out.print("hey");
			numberOfAllReportees+=s.size();
			emplheirarchy.add(s);
			for(Employee emp1:s) {
				calculateHeirarchy(emp1.getEmployeeId(),employeeRepository.findByEmployeeId(emp1.getEmployeeId()),emplheirarchy,numberOfAllReportees);
			}
		}
		return emplheirarchy;
	}

}
