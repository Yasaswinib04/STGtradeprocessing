package com.citi.stg.acknackgen.model.cache;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

//Model for the Firm Object to be stored in cache
public class Firm implements Serializable {
	
	@Id
	public String firmCode;
	public String firmDesc;
	
	Firm(){}
	
	public Firm(String firmCode, String firmDesc) {
		super();
		this.firmCode = firmCode;
		this.firmDesc = firmDesc;
	}

	public String getFirmCode() {
		return firmCode;
	}

	public void setFirmCode(String firmCode) {
		this.firmCode = firmCode;
	}

	public String getFirmDesc() {
		return firmDesc;
	}

	public void setFirmDesc(String firmDesc) {
		this.firmDesc = firmDesc;
	}
	
}
