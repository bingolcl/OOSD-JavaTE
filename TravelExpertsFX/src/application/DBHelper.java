package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	static Connection conn;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts_jh", "root", "");
		return conn;
		
	}
	
	public static boolean checkConnection() {
		try {
		Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts_jh", "root", "");
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;			
		}
	}

}
