package com.citi.stg.acknackgen.model.trade;

//Model of SourceError class present in trade
public class SourceError {

	private String errordt;

	private String description;

	SourceError() {
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

	@Override
	public String toString() {
		return "SourceError [errordt=" + errordt + ", description=" + description + "]";
	}

}
