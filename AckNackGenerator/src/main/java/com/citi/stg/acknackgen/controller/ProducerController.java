package com.citi.stg.acknackgen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.stg.acknackgen.kafka.producer.Producer;
import com.citi.stg.acknackgen.model.trade.Trade;
import com.citi.stg.acknackgen.service.ConvertService;

//Controller to call the convert method that handles conversion to XML 
@Component
public class ProducerController {

	private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

	@Autowired
	ConvertService convertService;

	@Autowired
	Producer producer;

	private String ackNack = "";

	// Method to combine the production and conversion
	public void prodToTopic(Trade trade) throws InterruptedException {

		logger.info("Call to convertService to generate ackNack");
		ackNack = convertService.convertObj(trade);
		
		logger.info("Call Producer to produce ack/nack");
		producer.sendMessage(ackNack);
	}

}
