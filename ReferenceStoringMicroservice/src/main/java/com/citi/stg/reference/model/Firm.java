package com.citi.stg.reference.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.data.annotation.Id;

//Firm POJO 
@XmlAccessorType(XmlAccessType.FIELD)
public class Firm {

	@Id
	@XmlElement(name = "FirmCode")
	public String firmCode;

	@XmlElement(name = "FirmDescription")
	public String firmDesc;

	public Firm() {
	}

	public Firm(String firmCode, String firmDesc) {
		super();
		this.firmCode = firmCode;
		this.firmDesc = firmDesc;
	}

	@Override
	public String toString() {
		return "Firm [firmCode=" + firmCode + ", firmDesc=" + firmDesc + "]";
	}

}
