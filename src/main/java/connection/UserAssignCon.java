package connection;

import java.sql.*;

public class UserAssignCon {
	
	public Connection connect() { 
		 
		Connection con = null; 
 
		try { 

			Class.forName("com.mysql.jdbc.Driver");   
 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PAF_Project2022_SLIIT", "root", ""); 
			System.out.println("----Connection Succsuss !----");
			return con;
		} 
 
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("----Connection Error !----");
			return con; 		
		} 

	}

}
