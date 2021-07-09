package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bl.AssignedCabsTripSheetBL;

import com.example.demo.dl.AssignedCabsTripsheetDL;
import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.Destination;
import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.Employee;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.entity.TripCabInfo_2;

@RestController
@RequestMapping(path="/api/v1/")
public class AssignedCabsTripSheetController {
	
	@Autowired
	private AssignedCabsTripSheetBL tripSheetBl;

	
	
	
	
	
	//get cab details and employee details
	@GetMapping(path = "/tripsheet/{tripCabId}")
	public ResponseEntity<TripCabInfo_2> gettripCabId(@PathVariable ("tripCabId" ) long tripCabId){
		TripCabInfo cab= this.tripSheetBl.gettripCabId(tripCabId);
		
		List<BookingRequest> booking=this.tripSheetBl.getBookingRequests(tripCabId);
		
		DriverInfo driver=this.tripSheetBl.getDriverInfo(cab.getDriverId());
		
		TripCabInfo_2 cab2=new  TripCabInfo_2(tripCabId, cab.getCabNumber() , driver , cab.getSource() , cab.getDestination(), cab.getDateOfTravel(), cab.getTimeSlot() , cab.getTotalSeats(), cab.getAllocatedSeats(), cab.getRemainingSeats(), cab.getStatus(), cab.getStartTime(), cab.getEndTime(), booking);
		
		if(cab2.getStartTime()==null)
		{
			return ResponseEntity.status(232).body(cab2);
		}
		return ResponseEntity.status(HttpStatus.OK).body(cab2);
	}
	
	
	//startTime
	@PutMapping(path= "/tripsheet/starttime/{tripCabId}")
	public void updateStartTime(@PathVariable ("tripCabId" ) long tripCabId)
	{
		this.tripSheetBl.updateStartTime(tripCabId);
	}
	

	//get employee name
	
	@GetMapping(path = "/tripsheet/employee/{employeeId}")
	public ResponseEntity<Employee> getEmployeeName(@PathVariable ("employeeId") int employeeId)
	{
		Employee emp=this.tripSheetBl.getEmployeeName(employeeId);
		
		return ResponseEntity.status(HttpStatus.OK).body(emp);
		
	}
	
	
	//add new employee
	@PostMapping(path = "/tripsheet/addemployee")
	public ResponseEntity<BookingRequest> addEmployee(@RequestBody BookingRequest request)
	{
		BookingRequest req=this.tripSheetBl.addEmployee(request);
		
		return ResponseEntity.status(HttpStatus.OK).body(req);
				
	}
	
	//update drop point
	
	@PutMapping(path = "/tripsheet/update/droppoint")
	public ResponseEntity<BookingRequest> updateEmployee(@RequestBody BookingRequest request)
	{
		BookingRequest req=this.tripSheetBl.updateEmployee(request);
		
		return ResponseEntity.status(HttpStatus.OK).body(req);
				
	}
	
	//delete employee
	@PutMapping(path= "/tripsheet/delete/employee/{employeeId}")
	public ResponseEntity<BookingRequest> deleteEmployee(@PathVariable ("employeeId") int employeeId)
	{
		BookingRequest req=this.tripSheetBl.deleteEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(req);
	}
	
	//get drop points
	@GetMapping(path = "/tripsheet/droppoints/{destination}")
	public ResponseEntity<Destination> getDestination(@PathVariable ("destination") String destination)
	{
		Destination dest=this.tripSheetBl.getDestination(destination);
		return ResponseEntity.status(HttpStatus.OK).body(dest);
	}
	
	
	
	
	
	
	
	
	
	
}
