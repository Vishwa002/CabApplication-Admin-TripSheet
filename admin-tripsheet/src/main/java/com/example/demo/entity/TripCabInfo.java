package com.example.demo.entity;


import java.time.LocalDate;
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

@Document(collection = "TripCabInfo")

public class TripCabInfo {
	@Id
	long tripCabId;
	String cabNumber;
	long driverId;
	String source;
	String destination;
	LocalDate dateOfTravel;
	LocalTime timeSlot;
	int totalSeats;
	int allocatedSeats;
	int remainingSeats;
	String status;
	LocalTime startTime;
	LocalTime endTime;
	//List<BookingRequest> bookingId;
	
//	String createdBy;
//	LocalDate createdDate;
//	String modifiedBy;
//	LocalDate modifiedDate;
//	int isDeleted;
	

}
