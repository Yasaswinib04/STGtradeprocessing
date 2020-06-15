package com.citi.stg.acknackgen.model.acknack;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.stereotype.Component;

//POJO class for the Error Object to be converted to XML
@Component
@XmlAccessorType(XmlAccessType.FIELD)
public class dest_Error {

	@XmlElement(name = "ErrorDateTime")
	private String errordt;

	@XmlElement(name = "Description")
	private String description;

	dest_Error() {
	}

	public dest_Error(String errordt, String description) {
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
		return "dest_Error [errordt=" + errordt + ", description=" + description + "]";
	}

}
