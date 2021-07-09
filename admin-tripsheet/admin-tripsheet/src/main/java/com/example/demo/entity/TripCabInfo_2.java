package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class TripCabInfo_2 {
	
	long tripCabId;
	String cabNumber;
	DriverInfo driver;
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
	List<BookingRequest> bookingId;
//	List<HashMap<String, Object>> bookingRequest;
//	
//	HashMap<Integer, List<Object>> bookingRequest1;
}
