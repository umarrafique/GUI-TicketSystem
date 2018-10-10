package GUI_Assignment;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class database {
	String query;
	
	Connection conn = null; // Global Variable 
	Statement stmt = null; // so the class can listen to them  
	ResultSet rs = null;
	
	public database(String query) {
		
		this.query = query;
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
		}catch(Exception e ){}
		
		try {
    	    conn =
    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1/gui?user=root&password=");

    	    // Do something with the Connection
    	    stmt = conn.createStatement();
    	    
		
    	    
    	} catch (SQLException ex) {
    	    // handle any errors
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	}
    		
	}
	
	public ResultSet login() {
		try {
			
			rs=stmt.executeQuery(query);
	 
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	public void insert() {
		
		try {
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void time() {
	}


 }

	