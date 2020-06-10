package com.acknackgen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.acknackgen.model.cache.Firm;

public interface FirmRepository extends MongoRepository<Firm,String> {
	
	Firm findByFirmCode(String firmCode);
}
