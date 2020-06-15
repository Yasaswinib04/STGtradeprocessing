package com.citi.stg.KafkaToFileConnector.KafkaComsumer;

import com.citi.stg.KafkaToFileConnector.stringToFileThread.stringToFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/*
 * Kafka Consumer class consuming final XML String from topic
 * and starting thread to store it as XML file
 */
@Component
class Consumer {
    private int i = 1;
    Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${topic.kafka}")
    public void processMessage(String message) {
        logger.info("Consuming message...");
        new stringToFile(message, i++).start();
        logger.info("Writing to file...");

    }
}