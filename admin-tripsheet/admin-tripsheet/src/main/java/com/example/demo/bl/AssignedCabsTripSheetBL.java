package com.example.demo.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dl.AssignedCabsTripsheetDL;
import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.Destination;
import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.Employee;
import com.example.demo.entity.TripCabInfo;

@Component

public class AssignedCabsTripSheetBL {

	@Autowired
	private AssignedCabsTripsheetDL tripSheetDl;
	
	// For getting Booking request
	public List<BookingRequest> getBookingRequests() {
		return this.tripSheetDl.getBookingRequests();
	}
	
//	public TripCabInfo getCabDetailsByCabNumber() {
//		
//		return this.tripSheetDl.getCabDetailsByCabNumber();
//		
//	}

	

	public TripCabInfo gettripCabId(long tripCabId) {
		// TODO Auto-generated method stub
		return this.tripSheetDl.gettripCabId(tripCabId);
	}

	public List<BookingRequest> getBookingRequests(long tripCabId) {
		
		return this.tripSheetDl.getBookingRequests(tripCabId);
	}

	public DriverInfo getDriverInfo(long driverId) {
		// TODO Auto-generated method stub
		return this.tripSheetDl.getDriverInfo(driverId);
	}

	public void updateStartTime(long tripCabId) {
		this.tripSheetDl.updateStartTime(tripCabId);
		
	}

	public Employee getEmployeeName(int employeeId) {
		
		return this.tripSheetDl.getEmployeeName(employeeId);
	}

	public BookingRequest addEmployee(BookingRequest request) {
		
		return this.tripSheetDl.addEmployee(request);
	}

	public BookingRequest updateEmployee(BookingRequest request) {
		
		return this.tripSheetDl.updateEmployee(request);
	}

	public BookingRequest deleteEmployee(int employeeId) {
		return this.tripSheetDl.deleteEmployee(employeeId);
	}

	public Destination getDestination(String destination) {
		
		return this.tripSheetDl.getDestination(destination);
	}
	
}
