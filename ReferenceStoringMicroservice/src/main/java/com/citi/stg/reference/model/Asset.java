package com.citi.stg.reference.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.data.annotation.Id;

//Asset POJO
@XmlAccessorType(XmlAccessType.FIELD)
public class Asset {

	@Id
	@XmlElement(name = "AssetTypeCode")
	public String assetTypeCode;

	@XmlElement(name = "AssetTypeDescription")
	public String assetTypeDesc;

	public Asset() {
	}

	public Asset(String assetTypeCode, String assetTypeDesc) {
		super();
		this.assetTypeCode = assetTypeCode;
		this.assetTypeDesc = assetTypeDesc;
	}

	@Override
	public String toString() {
		return "Asset [assetTypeCode=" + assetTypeCode + ", assetTypeDesc=" + assetTypeDesc + "]";
	}

}
