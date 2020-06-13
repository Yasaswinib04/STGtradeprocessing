package com.citi.stg.IncomingTradesToKafka.GenericTradeStringThread;

import com.citi.stg.IncomingTradesToKafka.ConverterService.Converter;
import com.citi.stg.IncomingTradesToKafka.KafkaProducer.Producer;
import org.springframework.kafka.core.KafkaTemplate;


public class GenericTradeString extends Thread {
    private KafkaTemplate<String, String> kafkaTemplate;

    private String topic;
    private final String path;

    public GenericTradeString(KafkaTemplate<String, String> kafkaTemplate, String topic, String path) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
        this.path = path;
    }

    @Override
    public void run() {
        String xmlString = new Converter().convertXmlfiletoString(path);
        new Producer(kafkaTemplate, xmlString, topic).sendMessage();
    }
}
