package com.example.DuplicateTradeObjectCreatorOne.RedisRepository;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import com.example.DuplicateTradeObjectCreatorOne.RedisModel.*;

@Component
@ComponentScan(basePackages="com.example.DuplicateTradeObjectCreatorOne")
public class RedisSourceErrorRepositoryForRedisHashImp implements RedisSourceErrorRepositoryForRedisHash {

	
	private static final String KEY="REDIS_SOURCE_ERROR_HASH";
	
	@Resource(name="RedisSourceErrorTemplateHash")
	HashOperations<String, String, RedisSourceError> redisSourceErrorHashOps;
	
	
	@Override
	public Map<String, RedisSourceError> findAll() {
		
		return redisSourceErrorHashOps.entries(KEY);
	}

	@Override
	public RedisSourceError findById(String id) {
		
		return redisSourceErrorHashOps.get(KEY, id);
	}

	@Override
	public void deleteById(String... ids) {
		
		redisSourceErrorHashOps.delete(KEY, (Object)ids);
		
	}

	@Override
	public void add(String id, RedisSourceError redisSourceError) {
		redisSourceErrorHashOps.putIfAbsent(KEY, id, redisSourceError);
		
	}

	@Override
	public void update(String id, RedisSourceError redisSourceError) {
		
		redisSourceErrorHashOps.put(KEY, id, redisSourceError);
	}

}
