package database;

import java.sql.*;

import model.Agent;

public class AgentDB {
	
	public static Agent getAgent(int id) {
		Agent ag = new Agent();
		try {
			Connection con = DBHelper.getConnection();
//			String query = "SELECT * FROM Agents WHERE AgentId = ?";
//		    PreparedStatement ps = con.prepareStatement(query);
//		    ps.setInt(1, id);
//		    ResultSet rs = ps.executeQuery(); 
		    
	    	CallableStatement cStmt = con.prepareCall("{call getAgentById(?)}");
	        cStmt.setInt(1, id);
	    	ResultSet rs = cStmt.executeQuery();
	    	
	        while (rs.next()) {
	        	ag.setAgentId(id);
	        	ag.setAgtFirstName(rs.getString("agtFirstName"));
	        	ag.setAgtMiddleInitial(rs.getString("AgtMiddleInitial"));
	        	ag.setAgtLastName(rs.getString("agtLastName"));
	        	ag.setAgtBusPhone(rs.getString("agtBusPhone"));
	        	ag.setAgtEmail(rs.getString("agtEmail"));
	        	ag.setAgtPosition(rs.getString("agtPosition"));
	        	ag.setAgencyId(rs.getInt("agencyId"));
        }
	        con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ag;
	}
	

}
