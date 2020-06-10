package com.citi.stg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	@Autowired
	Producer producer;
	
	
	//Method to convert the string to object and send to the producer
	public void prodToTopic(String data) {	
		GenericTrade generictrade=new GenericTrade(data.substring(data.indexOf("<TradeId>") + 9, data.indexOf("</TradeId>")), data.substring(data.indexOf("<Firm>") + 6, data.indexOf("</Firm>")), new GenericSecurity(data.substring(data.indexOf("<SecurityType>") + 14, data.indexOf("</SecurityType>")),data.substring(data.indexOf("<SecurityIdentifier>") + 20, data.indexOf("</SecurityIdentifier>"))),data.substring(data.indexOf("<TradeDate>") + 11, data.indexOf("</TradeDate>")));
		producer.sendMessage(generictrade);
	}
}