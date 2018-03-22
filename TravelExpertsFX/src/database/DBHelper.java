package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
	
	private static String DBName = "travelexperts_jh";
	private static String rootPass = "";
	private static String DBUser = "root";
	
	public static void setDBPass(String pass) {
		rootPass = pass;
	}
	
	public static void setDBName(String name) {
		DBName = name;
	}
	
	private static Connection conn;
	private static PreparedStatement ps;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
//		Class.forName("org.mariadb.jdbc.Driver");
//		conn = DriverManager.getConnection("jdbc:mariadb://10.163.101.210:3306/travelexperts_jh","jhdb","password");
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBName, DBUser, rootPass);
		return conn;
		
	}
	
	public static boolean checkConnection() {
		try {
		Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBName, DBUser, rootPass);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;			
		}
	}
	
	public static void createLoginTable() {
        String query = "CREATE TABLE IF NOT EXISTS accounts (" 
            + "username VARCHAR(30) NOT NULL," 
            + "password VARCHAR(1000) NOT NULL,"
            + "salt VARCHAR(1000) NOT NULL,"
            + "status VARCHAR(30) NOT NULL,"  
            + "AgentId INT(64) references agents(AgentId),"
            + "PRIMARY KEY (`username`))";  
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
           // createAccounts();
        }
        catch (SQLException e ) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("An Mysql drivers were not found");
        }
    }

	private static void createAccounts() throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO Accounts "
				+ "(username, password, salt, status, AgentId) VALUES "
				+ "(?, ?, ?, ?, ?) ";

		String salt = PasswordUtils.getSalt(10);
		String pass = PasswordUtils.generateSecurePassword("pass", salt);
		try {
			conn = DBHelper.getConnection();
			//Create agent user
		    ps = conn.prepareStatement(query);
		    ps.setString(1, "Dennis");
		    ps.setString(2, pass);
		    ps.setString(3, salt);
		    ps.setString(4, "agent");
		    ps.setInt(5, 3);
		    ps.executeUpdate(); 
		    //create admin user
		    ps = conn.prepareStatement(query);
		    ps.setString(1, "Janet");
		    ps.setString(2, pass);
		    ps.setString(3, salt);
		    ps.setString(4, "admin");
		    ps.setInt(5, 1);
		    ps.executeUpdate(); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 		
	}
	
}

