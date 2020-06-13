package com.citi.stg.KafkaToFileConnector.KafkaComsumer;

import com.citi.stg.KafkaToFileConnector.stringToFileThread.stringToFile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class Consumer {
    private int i = 1;

    @KafkaListener(topics = "${topic.kafka}")
    public void processMessage(String message) {
        new stringToFile(message, i++).start();
        System.out.println(message);
    }
}