package com.citi.stg.reference.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.data.annotation.Id;

import lombok.Data;

//Firm POJO 
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Firm {

	@Id
	@XmlElement(name = "FirmCode")
	public String firmCode;

	@XmlElement(name = "FirmDescription")
	public String firmDesc;

	@Override
	public String toString() {
		return "Firm [firmCode=" + firmCode + ", firmDesc=" + firmDesc + "]";
	}

}
