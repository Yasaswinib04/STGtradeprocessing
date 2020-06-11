package com.example.DuplicateTradeObjectCreatorOne;

import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.DuplicateTradeObjectCreatorOne.GenericTradeModel.*;


@Component
@ComponentScan("com.example.DuplicateTradeObjectCreatorOne")
public class Consumer {	
	
	@Autowired 
	private CacheReader cacheReader;
	
	@Autowired
	private CacheWriter cacheWriter;
	
	private int count=0;
	private int serialNo=1;
	
	private Long start=Instant.now().toEpochMilli();
	

		
		@KafkaListener(topics = "nbneddjx-GenericTradeObjectTopic",concurrency="5")
		public void consume(GenericTrade genericTrade) throws InterruptedException {
					
	       if ( ( (Instant.now().toEpochMilli()-start>10000) || (count>=10) ) && (count>0) ){
				
				System.out.println("calling cacheReader with "+count+" no. of trades");
				cacheReader.startReadingFromCache();
				count=0;
				start=Instant.now().toEpochMilli();
			}
			
			System.out.println("consumed trade no: "+serialNo++);
			System.out.println("consumed trade is : \n"+genericTrade);
			
			 count++;		
			 cacheWriter.writeToCache(genericTrade);	
			
		}
		
		

	
	
	
}
