package com.acknackgen.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.acknackgen.controller.Controller;
import com.acknackgen.model.trade.Trade;


@Component
public class Consumer {
	
	@Autowired
	Controller controller;
	
	@KafkaListener(topics = "56y1nhk1-exception-topic",concurrency="5")
	public void consume(Trade trade) {
		
		controller.prodToTopic(trade);
	}
	
}
