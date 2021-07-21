package com.example.demo.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookingRequest;

@Repository
public interface BookingRequestRepository extends MongoRepository<BookingRequest,Long> {

	
	
	@Query(value = "{tripCabId:?0,status:{$nin:[Cancelled, NoShow]}}")
	List<BookingRequest> getBookingRequestByTripCabId(long tripCabId);
	
	
	List<BookingRequest> findByTripCabId(long tripCabId);
	
	@Query(value = "{newEmp : ?0, tripCabId : ?1}")
	BookingRequest saveByTripCabId(BookingRequest newEmp, long tripCabId);

	
	


	BookingRequest findByTripCabIdAndEmployeeId(long tripCabId, String employeeId);
}
