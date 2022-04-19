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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
		
		List<Employee> emplheirarchy = new ArrayList<Employee>();
		Set<String> id=new HashSet<String>();
		id = calculateHeirarchy(employeeId, emp,id);
		for(String s:id) {
			emplheirarchy.add(employeeRepository.findByEmployeeId(s));
		}
		numberOfAllReportees=id.size();
		reportingstructure.setEmp(emplheirarchy);
		reportingstructure.setNumberOfReportees(numberOfAllReportees);
		return reportingstructure;
	}
// the below function will use backtracking concepts to return all the reporting structure ID which belongs to particular employee and using those id 
// we are going to find out size of reporting structure and the those employees structure.
	private Set<String> calculateHeirarchy(String employeeId,Employee emp,
			Set<String> id) {
		// TODO Auto-generated method stub
		if(emp.getDirectReports()==null) {
			return id;
		}
		else {
			List<Employee> s=new ArrayList<Employee>();
			for(Employee e:emp.getDirectReports()) {
				id.add(e.getEmployeeId());
				s.add(employeeRepository.findByEmployeeId(e.getEmployeeId()));
			}
			for(Employee emp1:s) {
				id= calculateHeirarchy(emp1.getEmployeeId(),employeeRepository.findByEmployeeId(emp1.getEmployeeId()),id);
			}
		}
		return id;
	}

}
