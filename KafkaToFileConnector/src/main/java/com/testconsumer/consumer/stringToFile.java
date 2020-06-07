package com.testconsumer.consumer;


public class stringToFile extends Thread{
    private String xmlString;
    private int i;

    public stringToFile(String xmlString, int i) {
        this.xmlString = xmlString;
        this.i = i;
    }

    @Override
    public void run() {
            new Converter().convert(xmlString,i);
    }


}
