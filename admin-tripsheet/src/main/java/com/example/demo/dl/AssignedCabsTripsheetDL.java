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

	public BookingRequest addEmployee(BookingRequest request, long tripCabId) {
		request.setBookingId(bookingRequestRepo.count() + 1);
		request.setTripCabId(tripCabId);
		request.setStatus("Assigned");
		BookingRequest req=this.bookingRequestRepo.save(request);
		
		Optional<TripCabInfo> info=this.tripCabInfoRepo.findById(request.getTripCabId());
		TripCabInfo trip=info.get();
		trip.setAllocatedSeats(trip.getAllocatedSeats()+1);
		trip.setRemainingSeats(trip.getRemainingSeats()-1);
		this.tripCabInfoRepo.save(trip);
		return req;
	}

	public boolean updateEmployee(BookingRequest request) {
		
		Optional<BookingRequest> req=this.bookingRequestRepo.findById(request.getBookingId());
		BookingRequest booking=req.get();
		booking.setDropPoint(request.getDropPoint());
		this.bookingRequestRepo.save(booking);
		
		return true;
	}

	public boolean deleteEmployee(long bookingId) {
		Optional<BookingRequest> req=this.bookingRequestRepo.findById(bookingId);
		BookingRequest booking=req.get();
		long tripCabId = booking.getTripCabId();
		
		Optional<TripCabInfo> info=this.tripCabInfoRepo.findById(tripCabId);
		TripCabInfo trip=info.get();
		trip.setAllocatedSeats(trip.getAllocatedSeats()-1);
		trip.setRemainingSeats(trip.getRemainingSeats()+1);
		this.tripCabInfoRepo.save(trip);
		
		booking.setStatus("Cancelled");
		this.bookingRequestRepo.save(booking);
		
		return true;
	}

	public Destination getDestination(String destination) {
		Destination dest= this.destinationRepo.findByDestination(destination);
		return dest;
	}

	public Employee getEmployeeId(String employeeName) {
		Employee emp=this.employeeRepo.findByEmployeeName(employeeName);
		return emp;
	}

	public TripCabInfo updateEndTime(long tripCabId) {
        Optional<TripCabInfo> trip=this.tripCabInfoRepo.findById(tripCabId);
        TripCabInfo trip1=trip.get();
        trip1.setEndTime(LocalTime.now());
        trip1.setStatus("Completed");
       return this.tripCabInfoRepo.save(trip1);
     
/*        List<BookingRequest> booking=this.bookingRequestRepo.findByTripCabId(tripCabId);
        for(BookingRequest eachRequest:booking) {
            eachRequest.setReachedTime(LocalTime.now());
            eachRequest.setStatus("Completed");
            this.bookingRequestRepo.save(eachRequest);
        }   */     
    }

	public BookingRequest updateReachedTime(long bookingId) {
		
		Optional<BookingRequest> request = this.bookingRequestRepo.findById(bookingId);
		BookingRequest updatedRequest = request.get();
		updatedRequest.setStatus("Reached");
		updatedRequest.setReachedTime(LocalTime.now());
		
		return this.bookingRequestRepo.save(updatedRequest);
	}

	public void updateCabStatus(long tripCabId) {
		
		Optional<TripCabInfo> cabInfo = this.tripCabInfoRepo.findById(tripCabId);
		TripCabInfo updatedCab = cabInfo.get();
		updatedCab.setStatus("On Progress");
		updatedCab.setStartTime(LocalTime.now());
		this.tripCabInfoRepo.save(updatedCab);
	}

	public void updateEmployeeStatus(long tripCabId, List<Integer> showList, List<Integer> noShowList) {
		
		for(int employeeId : showList) {
			
			BookingRequest request = this.bookingRequestRepo.findByTripCabIdAndEmployeeId(tripCabId, employeeId);
			request.setStatus("On Progress");
			this.bookingRequestRepo.save(request);
		}
		
         for(int employeeId : noShowList) {
			
			BookingRequest request = this.bookingRequestRepo.findByTripCabIdAndEmployeeId(tripCabId, employeeId);
			request.setStatus("NoShow");
			this.bookingRequestRepo.save(request);
		}
	}

	public List<Employee> getAllEmployeeDetails() {
		
		return this.employeeRepo.findAll();
	}

}
