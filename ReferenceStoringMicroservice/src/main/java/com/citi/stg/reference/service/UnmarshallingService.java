package com.citi.stg.reference.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;
import com.citi.stg.reference.model.Firms;
import com.citi.stg.reference.model.Assets;

@SuppressWarnings("unused")
@Component
public class UnmarshallingService<T> {
	
	@SuppressWarnings("unchecked")
	public static <T> T makeObject(File file,Class<T> InstanceClass) {
		
		T listOfObjects=null;	
		try {
			// Using JAXB to generate firms object containing list of firms
			JAXBContext jaxbContext = JAXBContext.newInstance(InstanceClass);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			listOfObjects = (T) jaxbUnmarshaller.unmarshal(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfObjects;
	}
	

}
