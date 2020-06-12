package com.ref.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;


import org.springframework.data.annotation.Id;

import lombok.Data;

//Asset POJO
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Asset {
	
	@Id
	@XmlElement(name="AssetTypeCode")
	public String assetTypeCode;
	
	@XmlElement(name="AssetTypeDescription")
	public String assetTypeDesc;

}
