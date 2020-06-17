package com.citi.stg.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.citi.stg.Trade.GenericSecurity;
import com.citi.stg.Trade.GenericTrade;

@Component
public class ControllerService {
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerService.class);

	public GenericTrade convertObject(String data) {

		/*
		 * Method to set the feilds of GenericTrade Object from the recieved string
		 */
		
		logger.info("Setting the feilds of GenericTrade Object");
		
		GenericTrade generictrade = new GenericTrade(
				data.substring(data.indexOf("<TradeId>") + 9, data.indexOf("</TradeId>")),
				data.substring(data.indexOf("<Firm>") + 6, data.indexOf("</Firm>")),
				new GenericSecurity(
						data.substring(data.indexOf("<SecurityType>") + 14, data.indexOf("</SecurityType>")),
						data.substring(data.indexOf("<SecurityIdentifier>") + 20,
								data.indexOf("</SecurityIdentifier>"))),
				data.substring(data.indexOf("<TradeDate>") + 11, data.indexOf("</TradeDate>")));
		return generictrade;
	}

}
