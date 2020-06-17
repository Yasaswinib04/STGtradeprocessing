package com.citi.stg.reference.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Class having list of firms
@XmlRootElement(name = "Firms")
@XmlAccessorType(XmlAccessType.FIELD)
public class Firms {

	@XmlElement(name = "Firm")
	private ArrayList<Firm> firms;

	public Firms() {
	}

	public Firms(ArrayList<Firm> firms) {
		super();
		this.firms = firms;
	}

	public ArrayList<Firm> getFirms() {
		return firms;
	}

	public void setFirms(ArrayList<Firm> firms) {
		this.firms = firms;
	}

	@Override
	public String toString() {
		return "Firms [firms=" + firms + "]";
	}

}
