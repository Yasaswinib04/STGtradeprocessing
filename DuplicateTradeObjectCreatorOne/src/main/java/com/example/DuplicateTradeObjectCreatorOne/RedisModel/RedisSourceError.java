package com.example.DuplicateTradeObjectCreatorOne.RedisModel;

import java.io.Serializable;

public class RedisSourceError implements Serializable{

	private String tradeId;
	private String errordt;
	private String description;
	public RedisSourceError() {
		super();
	}
	public RedisSourceError(String tradeId, String errordt, String description) {
		super();
		this.tradeId = tradeId;
		this.errordt = errordt;
		this.description = description;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public String getErrordt() {
		return errordt;
	}
	public void setErrordt(String errordt) {
		this.errordt = errordt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "RedisSourceError [tradeId=" + tradeId + ", errordt=" + errordt + ", description=" + description + "]";
	}
	
	
	
	
	
}
