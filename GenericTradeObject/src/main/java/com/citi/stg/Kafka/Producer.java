package com.citi.stg.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.citi.stg.Trade.GenericTrade;

@Component
//Class responsible to produce to topic
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);

	// Name of kafka topic
	private static final String topic = "56y1nhk1-GenericTradeObject";

	@Autowired
	private KafkaTemplate<String, GenericTrade> template;

	// Method to produce to topic
	public void sendMessage(GenericTrade generictrade) {

		// Logging produced message
		logger.info(String.format("#### -> Producing message -> %s", generictrade));
		// Send message to topic
		this.template.send(topic, generictrade);

		logger.info(String.format("Successfully produced to GenericTradeObject", generictrade));
	}
}