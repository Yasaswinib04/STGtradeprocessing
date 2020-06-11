package com.example.DuplicateTradeObjectCreatorOne;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.example.DuplicateTradeObjectCreatorOne.RedisModel.*;
import com.example.DuplicateTradeObjectCreatorOne.RedisRepository.*;


@Component
@ComponentScan("com.example.DuplicateTradeObjectCreatorOne.RedisRepository")
@ComponentScan("com.example.DuplicateTradeObjectCreatorOne.RedisModel")
public class ExceptionListMaker{	
	
	
	@Autowired
	private TradeRepositoryForMongoDB tradeRepositoryForMongoDB;
	
	@Autowired
	private RedisCashSecurityRepositoryForRedisHashImp redisCashSecurityRepositoryForRedisHash;
	
	@Autowired
	private RedisTradeRepositoryForRedisHashImp redisTradeRepositoryForRedisHash;
	
	@Autowired
	private SenderToKafka senderToKafka;
	
	
	
	
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
			}else {
				sourceError=new SourceError(null,"error not found");
			}
		     Trade trade=new Trade(tradeId,redisTrade.getFirm(),sourceError,cashSecurity,redisTrade.getTradeDate());
		     senderToKafka.sendToKafka(trade);
			
		}
			
	}

	
}
