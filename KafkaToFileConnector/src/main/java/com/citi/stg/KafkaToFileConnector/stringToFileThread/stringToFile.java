package com.citi.stg.KafkaToFileConnector.stringToFileThread;


import com.citi.stg.KafkaToFileConnector.ConverterService.Converter;

public class stringToFile extends Thread {
    private String xmlString;
    private int i;

    public stringToFile(String xmlString, int i) {
        this.xmlString = xmlString;
        this.i = i;
    }

    @Override
    public void run() {
        new Converter().convert(xmlString, i);
    }


}
