package com.example.demo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	Employee findByEmployeeName(String empoyeeName);

}
