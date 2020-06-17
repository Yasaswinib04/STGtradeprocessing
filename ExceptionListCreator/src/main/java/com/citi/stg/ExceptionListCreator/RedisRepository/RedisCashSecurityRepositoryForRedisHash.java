package com.citi.stg.ExceptionListCreator.RedisRepository;

import java.util.Map;

import org.springframework.stereotype.Repository;
import com.citi.stg.ExceptionListCreator.RedisModel.*;


@Repository
public interface RedisCashSecurityRepositoryForRedisHash {

	Map<String,RedisCashSecurity> findAll();
	RedisCashSecurity findById(String id);
	void deleteById(String...ids);
	void add(String id,RedisCashSecurity redisCashSecurity);
	void update(String id,RedisCashSecurity redisCashSecurity);
	
	
}
