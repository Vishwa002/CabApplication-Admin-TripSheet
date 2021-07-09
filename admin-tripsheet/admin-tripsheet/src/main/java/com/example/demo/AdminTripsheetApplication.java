package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.Destination;
import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.DropPoint;
import com.example.demo.entity.Employee;
import com.example.demo.entity.TimeSlot;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repos.BookingRequestRepository;
import com.example.demo.repos.DestinationRepository;
import com.example.demo.repos.DriverInfoRepository;
import com.example.demo.repos.EmployeeRepository;
import com.example.demo.repos.TripCabInfoRepository;

@SpringBootApplication

@EnableMongoRepositories
public class AdminTripsheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminTripsheetApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			TripCabInfoRepository tripRepo;
			@Autowired
			BookingRequestRepository bookingRepo;
			@Autowired
			DriverInfoRepository driverRepo;
			@Autowired
			EmployeeRepository employeeRepo;
			@Autowired
			DestinationRepository destinationRepo;
			
			@Override
			public void run(String... args) throws Exception {
				
				DriverInfo driver=new DriverInfo(1, "Ravi", 68963210);
				driverRepo.save(driver);
				
				TimeSlot slot1=new TimeSlot(1, LocalTime.of(20, 30));
				TimeSlot slot2=new TimeSlot(2, LocalTime.of(22, 30));
				List<TimeSlot> slots=new ArrayList<TimeSlot>();
				slots.addAll(Arrays.asList(slot1,slot2));
				
				DropPoint drop1=new DropPoint(1, "Medavakkam");
				DropPoint drop2=new DropPoint(2, "Sembakkam");
				DropPoint drop3=new DropPoint(3, "CampRoad");
				List<DropPoint> drops=new ArrayList<DropPoint>();
				drops.addAll(Arrays.asList(drop1,drop2,drop3));
				
				
				Destination dest=new Destination(1, "Tambaram", drops, slots);
				destinationRepo.save(dest);
				
				
				
//				List<Employee> emp=new ArrayList<Employee>();
//				Employee emp1=new 	Employee(201, "Vishwa");
//				//employeeRepo.save(emp1);
//				Employee emp2=new 	Employee(202, "Prakash");
//				//employeeRepo.save(emp2);
//				Employee emp3=new 	Employee(203, "Gokul");
//				//employeeRepo.save(emp3);
//				Employee emp4=new 	Employee(204, "Rubin");
//				//employeeRepo.save(emp4);
//				Employee emp5=new 	Employee(205, "Vignesh");
//				//employeeRepo.save(emp5);
//				emp.addAll(Arrays.asList(emp1,emp2,emp3,emp4,emp5));
				
				TripCabInfo trip=new TripCabInfo(101, "TN24G9999", 1,"BayLine"  , "Tambaram", LocalDate.now(), LocalTime.of(9, 30), 7, 5, 2, "Yet to Start", null,null);
				tripRepo.save(trip);
				
				BookingRequest request1=new BookingRequest(901, 301, "Vishwa","BayLine", "Tambaram","Medavakkam", LocalTime.of(8, 30),0, 101, null, null ,null, null, null, null, null, null, null, 0);
				BookingRequest request2=new BookingRequest(902, 302, "Jerry","Alpha City", "Tambaram","Camp Road", LocalTime.of(8, 30),0, 101, null, null ,null, null, null, null, null, null, null, 0);
				BookingRequest request3=new BookingRequest(903, 303, "Gokul","BayLine", "Tambaram","Sembakkam", LocalTime.of(8, 30),0, 101, null, null ,null, null, null, null, null, null, null, 0);
				BookingRequest request4=new BookingRequest(904, 304, "Prakash","Alpha City", "Tambaram","Koot Road", LocalTime.of(8, 30),0, 101, null, null ,null, null, null, null, null, null, null, 0);
				BookingRequest request5=new BookingRequest(905, 305, "Rubin","Alpha City", "Tambaram","Camp Road", LocalTime.of(8, 30),0, 101, null, null ,null, null, null, null, null, null, null, 0);

//				List<BookingRequest> request= new ArrayList<BookingRequest>();
//				request.addAll(Arrays.asList(request1,request2));
				
				
				bookingRepo.save(request1);
				bookingRepo.save(request2);
				bookingRepo.save(request3);
				bookingRepo.save(request4);
				bookingRepo.save(request5);
				
				
				
				
				
				
			}
		};
	}
	
}
