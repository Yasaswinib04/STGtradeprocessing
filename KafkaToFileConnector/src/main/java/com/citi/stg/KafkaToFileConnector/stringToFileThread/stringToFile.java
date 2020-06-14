package com.citi.stg.KafkaToFileConnector.stringToFileThread;


import com.citi.stg.KafkaToFileConnector.ConverterService.Converter;

/*
 * Thread class  calling the main service of the microservice.
 *
 * Multithreading is used to achieve parallel processing capability.
 */
public class stringToFile extends Thread {
    private String xmlString;
    private long i;

    // constructor
    public stringToFile(String xmlString, int i) {
        this.xmlString = xmlString;
        this.i = i;
    }

    @Override
    public void run() {
        new Converter().convert(xmlString, i);
    }


}
