package com.example.KafkaExample;

public class CashSecurity {
	
	private String SecurityType;
	private String SecurityIdentifier;
	public CashSecurity(String securityType, String securityIdentifier) {
		super();
		SecurityType = securityType;
		SecurityIdentifier = securityIdentifier;
	}
	public String getSecurityType() {
		return SecurityType;
	}
	public void setSecurityType(String securityType) {
		SecurityType = securityType;
	}
	public String getSecurityIdentifier() {
		return SecurityIdentifier;
	}
	public void setSecurityIdentifier(String securityIdentifier) {
		SecurityIdentifier = securityIdentifier;
	}
	
	

}
