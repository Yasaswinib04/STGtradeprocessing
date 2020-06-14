package com.citi.stg.reference.model;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

//Class having list of assets
@Data
@XmlRootElement(name="Assets")
@XmlAccessorType(XmlAccessType.FIELD)
public class Assets {
	
	@XmlElement(name="Asset")
	private ArrayList<Asset> assets;

	public ArrayList<Asset> getAssets() {
		return assets;
	}

	public void setAssets(ArrayList<Asset> assets) {
		this.assets = assets;
	}

}
