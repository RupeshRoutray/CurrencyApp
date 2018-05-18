package com.pragim.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	
	
	static Connection con = null;
	public static Connection getConnectionFromOracle(){
		
		try {
			
			if(con == null) {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:USER", "System", "System");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1158", "System", "System");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}

}
