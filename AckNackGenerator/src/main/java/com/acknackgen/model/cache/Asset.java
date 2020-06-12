package com.acknackgen.model.cache;


import java.io.Serializable;
import org.springframework.data.annotation.Id;

//Model for the Asset Object to be stored in cache
public class Asset implements Serializable {
	
	@Id
	public String assetTypeCode;
	public String assetTypeDesc;

	Asset(){}
	
	public Asset(String assetTypeCode, String assetTypeDesc) {
		super();
		this.assetTypeCode = assetTypeCode;
		this.assetTypeDesc = assetTypeDesc;
	}

	public String getAssetTypeCode() {
		return assetTypeCode;
	}

	public void setAssetTypeCode(String assetTypeCode) {
		this.assetTypeCode = assetTypeCode;
	}

	public String getAssetTypeDesc() {
		return assetTypeDesc;
	}

	public void setAssetTypeDesc(String assetTypeDesc) {
		this.assetTypeDesc = assetTypeDesc;
	}
	
}
