package com.citi.stg.reference.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.citi.stg.reference.model.Firm;

//Firm Repository interface to store data to MongoDB
public interface FirmRepository extends MongoRepository<Firm,String> {
	
}
