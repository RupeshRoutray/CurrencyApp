package com.pragim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pragim.model.Country;
import com.pragim.util.ConnectionUtil;

public class CurrencyDaoImpl implements CurrencyDao {

	@Override
	public List<Country> getCurrnecyOfAllCountries() {
		// TODO Auto-generated method stub
		List<Country> countrylist = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromOracle();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from country_info");
			countrylist = new ArrayList<Country>();
			while (rs.next()) {
				Country country = new Country(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				countrylist.add(country);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return countrylist;
	}

	@Override
	public String deleteCountry(String[] ids) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			sb.append("?,");
		}
		
		
		String finalstring = sb.toString();
		String strres = finalstring.substring(0, finalstring.lastIndexOf(","));
		
		String deleteQuery = "delete from country_info where id in ("+strres+")";
		
		int count = 0;
		try {
			Connection con = ConnectionUtil.getConnectionFromOracle();
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);
			
			for (int i = 1; i <= ids.length; i++) {
				pstmt.setInt(i, Integer.parseInt(ids[i-1]));
			}
			count = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count + "rows deleted";
	}

	@Override
	public String addCountry(String name, String lang, String cur) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectionUtil.getConnectionFromOracle();
			PreparedStatement pstmt = con.prepareStatement("insert into country_info values (country_seq.nextval,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, lang);
			pstmt.setString(3, cur);
			
			int count = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return name+" saved into DB :-)";
	}

	@Override
	public Country selectCountryById(int id) {
		// TODO Auto-generated method stub
		Country country = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromOracle();
			PreparedStatement pstmt = con.prepareStatement("select * from country_info where id =?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			country = new Country(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return country;
	}

	@Override
	public String updateCountry(int id, String name, String lang,
			String currency) {
		try {
			Connection con = ConnectionUtil.getConnectionFromOracle();
			PreparedStatement pstmt = con.prepareStatement("update country_info set name=?,language=?,currency=? where id=?");
			pstmt.setString(1, name);
			pstmt.setString(2, lang);
			pstmt.setString(3, currency);
			pstmt.setInt(4, id);
			
			int count = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return name+" info updated";
	}

	
}
