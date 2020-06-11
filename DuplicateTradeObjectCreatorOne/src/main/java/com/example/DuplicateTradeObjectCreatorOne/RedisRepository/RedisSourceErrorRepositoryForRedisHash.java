package com.example.DuplicateTradeObjectCreatorOne.RedisRepository;

import java.util.Map;


import org.springframework.stereotype.Repository;
import com.example.DuplicateTradeObjectCreatorOne.RedisModel.*;

@Repository
public interface RedisSourceErrorRepositoryForRedisHash {

	Map<String,RedisSourceError> findAll();
	RedisSourceError findById(String id);
	void deleteById(String...ids);
	void add(String id,RedisSourceError redisSourceError);
	void update(String id,RedisSourceError redisSourceError);
	
	
}
