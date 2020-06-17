package com.citi.stg.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.stg.Kafka.Producer;
import com.citi.stg.Trade.GenericTrade;

@Component
public class Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	Producer producer;

	@Autowired
	ControllerService controllerservice;

	/* 
	 * Method to make a call to ControllerService
	 * which will convert the string into java object
	 * and return the GenericTrade Object
	 * Then this method will call the producer to send this object to kafka topic
	 */
	public void prodToTopic(String data) {
		
		logger.info("Controller called");
		
		GenericTrade generictrade = controllerservice.convertObject(data);
		producer.sendMessage(generictrade);
	}
}