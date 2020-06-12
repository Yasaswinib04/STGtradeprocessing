package com.citi.stg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	@Autowired
	Producer producer;
	
	@Autowired
	ControllerService controllerservice;
	
	
	//Method to convert the string to object and send to the producer
	public void prodToTopic(String data) {	
		GenericTrade generictrade = controllerservice.convertObject(data);
		producer.sendMessage(generictrade);
	}
}
