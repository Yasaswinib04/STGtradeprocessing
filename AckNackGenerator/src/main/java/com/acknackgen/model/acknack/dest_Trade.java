package com.acknackgen.model.acknack;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name="Trade")
@XmlAccessorType(XmlAccessType.FIELD)
public class dest_Trade {
	
	@XmlElement(name="ClientName")
	private String clientName;
	
	@XmlElement(name="TradeId")
	private String tradeId;
	
	@XmlElement(name="SecurityDescription")
	private String securityDescription;
	
	private dest_Error error;
	
	@XmlElement(name="TradeDate")
	private String tradeDate;

	dest_Trade(){}
	
	public dest_Trade(String clientName, String tradeId, String securityDescription, dest_Error error, String tradeDate) {
		super();
		this.clientName = clientName;
		this.tradeId = tradeId;
		this.securityDescription = securityDescription;
		this.error = error;
		this.tradeDate = tradeDate;
	}
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getSecurityDescription() {
		return securityDescription;
	}

	public void setSecurityDescription(String securityDescription) {
		this.securityDescription = securityDescription;
	}

	public dest_Error getError() {
		return error;
	}

	public void setError(dest_Error error) {
		this.error = error;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	
}
