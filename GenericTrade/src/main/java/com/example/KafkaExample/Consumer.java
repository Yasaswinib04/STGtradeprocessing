package com.example.KafkaExample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consumer {

	public String message;
	
	@GetMapping("/consumeMessage")
	public String consumeMessage() {
		return message;
	}
	

	@KafkaListener(groupId="56y1nhk1-", topics="56y1nhk1-GenericTradeTopic")
	public String getMsgFromTopic(String data) {
		message=data;
		
		return message;
	}
}