package com.example.demo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DropPoint {
	
	int dropPointId;
	String dropPoint;
//	String createdBy;
//	LocalDate createdDate;
//	String modifiedBy;
//	LocalDate modifiedDate;
//	int isDeleted;

}