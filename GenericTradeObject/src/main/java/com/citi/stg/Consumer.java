package com.citi.stg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consumer {

	@Autowired
	Controller controller;
	

	@KafkaListener(topics="56y1nhk1-GenericTradeTopic", concurrency="5")
	public void consume(String data) {
		controller.prodToTopic(data);
	}
}