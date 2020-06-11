package com.example.DuplicateTradeObjectCreatorOne;


public class SourceError {
	
	private String errordt;
	
	private String description;
	
	public SourceError() {
		
	}
	
	public SourceError(String errordt, String description) {
		super();
		this.errordt = errordt;
		this.description = description;
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
	
}