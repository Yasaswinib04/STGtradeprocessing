package com.example.DuplicateTradeObjectCreatorOne.RedisRepository;

import java.util.Map;

import javax.annotation.Resource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import com.example.DuplicateTradeObjectCreatorOne.RedisModel.*;

@Component
@ComponentScan(basePackages="com.example.DuplicateTradeObjectCreatorOne")
public class RedisTradeRepositoryForRedisHashImp implements RedisTradeRepositoryForRedisHash{

	private static final String KEY="REDIS_TRADE_HASH";
	
	@Resource(name="RedisTradeTemplateHash")
	HashOperations<String, String, RedisTrade> redisTradeHashOps;
	
	@Override
	public Map<String, RedisTrade> findAll() {
		
		return redisTradeHashOps.entries(KEY);
		
	}

	@Override
	public RedisTrade findById(String id) {
		return redisTradeHashOps.get(KEY, id);
	}

	@Override
	public void deleteById(String... ids) {
		redisTradeHashOps.delete(KEY, (Object)ids);
		
	}

	@Override
	public void add(String id, RedisTrade redisTrade) {
	
		redisTradeHashOps.putIfAbsent(KEY, id, redisTrade);
	}

	@Override
	public void update(String id, RedisTrade redisTrade) {
		
		redisTradeHashOps.put(KEY, id, redisTrade);
	}
	
	
}
