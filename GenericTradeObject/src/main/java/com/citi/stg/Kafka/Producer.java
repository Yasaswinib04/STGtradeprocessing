package com.citi.stg.Kafka;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.citi.stg.Trade.GenericTrade;

/*
 *  Producer to produce the GenericTrade object to kafka topic
 */

@Component
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);

	// Name of kafka topic
	@Value("${topic.producer.kafka}")
	private String topic ;

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