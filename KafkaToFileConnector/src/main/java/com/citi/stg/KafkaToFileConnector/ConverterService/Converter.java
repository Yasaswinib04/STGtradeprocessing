package com.citi.stg.KafkaToFileConnector.ConverterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileWriter;

//Main service
@Service
public class Converter {
    private static final Logger logger=LoggerFactory.getLogger(Converter.class);
    /*
     * Creation of XML file from XML String is done using the FileWriter class.
     *
     * Java FileWriter class is used to write character-oriented data to a file.
     * It is character-oriented class which is used for file handling in java.
     *
     * Unlike FileOutputStream class, we don't need to convert string into byte
     * array because it provides method to write string directly.
     */
    public void convert(String xmlString, long i) {
        try {
            logger.info("Writing to file...");
            FileWriter fileWriter = new FileWriter("Output Trades/Trade" + Long.toString(i) + ".xml");
            fileWriter.write(xmlString);
            fileWriter.close();
        } catch (Exception e) {
            logger.error("Failed to write to file");
            e.printStackTrace();
        }
    }
}
