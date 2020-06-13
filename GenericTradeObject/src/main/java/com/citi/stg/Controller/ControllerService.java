package com.citi.stg.Controller;

import org.springframework.stereotype.Component;

import com.citi.stg.Trade.GenericSecurity;
import com.citi.stg.Trade.GenericTrade;

@Component
public class ControllerService {

	public GenericTrade convertObject(String data) {

		// convert the consumed trade string to Generic Trade Object
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
