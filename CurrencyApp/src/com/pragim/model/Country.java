package com.pragim.model;

public class Country {
	
	
	private int cId;
	private String name;
	private String lang;
	private String currency;
	
	public Country(int cId, String name, String lang, String currency) {
		super();
		this.cId = cId;
		this.name = name;
		this.lang = lang;
		this.currency = currency;
	}
	public int getcId() {
		return cId;
	}
	public String getName() {
		return name;
	}
	public String getLang() {
		return lang;
	}
	public String getCurrency() {
		return currency;
	}
	
	
	

}
