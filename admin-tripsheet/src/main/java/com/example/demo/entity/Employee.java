package com.example.demo.entity;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Document(collection = "Employee")

public class Employee {
	
	@Id
	int employeeId;
	String employeeName;
	
	
	
//	List<Destination> dropPoint;
//	LocalTime reachedTime;
//	String status;
	
//	String createdBy;
//	LocalDate createdDate;
//	String modifiedBy;
//	LocalDate modifiedDate;
//	int isDeleted;
	
	

}
