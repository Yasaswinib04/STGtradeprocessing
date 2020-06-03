package com.example.KafkaExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	@Autowired
	Producer producer;
	
	
	//Method to combine the production and conversion
	public void prodToTopic(String data) {	
		Trade trade=new Trade(data.substring(data.indexOf("<TradeId>") + 9, data.indexOf("</TradeId>")), data.substring(data.indexOf("<Firm>") + 6, data.indexOf("</Firm>")), new CashSecurity(data.substring(data.indexOf("<SecurityType>") + 14, data.indexOf("</SecurityType>")),data.substring(data.indexOf("<SecurityIdentifier>") + 20, data.indexOf("</SecurityIdentifier>"))),data.substring(data.indexOf("<TradeDate>") + 11, data.indexOf("</TradeDate>")));
		producer.sendMessage(trade);
	}
}