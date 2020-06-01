package com.example.ExceptionListMaker;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trade {
	
	@Id
	private String id;
	
	private String tradeId;
	private String tradeType;
	
	public String getId() {
		return id;
	}
	public String getTradeId() {
		return tradeId;
	}
	public String getTradeType() {
		return tradeType;
	}
	
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public Trade() {}
	public Trade(String tradeId, String tradeType) {
		super();
		this.tradeId = tradeId;
		this.tradeType = tradeType;
	}
}
