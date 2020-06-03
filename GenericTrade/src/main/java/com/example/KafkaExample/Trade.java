package com.example.KafkaExample;

public class Trade {
	
	private String TradeId;
	private String Firm;
	CashSecurity cashsecurity;
	private String TradeDate;
	public Trade() {
		
	}
	public Trade(String tradeId, String firm, CashSecurity cashsecurity, String tradeDate) {
		super();
		TradeId = tradeId;
		Firm = firm;
		this.cashsecurity = cashsecurity;
		TradeDate = tradeDate;
	}
	public String getTradeId() {
		return TradeId;
	}
	public void setTradeId(String tradeId) {
		TradeId = tradeId;
	}
	public String getFirm() {
		return Firm;
	}
	public void setFirm(String firm) {
		Firm = firm;
	}
	public CashSecurity getCashsecurity() {
		return cashsecurity;
	}
	public void setCashsecurity(CashSecurity cashsecurity) {
		this.cashsecurity = cashsecurity;
	}
	public String getTradeDate() {
		return TradeDate;
	}
	public void setTradeDate(String tradeDate) {
		TradeDate = tradeDate;
	}
	

}
