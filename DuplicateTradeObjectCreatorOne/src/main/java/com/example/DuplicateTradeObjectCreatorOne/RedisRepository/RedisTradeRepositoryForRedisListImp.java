package com.example.DuplicateTradeObjectCreatorOne.RedisRepository;

import javax.annotation.Resource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages="com.example.DuplicateTradeObjectCreatorOne")
public class RedisTradeRepositoryForRedisListImp implements RedisTradeRepositoryForRedisList{

	private static final String KEY="REDIS_LIST";
	
	@Resource(name="redisTemplateList")
	private ListOperations<String, String> listOps;
	
	
	
	@Override
	public void addLeft(String redisTradeId) {
		
		listOps.leftPush(KEY,redisTradeId);
	}

	@Override
	public void addRight(String redisTradeId) {
		
		listOps.rightPush(KEY, redisTradeId);
	}

	@Override
	public String removeFromLeft() {
		
		return listOps.leftPop(KEY);
	}

	@Override
	public String removeFromRight() {
		
		return listOps.rightPop(KEY);
	}

	@Override
	public String getRedisTradeAtIndex(int index) {
		
		return listOps.index(KEY, index);
	}

	@Override
	public Long getCount() {
		
		return listOps.size(KEY);
	}
	
}
