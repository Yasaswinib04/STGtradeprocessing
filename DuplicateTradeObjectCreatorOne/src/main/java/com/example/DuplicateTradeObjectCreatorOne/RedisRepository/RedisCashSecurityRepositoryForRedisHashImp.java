package com.example.DuplicateTradeObjectCreatorOne.RedisRepository;

import com.example.DuplicateTradeObjectCreatorOne.RedisModel.*;


import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;



@Component
@ComponentScan(basePackages="com.example.DuplicateTradeObjectCreatorOne")
public class RedisCashSecurityRepositoryForRedisHashImp implements RedisCashSecurityRepositoryForRedisHash{
	
	


	private static final String KEY="REDIS_CASH_SECURITY_HASH";
	
	
	@Resource(name="RedisCashSecurityTemplateHash")
	HashOperations<String, String, RedisCashSecurity> redisCashSecurityHashOps;
	
	
	
	@Override
	public Map<String, RedisCashSecurity> findAll() {
		
		return redisCashSecurityHashOps.entries(KEY);
		
	}

	@Override
	public RedisCashSecurity findById(String id) {
		
	return	redisCashSecurityHashOps.get(KEY, id);

		
	}

	@Override
	public void deleteById(String... ids) {
		
		redisCashSecurityHashOps.delete(KEY, (Object)ids);
	}

	@Override
	public void add(String id, RedisCashSecurity redisCashSecurity) {
		
		//System.out.println("writing cash security to cache");
		
		redisCashSecurityHashOps.put(KEY, id, redisCashSecurity);
		
	}

	@Override
	public void update(String id, RedisCashSecurity redisCashSecurity) {
		
		redisCashSecurityHashOps.put(KEY, id, redisCashSecurity);
		
	}

}
