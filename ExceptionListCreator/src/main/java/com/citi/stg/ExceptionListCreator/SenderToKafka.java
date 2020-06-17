package com.citi.stg.ExceptionListCreator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.citi.stg.ExceptionListCreator.TradeModel.*;


@Component
public class SenderToKafka{
	
	
	private static final Logger logger = LoggerFactory.getLogger(SenderToKafka.class);
	
    @Autowired
	private KafkaTemplate<String,Trade> kafkaTemplate;
	
	
    private static final String topic="56y1nhk1-exception-topic";
	
    private static int count=1;
	
    
    //serializes objects and send it to kafka channel
	public  void sendToKafka(Trade trade) {
		
		
		logger.info("----------------sending trrade no: "+count+"------------------------------------");
		System.out.println("----------------sending trrade no: "+count+"------------------------------------");
			try {
				this.kafkaTemplate.send(topic,trade);
			}catch(Exception e) {
				System.out.println("Here you are getting unknown host exception");
			}
			logger.info("----------------sent trrade no:"+count+"------------------------------------");
		System.out.println("----------------sent trrade no:"+count+"------------------------------------");
		count++;
	}

}
