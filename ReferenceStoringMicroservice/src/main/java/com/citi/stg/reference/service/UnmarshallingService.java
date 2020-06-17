package com.citi.stg.reference.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.citi.stg.reference.model.Firms;
import com.citi.stg.reference.model.Assets;

@SuppressWarnings("unused")
@Component
public class UnmarshallingService<T> {

	private static final Logger logger = LoggerFactory.getLogger(StoreService.class);
	
	/*
	 * Method to convert XML File object specified in parameter to Java Object
	 * The Unmarshaller class governs the process of deserializing XML data into
	 * newly created Java content trees, validating the XML data as it is
	 * unmarshalled
	 */
	@SuppressWarnings("unchecked")
	public static <T> T makeObject(File file, Class<T> InstanceClass) {

		T listOfObjects = null;
		try {

			logger.info("Unmarshalling XML to create list of objects");

			// Using JAXB unmarshalling to generate list of object form given XML files
			JAXBContext jaxbContext = JAXBContext.newInstance(InstanceClass);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			listOfObjects = (T) jaxbUnmarshaller.unmarshal(file);

		} catch (Exception e) {
			logger.error("Exception ocuured during Unmarshalling XML :", e);
			e.printStackTrace();
		}
		return listOfObjects;
	}

}
