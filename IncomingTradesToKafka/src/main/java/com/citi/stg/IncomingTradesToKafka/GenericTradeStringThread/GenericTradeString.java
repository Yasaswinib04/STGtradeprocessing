package com.citi.stg.IncomingTradesToKafka.GenericTradeStringThread;

import com.citi.stg.IncomingTradesToKafka.ConverterService.Converter;
import com.citi.stg.IncomingTradesToKafka.KafkaProducer.Producer;
import org.springframework.kafka.core.KafkaTemplate;

/*
 * Thread class calling methods to store contents of XML file at path "path"
 * into a String in the required format and then send the formed String to the producer
 * in order to publish it to Kafka Topic "topic"
 *
 * Multithreading is used to achieve parallel processing of files with a view to be time efficient
 */
public class GenericTradeString extends Thread {
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;
    private final String path;

    // constructor
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
