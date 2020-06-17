package com.citi.stg.ExceptionListCreator.RedisRepository;

import java.util.Map;
import org.springframework.stereotype.Repository;
import com.citi.stg.ExceptionListCreator.RedisModel.*;

@Repository
public interface RedisTradeRepositoryForRedisHash {

	Map<String,RedisTrade> findAll();
	RedisTrade findById(String id);
	void deleteById(String...ids);
	void add(String id,RedisTrade redisTrade);
	void update(String id,RedisTrade redisTrade);
	
	
}
