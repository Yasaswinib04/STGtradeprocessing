package com.citi.stg.acknackgen.model.trade;

//Model of the trade object consumed form kafka
public class Trade {

	private String tradeId;

	private String firm;

	private SourceError error;

	private CashSecurity cashSecurity;

	private String tradeDate;

	Trade() {
	}

	public Trade(String tradeId, String firm, SourceError error, CashSecurity cashSecurity, String tradeDate) {
		super();
		this.tradeId = tradeId;
		this.firm = firm;
		this.error = error;
		this.cashSecurity = cashSecurity;
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

	public SourceError getError() {
		return error;
	}

	public void setError(SourceError error) {
		this.error = error;
	}

	public CashSecurity getCashSecurity() {
		return cashSecurity;
	}

	public void setCashSecurity(CashSecurity cashSecurity) {
		this.cashSecurity = cashSecurity;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", firm=" + firm + ", error=" + error + ", cashSecurity=" + cashSecurity
				+ ", tradeDate=" + tradeDate + "]";
	}

}
