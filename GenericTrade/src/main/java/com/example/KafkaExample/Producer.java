package com.example.KafkaExample;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
//Class responsible to produce to topic
public class Producer {
	
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	//Name of kafka topic
	private static final String topic="56y1nhk1-GenericTradeObject";
	
	
	@Autowired
	private KafkaTemplate<String,Trade> template;
	
	//Method to produce to topic
	public void sendMessage(Trade message) {
		
		//Logging produced message
		logger.info(String.format("#### -> Producing message -> %s", message));
		//Send message to topic
		this.template.send(topic,message);
		
		logger.info(String.format("Successfully produced to exception-topic", message));
	}
}