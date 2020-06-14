package com.citi.stg.acknackgen.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.citi.stg.acknackgen.controller.Controller;
import com.citi.stg.acknackgen.model.trade.Trade;

//Kafka Consumer Class
@Component
public class Consumer {

	@Autowired
	Controller controller;

	@KafkaListener(topics = "${topic.kafka.consumer}", concurrency = "5")
	public void consume(Trade trade) throws InterruptedException {

		// Call to controller to convert the received trade object
		controller.prodToTopic(trade);
	}

}
