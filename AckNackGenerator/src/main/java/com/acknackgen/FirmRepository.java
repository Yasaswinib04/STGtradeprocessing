package com.acknackgen;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.acknackgen.Firm;

public interface FirmRepository extends MongoRepository<Firm,String> {
	
	Firm findByFirmCode(String firmCode);
}
