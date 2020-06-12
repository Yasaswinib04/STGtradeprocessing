package com.example.DuplicateTradeObjectCreatorOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.example.DuplicateTradeObjectCreatorOne.GenericTradeModel.GenericSecurity;
import com.example.DuplicateTradeObjectCreatorOne.GenericTradeModel.GenericTrade;
import com.example.DuplicateTradeObjectCreatorOne.RedisModel.*;
import com.example.DuplicateTradeObjectCreatorOne.RedisRepository.*;


@Component
@ComponentScan(basePackages="com.example.DuplicateTradeObjectCreatorOne.RedisRepository")
public class CacheWriter{

	
		
	@Autowired
	private RedisCashSecurityRepositoryForRedisHashImp redisCashSecurityRepositoryForRedisHash;
	
	@Autowired
	private  RedisTradeRepositoryForRedisHashImp redisTradeRepositoryForRedisHash;
	
	@Autowired
	private  RedisTradeRepositoryForRedisListImp redisTradeRepositoryForRedisList;
	
	

	public void writeToCache(GenericTrade genericTrade){
		
		
		String tradeId=genericTrade.getTradeId();
		String firm=genericTrade.getFirm();
		String tradeDate=genericTrade.getDate();
		GenericSecurity genericSecurity=genericTrade.getGenericSecurity();
		
		
		
		RedisTrade redisTrade=new RedisTrade(tradeId,firm,tradeDate);
		RedisCashSecurity redisCashSecurity=new RedisCashSecurity(tradeId,genericSecurity.getSecurityType(),genericSecurity.getSecurityIdentifier());
		
		
    /*       System.out.println(redisTradeRepositoryForRedisList+" "+redisTradeRepositoryForRedisHash+" "+
			redisSourceErrorRepositoryForRedisHash+" "+redisCashSecurityRepositoryForRedisHash);
		
	*/	
		
		redisTradeRepositoryForRedisList.addRight(tradeId);
		redisTradeRepositoryForRedisHash.add(tradeId, redisTrade);
		redisCashSecurityRepositoryForRedisHash.add(tradeId, redisCashSecurity);
			
	}
	

}
