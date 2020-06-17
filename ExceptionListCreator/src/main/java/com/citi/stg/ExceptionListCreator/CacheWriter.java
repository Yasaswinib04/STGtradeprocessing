package com.citi.stg.ExceptionListCreator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.citi.stg.ExceptionListCreator.RedisRepository.*;
import com.citi.stg.ExceptionListCreator.RedisModel.*;
import com.citi.stg.ExceptionListCreator.GenericTradeModel.*;

@Component
@ComponentScan(basePackages="com.citi.stg.ExceptionListCreator.RedisRepository")
public class CacheWriter{

	private static final Logger logger = LoggerFactory.getLogger(CacheWriter.class);
		
	@Autowired
	private RedisCashSecurityRepositoryForRedisHashImp redisCashSecurityRepositoryForRedisHash;
	
	@Autowired
	private  RedisTradeRepositoryForRedisHashImp redisTradeRepositoryForRedisHash;
	
	@Autowired
	private  RedisTradeRepositoryForRedisListImp redisTradeRepositoryForRedisList;
	
	
    /*extracting data from generic trade object and storing them into cache*/
	public void writeToCache(GenericTrade genericTrade){
		
		
		String tradeId=genericTrade.getTradeId();
		String firm=genericTrade.getFirm();
		String tradeDate=genericTrade.getDate();
		GenericSecurity genericSecurity=genericTrade.getGenericSecurity();
		
		
		
		RedisTrade redisTrade=new RedisTrade(tradeId,firm,tradeDate);
		RedisCashSecurity redisCashSecurity=new RedisCashSecurity(tradeId,genericSecurity.getSecurityType(),genericSecurity.getSecurityIdentifier());
		
		
		logger.info(redisTradeRepositoryForRedisList+" "+redisTradeRepositoryForRedisHash+" "+
			redisCashSecurityRepositoryForRedisHash);
		
		
    /*       System.out.println(redisTradeRepositoryForRedisList+" "+redisTradeRepositoryForRedisHash+" "+
			redisSourceErrorRepositoryForRedisHash+" "+redisCashSecurityRepositoryForRedisHash);
		
	*/	
		//writing data into redis cache
		redisTradeRepositoryForRedisList.addRight(tradeId);
		redisTradeRepositoryForRedisHash.add(tradeId, redisTrade);
		redisCashSecurityRepositoryForRedisHash.add(tradeId, redisCashSecurity);
			
	}
	

}
