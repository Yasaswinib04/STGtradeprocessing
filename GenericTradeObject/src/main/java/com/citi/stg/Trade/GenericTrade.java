package com.citi.stg.Trade;

public class GenericTrade {

	private String tradeId;
	private String firm;
	private GenericSecurity genericSecurity;
	private String date;

	public GenericTrade() {
	}

	public GenericTrade(String tradeId, String firm, GenericSecurity genericSecurity, String date) {
		super();
		this.tradeId = tradeId;
		this.firm = firm;
		this.genericSecurity = genericSecurity;
		this.date = date;
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

	public GenericSecurity getGenericSecurity() {
		return genericSecurity;
	}

	public void setGenericSecurity(GenericSecurity genericSecurity) {
		this.genericSecurity = genericSecurity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}