package com.citi.stg.IncomingTradesToKafka.KafkaProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

/*
 * Kafka Producer to produce a String message to Kafka Topic using KafkaTemplate class.
 */
public class Producer {
    Logger logger= LoggerFactory.getLogger(Producer.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private String msg;
    private String topic;

    // constructor
    public Producer(KafkaTemplate<String, String> kafkaTemplate, String msg, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.msg = msg;
        this.topic = topic;
    }

    //Method to send message "msg" to Kafka Topic "topic"
    public void sendMessage() {
        logger.info("Producing to topic...");
        kafkaTemplate.send(topic, msg);
    }
}
