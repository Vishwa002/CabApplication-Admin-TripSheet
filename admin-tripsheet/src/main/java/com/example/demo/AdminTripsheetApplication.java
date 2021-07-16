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

				// Driver details
				DriverInfo driver1 = new DriverInfo(1, "Ravi", 68963210);
				driverRepo.save(driver1);

				DriverInfo driver2 = new DriverInfo(2, "Varun", 68963836);
				driverRepo.save(driver2);

				// Time Slot
				TimeSlot slot1 = new TimeSlot(1, LocalTime.of(20, 30));
				TimeSlot slot2 = new TimeSlot(2, LocalTime.of(22, 30));
				List<TimeSlot> slots1 = new ArrayList<TimeSlot>();
				slots1.addAll(Arrays.asList(slot1, slot2));

				TimeSlot slot3 = new TimeSlot(1, LocalTime.of(20, 30));
				TimeSlot slot4 = new TimeSlot(2, LocalTime.of(22, 30));
				List<TimeSlot> slots2 = new ArrayList<TimeSlot>();
				slots2.addAll(Arrays.asList(slot3, slot4));

				// Drop Point
				DropPoint drop1 = new DropPoint(1, "Medavakkam");
				DropPoint drop2 = new DropPoint(2, "Sembakkam");
				DropPoint drop3 = new DropPoint(3, "CampRoad");
				List<DropPoint> drops1 = new ArrayList<DropPoint>();
				drops1.addAll(Arrays.asList(drop1, drop2, drop3));

				DropPoint drop4 = new DropPoint(1, "Vellachery");
				DropPoint drop5 = new DropPoint(2, "Thoraipakkam");
				DropPoint drop6 = new DropPoint(3, "Perungudi");
				List<DropPoint> drops2 = new ArrayList<DropPoint>();
				drops2.addAll(Arrays.asList(drop4, drop5, drop6));

				// Destination
				Destination dest1 = new Destination(1, "Tambaram", drops1, slots1);
				destinationRepo.save(dest1);

				Destination dest2 = new Destination(2, "Vellachery", drops2, slots2);
				destinationRepo.save(dest2);

				// Employee Details
				Employee emp1 = new Employee(201, "Vishwa", 0);
				employeeRepo.save(emp1);
				Employee emp2 = new Employee(202, "Jerry", 0);
				employeeRepo.save(emp2);
				Employee emp3 = new Employee(203, "Gokul", 0);
				employeeRepo.save(emp3);
				Employee emp4 = new Employee(204, "Prakash", 0);
				employeeRepo.save(emp4);
				Employee emp5 = new Employee(205, "Rubin", 0);
				employeeRepo.save(emp5);
				Employee emp6 = new Employee(206, "Nishok ", 0);
				employeeRepo.save(emp6);
				Employee emp7 = new Employee(207, "Kishore ", 0);
				employeeRepo.save(emp7);

				// Trip Details
				TripCabInfo trip = new TripCabInfo(101, "TN24G9999", 1, "BayLine", "Tambaram", LocalDate.now(),
						LocalTime.of(9, 30), 7, 6, 1, "Yet to Start", null, null);
				tripRepo.save(trip);

				// BookingRequest Details
				BookingRequest request1 = new BookingRequest(901, 201, "Vishwa", "Alpla City", "Tambaram", "Medavakkam",
						LocalTime.of(8, 30), 0, 101, null, null, null, null, "Assigned", null, null, null, null, 0);
				BookingRequest request2 = new BookingRequest(902, 202, "Jerry", "Alpha City", "Tambaram", "Camp Road",
						LocalTime.of(8, 30), 0, 101, null, null, null, null, "Assigned", null, null, null, null, 0);
				BookingRequest request3 = new BookingRequest(903, 203, "Gokul", "Alpha City", "Tambaram", "Sembakkam",
						LocalTime.of(8, 30), 0, 101, null, null, null, null, "Assigned", null, null, null, null, 0);
				BookingRequest request4 = new BookingRequest(904, 204, "Prakash", "Alpha City", "Tambaram", "Koot Road",
						LocalTime.of(8, 30), 0, 101, null, null, null, null, "Assigned", null, null, null, null, 0);
				BookingRequest request5 = new BookingRequest(905, 205, "Rubin", "Alpha City", "Tambaram", "Camp Road",
						LocalTime.of(8, 30), 0, 101, null, null, null, null, "Assigned", null, null, null, null, 0);
				BookingRequest request6 = new BookingRequest(906, 206, "Nishok", "Alpha City", "Tambaram", "Medavakkam",
						LocalTime.of(8, 30), 0, 101, null, null, null, null, "Assigned", null, null, null, null, 0);
				bookingRepo.save(request1);
				bookingRepo.save(request2);
				bookingRepo.save(request3);
				bookingRepo.save(request4);
				bookingRepo.save(request5);
				bookingRepo.save(request6);

			}
		};
	}

}
