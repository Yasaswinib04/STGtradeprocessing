package com.acknackgen.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acknackgen.model.trade.Trade;
import com.acknackgen.producer.Producer;
import com.acknackgen.service.ConvertService;

//Controller to call the convert method that handles conversion to XML 
@Component
public class Controller {
	
	@Autowired
	ConvertService convertService;
	
	@Autowired
	Producer producer;
	
	//Method to combine the production and conversion
	public void prodToTopic(Trade trade) throws InterruptedException {	
		producer.sendMessage(convertService.convertObj(trade));
	}
	
}

