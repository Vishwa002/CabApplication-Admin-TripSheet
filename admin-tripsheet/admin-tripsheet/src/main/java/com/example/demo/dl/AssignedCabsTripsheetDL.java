package com.example.demo.dl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.Destination;
import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.Employee;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repos.BookingRequestRepository;
import com.example.demo.repos.DestinationRepository;
import com.example.demo.repos.DriverInfoRepository;
import com.example.demo.repos.EmployeeRepository;
import com.example.demo.repos.TripCabInfoRepository;

@Service(value = "AssignedCabsTripsheetService")
public class AssignedCabsTripsheetDL {

	@Autowired
	private TripCabInfoRepository tripCabInfoRepo;

	@Autowired
	private DestinationRepository destinationRepo;

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private BookingRequestRepository bookingRequestRepo;
	
	@Autowired
	private DriverInfoRepository driverRepo;

	// For getting Booking request
	public List<BookingRequest> getBookingRequests() {
		return this.bookingRequestRepo.findAll();
	}

//	// For editing Booking Request
//	public BookingRequest editBookingRequest(BookingRequest request) {
//		request.setBookingId(bookingRequestRepo.count() + 1);
//
//		request.setStatus("No Show");
//		// request.setDropPoint();
//		return this.bookingRequestRepo.save(request);
//
//	}

	
	public TripCabInfo gettripCabId(long tripCabId) {
		// TODO Auto-generated method stub
		Optional<TripCabInfo> trip= this.tripCabInfoRepo.findById(tripCabId);
		TripCabInfo trip1=trip.get();
		return trip1;
		 
	}

	public List<BookingRequest> getBookingRequests(long tripCabId) {
		
		return this.bookingRequestRepo.getBookingRequestByTripCabId(tripCabId);
	}

	public DriverInfo getDriverInfo(long driverId) {
		Optional<DriverInfo> driver=this.driverRepo.findById(driverId);
		DriverInfo driver1=driver.get();
		return driver1;
	}

	public void updateStartTime(long tripCabId) {
		Optional<TripCabInfo> trip=this.tripCabInfoRepo.findById(tripCabId);
		TripCabInfo trip1=trip.get();
		trip1.setStartTime(LocalTime.now());
		trip1.setStatus("Ongoing");
		this.tripCabInfoRepo.save(trip1);
		
		
		List<BookingRequest> booking=this.bookingRequestRepo.findByTripCabId(tripCabId);
		for(BookingRequest eachRequest:booking) {
			eachRequest.setStartTime(LocalTime.now());
			eachRequest.setStatus("Ongoing");
			this.bookingRequestRepo.save(eachRequest);
		}
	}

	public Employee getEmployeeName(int employeeId) {

		Optional<Employee> emp=this.employeeRepo.findById(employeeId);
		return emp.get();
	}

	public BookingRequest addEmployee(BookingRequest request) {
		BookingRequest req=this.bookingRequestRepo.save(request);
		Optional<TripCabInfo> info=this.tripCabInfoRepo.findById(request.getTripCabId());
		TripCabInfo trip=info.get();
		trip.setAllocatedSeats(trip.getAllocatedSeats()+1);
		trip.setRemainingSeats(trip.getRemainingSeats()-1);
		this.tripCabInfoRepo.save(trip);
		return req;
	}

	public BookingRequest updateEmployee(BookingRequest request) {
		Optional<BookingRequest> req=this.bookingRequestRepo.findById(request.getEmployeeId());
		BookingRequest booking=req.get();
		booking.setDropPoint(request.getDropPoint());
		
		return this.bookingRequestRepo.save(booking);
	}

	public BookingRequest deleteEmployee(int employeeId) {
		Optional<BookingRequest> req=this.bookingRequestRepo.findById(employeeId);
		BookingRequest booking=req.get();
		booking.setStatus("Cancelled");
		
		return this.bookingRequestRepo.save(booking);
	}

	public Destination getDestination(String destination) {
		Destination dest= this.destinationRepo.findByDestination(destination);
		return dest;
	}


}
