package com.citi.stg.ExceptionListCreator.RedisModel;

import java.io.Serializable;

public class RedisTrade implements Serializable{

	private String tradeId;
    private String firm;
    private String tradeDate;
    
    
	public RedisTrade() {
		super();
	}
	public RedisTrade(String tradeId, String firm, String tradeDate) {
		super();
		this.tradeId = tradeId;
		this.firm = firm;
		this.tradeDate = tradeDate;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	@Override
	public String toString() {
		return "RedisTrade [tradeId=" + tradeId + ", firm=" + firm + ", tradeDate=" + tradeDate + "]";
	}
	
	
    
     
	
	
}
