package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;
 
    // this function will insert the compensation into repository
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating employee [{}]", compensation);
        System.out.println(compensation.getEmployee());
        //compensationRepository.insert(compensation);
        compensationRepository.save(compensation);
      //  employeeRepository.insert(compensation.getEmployee());
//        System.out.print(compensation.getEmployee().getEmployeeId());
        return compensation;
    }

    // this function will read the compensation which we have inserted from mongorepository
    @Override
    public Compensation read(String id) {
        LOG.debug("Reading employee with id [{}]", id);
        Compensation compensation = compensationRepository.findByEmployeeId(id);
		 if (compensation == null) { throw new RuntimeException("Invalid employeeId: "
		 + id); }
		 //the below lambda function is use to get compensation for the particular employeeID
		 return compensationRepository.findAll().stream().filter((e)->e.getEmployee().getEmployeeId().equals(id)).findFirst().get(); 
    }

}
