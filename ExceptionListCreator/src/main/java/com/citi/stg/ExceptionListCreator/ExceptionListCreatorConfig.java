package com.citi.stg.ExceptionListCreator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.citi.stg.ExceptionListCreator.RedisModel.*;

@Configuration
public class ExceptionListCreatorConfig {

	//creates bean for autowiring our redis template wherever we want
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
	
	@Bean(name="redisTemplateList")
	 RedisTemplate<String, String> redisTemplateForList(){
		
		RedisTemplate<String, String> redisTemplateList=new RedisTemplate<String, String>();
		redisTemplateList.setConnectionFactory(jedisConnectionFactory());
		return redisTemplateList;
		
	}
	
	
	
	
}
