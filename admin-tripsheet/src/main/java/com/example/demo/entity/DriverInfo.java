package com.example.demo.entity;

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


@Document(collection = "DriverInfo")

public class DriverInfo {
	@Id
	long driverId;
	String driverName;
	long driverNumber;
//	String createdBy;
//	LocalDate createdDate;
//	String modifiedBy;
//	LocalDate modifiedDate;
//	int isDeleted;

}
