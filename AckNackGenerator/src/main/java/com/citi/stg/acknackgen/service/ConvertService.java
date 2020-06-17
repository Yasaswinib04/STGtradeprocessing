package com.citi.stg.acknackgen.service;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(ConvertService.class);

	@Autowired
	dest_Trade opTrade;

	@Autowired
	CacheController cacheController;

	// Method to create Trade object according the format of the required output XML
	public String convertObj(Trade trade) {

		String opXml = null;
		try {
	
			logger.info("Setting the Fields of dest_Trade Object input trade :"+trade.toString());
			// Call to method to get Firm Description from the Cache/Database
			logger.info("Getting Firm Description from cache thorugh cacheController");
			Firm firm = cacheController.findFirmByCode(trade.getFirm());
			opTrade.setClientName(firm.getFirmDesc());

			opTrade.setError(new dest_Error(trade.getError().getErrordt(), trade.getError().getDescription()));

			// Call to method to get Asset Type Description from the Cache/Database
			logger.info("Getting Asset Description from cache thorugh cacheController");
			Asset asset = cacheController.findAssetByCode(trade.getCashSecurity().getSecurityType());
			opTrade.setSecurityDescription(asset.getAssetTypeDesc());

			opTrade.setTradeId(trade.getTradeId());
			opTrade.setTradeDate(trade.getTradeDate());

			// Call to method that converts opTrade object to XML
			opXml = covertToXml();
		} catch (Exception e) {
			logger.error("Exception occured in method convertObject Failed to generate trade object for ack/nack for input trade :"+trade.toString(),e);
			e.printStackTrace();
		}
		return opXml;
	}

	// Method that converts Trade object to XML
	public String covertToXml() {

		// Empty StringWriter object
		StringWriter sw = new StringWriter();
		String opXml = "";

		// Marshalling to object to Xml in required format
		try {

			logger.info("Marshalling Ack/Nack to XML");

			JAXBContext jaxbcontext = JAXBContext.newInstance(dest_Trade.class);
			Marshaller jaxbMarshaller = jaxbcontext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(opTrade, sw);

			// Store the required Xml as String
			opXml = sw.toString();

		} catch (JAXBException e) {
			logger.error("JAXB Exception encountered in covertToXml method Failed to generate XML from trade for trade :"+opTrade.toString(), e);
			e.printStackTrace();
		}

		// Log XML to console
		logger.info("Generated Ack/Nack :"+opXml);

		return opXml;
	}
}
