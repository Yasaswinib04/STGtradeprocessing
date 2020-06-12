package com.ref.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ref.model.Firm;

//Firm Repository interface to store data to MongoDB
public interface FirmRepository extends MongoRepository<Firm,String> {
	
}
