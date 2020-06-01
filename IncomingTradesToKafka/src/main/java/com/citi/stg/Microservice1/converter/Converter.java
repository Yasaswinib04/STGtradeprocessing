package com.citi.stg.Microservice1.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

@Service
public class Converter {


    public String convertXmlfiletoString(String path){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Document xmlDocument = null;
        try {
            xmlDocument = builder.parse(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return(ToString(xmlDocument));
    }

    public String ToString(Document xmlDocument)
    {

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(xmlDocument), new StreamResult(writer));
            String xmlString = writer.getBuffer().toString();

            xmlString= StringUtils.substringBetween(xmlString,"<Trades>","</Trades>");
            return xmlString;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
