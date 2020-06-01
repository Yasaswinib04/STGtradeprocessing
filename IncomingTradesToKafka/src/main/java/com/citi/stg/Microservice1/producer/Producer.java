package com.citi.stg.Microservice1.producer;

import org.springframework.kafka.core.KafkaTemplate;

public class Producer {
    private KafkaTemplate<String, String> kafkaTemplate;
    private String msg;
    private String topic;

    public Producer(KafkaTemplate<String, String> kafkaTemplate, String msg, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.msg = msg;
        this.topic = topic;
    }

    public void sendMessage(){
        kafkaTemplate.send(topic,msg);
        System.out.println(msg);
    }
}
