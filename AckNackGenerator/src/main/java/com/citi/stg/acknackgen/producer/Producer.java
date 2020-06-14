package com.citi.stg.acknackgen.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
//Class responsible to produce to topic
public class Producer {
	
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	//Name of kafka topic
	private static final String topic="56y1nhk1-ack-nack-topic";
	
	
	@Autowired
	private KafkaTemplate<String,String> template;
	
	//Method to produce to topic
	public void sendMessage(String message) throws InterruptedException {
		
		//Logging produced message
		
		logger.info("#### -> Producing message");
		//Send message to topic
		this.template.send(topic,message);
	}
}
