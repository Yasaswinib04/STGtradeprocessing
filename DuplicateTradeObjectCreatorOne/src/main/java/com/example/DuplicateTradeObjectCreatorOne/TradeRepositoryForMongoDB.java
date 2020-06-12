package com.example.DuplicateTradeObjectCreatorOne;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface TradeRepositoryForMongoDB extends MongoRepository<Trade, String>{

	@Query(collation = "en_US")
	public boolean existsByTradeId(String tradeId);
	
	
}
