package com.testconsumer.consumer;

import org.springframework.stereotype.Service;

import java.io.FileWriter;

@Service
public class Converter {

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
