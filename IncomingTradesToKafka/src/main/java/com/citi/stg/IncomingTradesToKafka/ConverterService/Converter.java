package com.citi.stg.IncomingTradesToKafka.ConverterService;

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

//Main Service
@Service
public class Converter {

    /*
     * Method to convert XML File at path "path" into a Document object using the DocumentBuilder class,
     * and calling the method to convert the Document into String.
     *
     * Defines the API to obtain DOM Document instances from an XML document. Using this class,
     * an application programmer can obtain a Document from XML.
     *
     * Once an instance of this class is obtained, XML can be parsed from a variety of input sources.
     * These input sources are InputStreams, Files, URLs, and SAX InputSources.
     *
     * Document building provides validation of the input XML File during pasring.
     */
    public String convertXmlfiletoString(String path) {
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
        return (ToString(xmlDocument));
    }

    /*
     * Method to convert Document into String using the Transformer class.
     *
     * An instance of the Transformer class can transform a source tree into a result tree.
     *
     * This instance may then be used to process XML from a variety of sources and write the
     * transformation output to a variety of sinks.
     *
     * DOMSource acts as a holder for a transformation Source tree in the form of a Document Object Model (DOM) tree.
     * StreamResult acts as an holder for a transformation result, which may be XML, plain Text, etc.
     *
     * StringWriter provides a character stream that collects its output in a string buffer, which is then be used to construct a string.
     */
    public String ToString(Document xmlDocument) {

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(xmlDocument), new StreamResult(writer));
            String xmlString = writer.getBuffer().toString();
            xmlString = StringUtils.replace(xmlString, "\n\t", "\n");
            xmlString = StringUtils.substringBetween(xmlString, "<Trades>", "</Trades>").trim();
            return xmlString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
