package com.example.DuplicateTradeObjectCreatorOne;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import com.example.DuplicateTradeObjectCreatorOne.RedisModel.*;

@Configuration
public class DuplicateTradeObjectCreatorOneConfig {

	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	
	@Bean(name="RedisTradeTemplateHash")
	 RedisTemplate<String, RedisTrade> redisTradeTemplateHash(){
		
		RedisTemplate<String, RedisTrade> redisTemplateHash=new RedisTemplate<String,RedisTrade>();
		redisTemplateHash.setConnectionFactory(jedisConnectionFactory());
		
		return redisTemplateHash;
	}
	
	
	@Bean(name="RedisCashSecurityTemplateHash")
	 RedisTemplate<String, RedisCashSecurity> redisCashSecurityTemplateHash(){
		
		RedisTemplate<String,RedisCashSecurity> redisCashSecurityTemplateHash=new RedisTemplate<String,RedisCashSecurity>();
		redisCashSecurityTemplateHash.setConnectionFactory(jedisConnectionFactory());
		
		return redisCashSecurityTemplateHash;
	}
	
	
	
	
	
	@Bean(name="RedisSourceErrorTemplateHash")
	 RedisTemplate<String, RedisSourceError> redisSourcedErrorTemplateHash(){
		
		RedisTemplate<String,RedisSourceError> redisSourceErrorTemplateHash=new RedisTemplate<String,RedisSourceError>();
		redisSourceErrorTemplateHash.setConnectionFactory(jedisConnectionFactory());
		
		return redisSourceErrorTemplateHash;
		
	}
	
	
	
	
	@Bean(name="redisTemplateList")
	 RedisTemplate<String, String> redisTemplateForList(){
		
		RedisTemplate<String, String> redisTemplateList=new RedisTemplate<String, String>();
		redisTemplateList.setConnectionFactory(jedisConnectionFactory());
		return redisTemplateList;
		
	}
	
	
	
	
}
