package com.citi.stg.acknackgen.service;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.stg.acknackgen.controller.CacheController;
import com.citi.stg.acknackgen.model.acknack.dest_Error;
import com.citi.stg.acknackgen.model.acknack.dest_Trade;
import com.citi.stg.acknackgen.model.cache.Asset;
import com.citi.stg.acknackgen.model.cache.Firm;
import com.citi.stg.acknackgen.model.trade.Trade;

//Class containing methods that handle conversion of Trade Object to XML
@Service
public class ConvertService {
	
	@Autowired
	dest_Trade opTrade;
	
	@Autowired
	CacheController cacheController;
	
	//Method to create Trade object according the format of the required output XML 		
	public String convertObj(Trade trade){
		
		String opXml=null;
		try {
			
			//Call to method to get Firm Description from the Cache/Database
			Firm firm=cacheController.findFirmByCode(trade.getFirm());
			opTrade.setClientName(firm.getFirmDesc());
			
			opTrade.setError(new dest_Error(trade.getError().getErrordt(),trade.getError().getDescription()));
			
			//Call to method to get Asset Type Description from the Cache/Database
			Asset asset=cacheController.findAssetByCode(trade.getCashSecurity().getSecurityType());	
			opTrade.setSecurityDescription(asset.getAssetTypeDesc());
			
			opTrade.setTradeId(trade.getTradeId());
			opTrade.setTradeDate(trade.getTradeDate());
			
			//Call to method that converts opTrade object to XML
			opXml=covertToXml();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return opXml;
	}
	
	//Method that converts Trade object to XML
	public String covertToXml() {
		
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
		
		//Log XML to console
		System.out.println(opXml);
		return opXml;
	}
}
