package com.example.DuplicateTradeObjectCreatorOne;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.example.DuplicateTradeObjectCreatorOne.RedisRepository.*;


@Component
@ComponentScan(basePackages="com.example.DuplicateTradeObjectCreatorOne.RedisRepository")
public class CacheReader {
	
	@Autowired
	private ExceptionListMaker exceptionListMaker;
	
	@Autowired
	private RedisTradeRepositoryForRedisListImp redisTradeRepositoryForRedisList;
	
	@Autowired
	private RedisCashSecurityRepositoryForRedisHashImp redisCashSecurityRepositoryForRedisHash;
	
	@Autowired
	private  RedisTradeRepositoryForRedisHashImp redisTradeRepositoryForRedisHash;
	
	
	
	
	public  void startReadingFromCache() throws InterruptedException {
		
		ArrayList<String> tradeIdList=new ArrayList<String>();
		
			
			while(redisTradeRepositoryForRedisList.getCount()>0) {
				
				String tradeId=redisTradeRepositoryForRedisList.removeFromLeft();
				tradeIdList.add(tradeId);
				
			}	
			
			if(tradeIdList.size()>0) {
				
				System.out.println("calling exception list Maker");
				
				exceptionListMaker.makeExceptionList(tradeIdList);
				
				String[] tradeIdArray=new String[tradeIdList.size()];
				tradeIdList.toArray(tradeIdArray);
				
				redisTradeRepositoryForRedisHash.deleteById(tradeIdArray);
				
				redisCashSecurityRepositoryForRedisHash.deleteById(tradeIdArray);
				
				
			}
				
	}
	
}
