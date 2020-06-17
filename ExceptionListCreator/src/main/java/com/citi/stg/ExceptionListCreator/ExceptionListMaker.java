package com.citi.stg.ExceptionListCreator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.citi.stg.ExceptionListCreator.RedisModel.*;
import com.citi.stg.ExceptionListCreator.RedisRepository.*;
import com.citi.stg.ExceptionListCreator.MongoRepository.*;
import com.citi.stg.ExceptionListCreator.TradeModel.*;


@Component
@ComponentScan("com.citi.stg.ExceptionListCreator.RedisRepository")
@ComponentScan("com.citi.stg.ExceptionListCreator.RedisModel")
@ComponentScan("com.citi.stg.ExceptionListCreator.MongoRepository")
public class ExceptionListMaker{
	
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionListMaker.class);
	
	
	@Autowired
	private TradeRepositoryForMongoDB tradeRepositoryForMongoDB;
	
	@Autowired
	private RedisCashSecurityRepositoryForRedisHashImp redisCashSecurityRepositoryForRedisHash;
	
	@Autowired
	private RedisTradeRepositoryForRedisHashImp redisTradeRepositoryForRedisHash;
	
	@Autowired
	private SenderToKafka senderToKafka;
	
	/* This function compare list of trade ids collected and compare it with data already available in 
	 * mongodb database .....adds source error time and date if error is found and then it sends the 
	 * serialized object to the kafka.
	 */
	
	
	public  void makeExceptionList(ArrayList<String> tradeIdList) throws InterruptedException {
		
		for(int i=0;i<tradeIdList.size();i++) {
			
			String tradeId=tradeIdList.get(i);
			RedisTrade redisTrade=redisTradeRepositoryForRedisHash.findById(tradeId);
			RedisCashSecurity redisCashSecurity=redisCashSecurityRepositoryForRedisHash.findById(tradeId);
			
			
			
			boolean result=tradeRepositoryForMongoDB.existsByTradeId(tradeId);
			
			CashSecurity cashSecurity=new CashSecurity(redisCashSecurity.getSecurityType(),redisCashSecurity.getSecurityIdentifier());
			SourceError sourceError;
			
			
			Date date = Calendar.getInstance().getTime();  
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
			String strDate = dateFormat.format(date);
			
			if(result) {
				sourceError=new SourceError(strDate,"error found");
				System.out.println(">>>>>>>>>>>>>>>>   Trade with tradeId=  "+tradeId+"   is found to be duplicate   <<<<<<<<<<<<<<<");
				
				logger.info(">>>>>>>>>>>>>>>>   Trade with tradeId=  "+tradeId+"   is found to be duplicate   <<<<<<<<<<<<<<<");
				
				
			}else {
				sourceError=new SourceError(null,"error not found");
			}
		     Trade trade=new Trade(tradeId,redisTrade.getFirm(),sourceError,cashSecurity,redisTrade.getTradeDate());
		     senderToKafka.sendToKafka(trade);
			
		}
			
	}

	
}
