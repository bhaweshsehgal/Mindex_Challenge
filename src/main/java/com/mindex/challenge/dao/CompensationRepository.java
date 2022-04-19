package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface CompensationRepository extends MongoRepository<Compensation, Employee> {
	
	@Query(value = "{'employee.employeeId': ?0 }", fields = "{'employee' : 0}")
	Compensation findByEmployeeId(String employeeId);
	
}
