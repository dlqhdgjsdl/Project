package sist.com.newproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class ShoseServiceUtil {
	private static ShoseServiceUtil shoseserver;
	private Connection con;
	public static ShoseServiceUtil con() {
		if(shoseserver==null) {
			shoseserver = new ShoseServiceUtil();
		}
		return shoseserver;
	}
	public Connection getconnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","orange","1234");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
	
}
