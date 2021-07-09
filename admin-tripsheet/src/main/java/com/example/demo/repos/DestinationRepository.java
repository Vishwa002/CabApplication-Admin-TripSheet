package com.example.demo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Destination;
@Repository
public interface DestinationRepository extends MongoRepository<Destination, Integer> {
	
	Destination  findByDestination(String destination);

}
