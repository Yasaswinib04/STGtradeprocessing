package com.citi.stg.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import com.citi.stg.Controller.Controller;

/*
 *  Kafka consumer to consume the trade string
 */

@RestController
public class Consumer {
	
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	/*
	 *   Consume the Trade string from the Kafka topic and then make a call to the controller
	 */
	
	@Autowired
	Controller controller;

	@KafkaListener(topics = "${topic.consumer.kafka}", concurrency = "5")
	public void consume(String data) {
		
		logger.info("#### -> Consuming Trade from GenericTradeTopic");
		
		controller.prodToTopic(data);
	}
}