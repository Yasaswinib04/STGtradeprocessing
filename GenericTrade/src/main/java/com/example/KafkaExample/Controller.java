package com.example.KafkaExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	@Autowired
	Producer producer;
	
	//Method to combine the production and conversion
	public void prodToTopic() {	
		Trade trade=new Trade("HNC2347","SLI", new CashSecurity("EQ","XXX4567"),"3123123");
		producer.sendMessage(trade);
	}
	
}