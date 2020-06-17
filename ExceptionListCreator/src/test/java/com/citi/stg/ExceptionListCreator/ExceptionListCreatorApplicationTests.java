package com.citi.stg.ExceptionListCreator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.citi.stg.ExceptionListCreator.RedisRepository.*;
import com.citi.stg.ExceptionListCreator.MongoRepository.*;
import com.citi.stg.ExceptionListCreator.RedisModel.*;

@SpringBootTest
class ExceptionListCreatorApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	
	@Autowired
	private CacheReader cacheReader;
	
	@Autowired
	private CacheWriter cacheWriter;
	
	@Autowired
	private ExceptionListMaker exceptinListMaker;
	
	
	
	@MockBean
	private RedisCashSecurityRepositoryForRedisHashImp redisCashSecurityRepositoryForRedisHash;
	
	@MockBean
	private  RedisTradeRepositoryForRedisHashImp redisTradeRepositoryForRedisHash;
	
	@MockBean
	private  RedisTradeRepositoryForRedisListImp redisTradeRepositoryForRedisList;
	
	@MockBean
	private TradeRepositoryForMongoDB tradeRepositoryForMongoDB;
	
	@MockBean
	private SenderToKafka senderToKafka;
	
	@Test
	public void writeToCacheTest() {
		
		RedisTrade redisTrade=new RedisTrade("id1","redisFirm","redisDate");
		RedisCashSecurity redisCashSecurity=new RedisCashSecurity("id1","securityCode","securityDescription");
		String redisTradeId="id1";
		
		redisTradeRepositoryForRedisHash.add("id1",redisTrade);	
		
	}

}
