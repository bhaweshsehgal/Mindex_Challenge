package com.mindex.challenge;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.impl.CompensationServiceImpl;
import com.mindex.challenge.service.impl.ReportingStructureServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBootstrapTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private CompensationServiceImpl compensationServiceImpl;
    
    @Autowired 
    private ReportingStructureServiceImpl reportingStructureServiceImpl;

    @Test
    public void test() {
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());
    }
    
    @Test
    public void testRepotingStructure() {
    	
    	assertEquals(reportingStructureServiceImpl.getReportingStructure("16a596ae-edd3-4847-99fe-c4518e82c86f").getNumberOfReportees(),4);
    	assertEquals(reportingStructureServiceImpl.getReportingStructure("03aa1462-ffa9-4978-901b-7c001562cf6f").getNumberOfReportees(),2);
    	assertEquals(reportingStructureServiceImpl.getReportingStructure("62c1084e-6e34-4630-93fd-9153afb65309").getNumberOfReportees(),0);
    }
    
    @Test
    public void testCompensation() {
    	Compensation c=new Compensation();
    	Employee e=new Employee();
    	Date d=new Date();
    	d.setDate(20);
    	e.setEmployeeId("1");
    	e.setFirstName("Sam");
    	e.setLastName("Gupta");
    	e.setPosition("DEV II");
    	e.setDepartment("Development");
    	e.setDirectReports(null);
    	c.setEmployee(e);
    	c.setSalary(200000);
    	c.setEffectiveDate(d);
    	compensationServiceImpl.create(c);
    	//System.out.println(compensationRepository.findByEmployeeId("1").getEmployee().getLastName());
    	assertEquals(compensationServiceImpl.read("1").getSalary(),200000);	
    	assertEquals(compensationServiceImpl.read("1").getEmployee().getFirstName(),"Sam");
        assertEquals(compensationServiceImpl.read("1").getEmployee().getLastName(),"Gupta");	
        assertEquals(compensationServiceImpl.read("1").getEmployee().getDepartment(),"Development");
        assertEquals(compensationServiceImpl.read("1").getEmployee().getPosition(),"DEV II");
    }
}