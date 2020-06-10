package com.ref.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ref.model.Firm;


public interface FirmRepository extends MongoRepository<Firm,String> {
	
}
