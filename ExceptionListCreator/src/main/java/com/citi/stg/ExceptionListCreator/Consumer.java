package com.citi.stg.ExceptionListCreator;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.citi.stg.ExceptionListCreator.GenericTradeModel.*;



@Component
@ComponentScan("com.citi.stg.ExceptionListCreator")
public class Consumer {	
	
	
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	
	@Autowired 
	private CacheReader cacheReader;
	
	@Autowired
	private CacheWriter cacheWriter;
	
//	@Value("${topic.toRecieve}")
//	private String topic;
	
	
	private int count=0;
	private int serialNo=1;
	
	private Long start=Instant.now().toEpochMilli();
	
		
		@KafkaListener(topics="56y1nhk1-GenericTradeObject",concurrency="5")
		public void consume(GenericTrade genericTrade) throws InterruptedException {
			
			/* This part below is actually takinig in account that my microservice will either wait for 
			 * 3 seconds or it will capture maximum 10 trades and write it into cache and after that 
			 * it will start processing it.
			 * But if there happens a case that not a single trade came for more than three seconds,
			 *  then it will again start waiting for either 3 seconds or will wait for 10 trades and 
			 *  the process will go on and on....but a cache reader service will never be called when
			 *  the cache is empty!
			 */
			
	       if ( ( (Instant.now().toEpochMilli()-start>3000) || (count>=10) ) && (count>0) ){
				
				System.out.println("calling cacheReader with "+count+" no. of trades");
				cacheReader.startReadingFromCache();
				count=0;
				start=Instant.now().toEpochMilli();
			}
			
	       logger.info("consumed trade no: "+serialNo);
	       logger.info("consumed trade is : \n"+genericTrade);
	       
			System.out.println("consumed trade no: "+serialNo);
			System.out.println("consumed trade is : \n"+genericTrade);
			
			 serialNo++;
			 count++;		
			 cacheWriter.writeToCache(genericTrade);
			
		}
		
		

	
	
	
}
