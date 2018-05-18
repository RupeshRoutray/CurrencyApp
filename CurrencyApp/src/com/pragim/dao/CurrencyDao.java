package com.pragim.dao;

import java.util.List;

import com.pragim.model.Country;

public interface CurrencyDao {
	
	
	List<Country> getCurrnecyOfAllCountries();
	String deleteCountry(String[] ids);
	String addCountry(String name, String lang, String cur);
	Country selectCountryById(int id);
	String updateCountry(int parseInt, String name, String lang, String currency);
}
