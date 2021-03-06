package com.citi.stg.acknackgen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.citi.stg.acknackgen.model.cache.Firm;

//Repository Interface responsible for Communication with MongoDB 
public interface FirmRepository extends MongoRepository<Firm,String> {
	
	//Method to search Database for firm using firmCode
	Firm findByFirmCode(String firmCode);
}
