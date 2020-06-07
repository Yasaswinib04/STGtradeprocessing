package com.testconsumer.consumer;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;

public class stringToFile extends Thread{
    private String xmlString;
    private int i;

    public stringToFile(String xmlString, int i) {
        this.xmlString = xmlString;
        this.i = i;
    }

    @Override
    public void run() {
            convert(xmlString,i);
    }

    public void convert(String xmlString,int i){
        try {
            FileWriter fileWriter=new FileWriter("Output Trades/Trade"+Integer.toString(i)+".xml");
            fileWriter.write(xmlString);
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
