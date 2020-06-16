package com.citi.stg.reference.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Class having list of assets
@XmlRootElement(name = "Assets")
@XmlAccessorType(XmlAccessType.FIELD)
public class Assets {

	@XmlElement(name = "Asset")
	private ArrayList<Asset> assets;

	public Assets() {
	}

	public Assets(ArrayList<Asset> assets) {
		super();
		this.assets = assets;
	}

	public ArrayList<Asset> getAssets() {
		return assets;
	}

	public void setAssets(ArrayList<Asset> assets) {
		this.assets = assets;
	}

	@Override
	public String toString() {
		return "Assets [assets=" + assets + "]";
	}

}
