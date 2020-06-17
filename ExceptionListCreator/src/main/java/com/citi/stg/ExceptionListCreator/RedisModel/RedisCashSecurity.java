package com.citi.stg.ExceptionListCreator.RedisModel;

import java.io.Serializable;

public class RedisCashSecurity implements Serializable{

	private String tradeId;
    private String securityType;
	private String securityIdentifier;
	
	public RedisCashSecurity() {
		super();
	}

	public RedisCashSecurity(String tradeId, String securityType, String securityIdentifier) {
		super();
		this.tradeId = tradeId;
		this.securityType = securityType;
		this.securityIdentifier = securityIdentifier;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getSecurityType() {
		return securityType;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	public String getSecurityIdentifier() {
		return securityIdentifier;
	}

	public void setSecurityIdentifier(String securityIdentifier) {
		this.securityIdentifier = securityIdentifier;
	}

	@Override
	public String toString() {
		return "RedisCasheSecurity [tradeId=" + tradeId + ", securityType=" + securityType + ", securityIdentifier="
				+ securityIdentifier + "]";
	}
	
	
	
	
	
	
}
