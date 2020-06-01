package com.acknackgen.service;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acknackgen.model.acknack.dest_Error;
import com.acknackgen.model.acknack.dest_Trade;
import com.acknackgen.model.trade.Trade;

@Service
public class ConvertService {
	
	@Autowired
	dest_Trade opTrade;
	
	//Method for changing to Xml		
	public String convertObj(Trade trade){
		
		String opXml=null;
		try {
			opTrade.setClientName(trade.getFirm());
			opTrade.setError(new dest_Error(trade.getError().getDescription(),trade.getError().getErrordt()));;
			opTrade.setSecurityDescription(trade.getCashSecurity().getSecurityType());
			opTrade.setTradeId(trade.getTradeId());
			opTrade.setTradeDate(trade.getTradeDate());
			opXml=covertToXml();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return opXml;
	}
	
	public String covertToXml() {
		System.out.println("Trade herer");
		//Empty StringWriter object
		StringWriter sw=new StringWriter();
		String opXml="";
		//Marshalling to object to Xml in required format
		try {
			JAXBContext jaxbcontext=JAXBContext.newInstance(dest_Trade.class);
			Marshaller jaxbMarshaller=jaxbcontext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(opTrade,sw);
			
			//Store the required Xml as String
			opXml=sw.toString();
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		System.out.println(opXml);
		return opXml;
	}
}
