package com.example.DuplicateTradeObjectCreatorOne.RedisRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RedisTradeRepositoryForRedisList {

	   void addLeft(String redisTradeId);
	   void addRight(String redisTradeId);
	   String removeFromLeft();
	   String removeFromRight();
	   String getRedisTradeAtIndex(int index);
	   Long getCount();
	
}
