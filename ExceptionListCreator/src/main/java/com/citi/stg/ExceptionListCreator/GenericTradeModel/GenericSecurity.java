package com.citi.stg.ExceptionListCreator.GenericTradeModel;

public class GenericSecurity {

	private String securityType;
	private String securityIdentifier;
	
	public GenericSecurity() {
		
	}

	public GenericSecurity(String securityType, String securityIdentifier) {
		super();
		this.securityType = securityType;
		this.securityIdentifier = securityIdentifier;
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
		return "GenericSecurity [securityType=" + securityType + ", securityIdentifier=" + securityIdentifier + "]";
	}
	
	
	
	
}
