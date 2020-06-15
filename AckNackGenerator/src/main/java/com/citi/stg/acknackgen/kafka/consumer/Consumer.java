package com.citi.stg.acknackgen.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.citi.stg.acknackgen.controller.ProducerController;
import com.citi.stg.acknackgen.model.trade.Trade;

//Kafka Consumer Class
@Component
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	ProducerController controller;

	@KafkaListener(topics = "${topic.kafka.consumer}", concurrency = "5")
	public void consume(Trade trade) throws InterruptedException {

		logger.info("#### -> Consuming Trade from exception topic");
		
		// Call to controller to convert the received trade object
		controller.prodToTopic(trade);
	}

}
