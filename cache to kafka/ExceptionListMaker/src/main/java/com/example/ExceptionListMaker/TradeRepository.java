package com.example.ExceptionListMaker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;


@Component
public interface TradeRepository extends MongoRepository<Trade, String>{
    
	
	@Query(collation = "en_US")
	public boolean existsByTradeId(String tradeId);
	
}
