package com.citi.stg.ExceptionListCreator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.citi.stg.ExceptionListCreator.RedisRepository.*;


@Component
@ComponentScan(basePackages="com.citi.stg.ExceptionListCreator.RedisRepository")
public class CacheReader {
	
	private static final Logger logger = LoggerFactory.getLogger(CacheReader.class);
	
	@Autowired
	private ExceptionListMaker exceptionListMaker;
	
	@Autowired
	private RedisTradeRepositoryForRedisListImp redisTradeRepositoryForRedisList;
	
	@Autowired
	private RedisCashSecurityRepositoryForRedisHashImp redisCashSecurityRepositoryForRedisHash;
	
	@Autowired
	private  RedisTradeRepositoryForRedisHashImp redisTradeRepositoryForRedisHash;
	
	/*
	 
	 The function below starts reading from cache either in chunks of 10 or the data accumulated in cache 
	 within period of 3 seconds
	 To maintain the order of data i have used a list in redis which will help me predict the order of data 
	 by storing the trade ids of data and my operation on redis list will be FIFO(First In First Out) just like 
	 a simple queue.
	 I am doing this we are inserting our object into HashSet of redis and once we insert our object into redis
	 hashset it will lose it's order then list will act as a pointer about what is key for my next data in 
	 redis

	 */
	
	
	public  void startReadingFromCache() throws InterruptedException {
		
		ArrayList<String> tradeIdList=new ArrayList<String>();
		
			//extracting data from redis list and storing it in a array list to send for further process
			while(redisTradeRepositoryForRedisList.getCount()>0) {
				
				String tradeId=redisTradeRepositoryForRedisList.removeFromLeft();
				tradeIdList.add(tradeId);
				
			}	
			
			if(tradeIdList.size()>0) {
				
				//System.out.println("calling exception list Maker");
				logger.info("calling exception list Maker");
				
				
				exceptionListMaker.makeExceptionList(tradeIdList);
			
				
		//Making string array of trade ids which are being processed to delete them from redis at once 		
				String[] tradeIdArray=new String[tradeIdList.size()];
				tradeIdList.toArray(tradeIdArray);
				
				redisTradeRepositoryForRedisHash.deleteById(tradeIdArray);
				
				redisCashSecurityRepositoryForRedisHash.deleteById(tradeIdArray);
				
				
			}
				
	}
	
}
