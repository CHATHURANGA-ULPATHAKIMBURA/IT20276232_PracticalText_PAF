package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.UserAssignCon;

public class UserAssign {
	
	//Read All Pending Users
	public String readPendingUsers() { 
		 
		String output = ""; 
 
		try { 
 
			UserAssignCon userAssignCon = new UserAssignCon();
			Connection con = userAssignCon.connect();  
 
			if (con == null) {
				System.err.println("----- Connection Error for Read ! -----");
				return "Error while connecting to the database for reading."; 
			} 
 
			// Prepare the html table to be displayed
 
			output = "<table class='table table-hover MeeterReadTable'><tr class ='Tabletr'><th>Customers ID</th><th>Full Name</th><th>Address</th>" + "<th>City</th>" + "<th>Mobile Number</th><th>Email</th>" + "<th>Add User</th><th>Delete User</th></tr>"; 
 
			String query = "select * from Customers"; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
 
			// iterate through the rows in the result set
			while (rs.next()) { 
 
				String CustomersID = Integer.toString(rs.getInt("CustomersID")); 
				String FullName = rs.getString("FullName"); 
				String Address = rs.getString("Address"); 
				String City = rs.getString("City"); 
				String MobileNumber = rs.getString("MobileNumber"); 				
				String Email = rs.getString("Email");
 
				// Add into the html table
				output += "<tr><td>" + CustomersID + "</td>"; 
				output += "<td>" + FullName + "</td>"; 
				output += "<td>" + Address + "</td>"; 
				output += "<td>" + City + "</td>";  
				output += "<td>" + MobileNumber + "</td>";
				output += "<td>" + Email + "</td>"; 
 
				// buttons
				output += "<td>" + "<input name='adUser' id='adUser' type='button' value='Add User' class='adUser btn btn-primary'>" + "</td>";
				output += "<td>" + "<input name='delUser' id='delUser' type='button' value='Delete User' class='delUser btn btn-danger'>"+"</td></tr>"; 
 
			} 
 
			con.close(); 
			// Complete the html table
			output += "</table>"; 
			String out = "{\"status\":\"success\", \"data\":\""+output+"\"}";
			return out;
		} 
 
		catch (Exception e) { 
			System.err.println(e.getMessage()); 
			System.err.println("----- Error for Read ! -----");
			String out = "{\"status\":\"error\", \"data\":\"Error while reading the item.\"}";
			return out; 
		} 
	}

	//Read Pending One Users
	public String readPendingOneUsers(String CustomersID) { 
		 
		String output = ""; 
 
		try { 
 
			UserAssignCon userAssignCon = new UserAssignCon();
			Connection con = userAssignCon.connect();  
 
			if (con == null) {
				System.err.println("----- Connection Error for Read ! -----");
				return "Error while connecting to the database for reading."; 
			} 
 
			// Prepare the html table to be displayed
 
			output = "<table border='1'><tr><th>Customers ID</th><th>Full Name</th><th>Address</th>" + "<th>City</th>" + "<th>Mobile Number</th><th>Email</th>" + "<th>Add User</th></tr>"; 

			String query = "select * from Customers where CustomersID="+CustomersID; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
 
			// iterate through the rows in the result set
			while (rs.next()) { 
 
				String CusID = Integer.toString(rs.getInt("CustomersID")); 
				String FullName = rs.getString("FullName"); 
				String Address = rs.getString("Address"); 
				String City = rs.getString("City"); 
				String MobileNumber = rs.getString("MobileNumber"); 				
				String Email = rs.getString("Email");
 
				// Add into the html table
				output += "<tr><td>" + CusID + "</td>"; 
				output += "<td>" + FullName + "</td>"; 
				output += "<td>" + Address + "</td>"; 
				output += "<td>" + City + "</td>";  
				output += "<td>" + MobileNumber + "</td>";
				output += "<td>" + Email + "</td>"; 
 
				// buttons
				output += "<td><form method='post' action='#'>" + "<input name='btnAdd' type='submit' value='Add User' class='btn btn-danger'>" + "<input name='CustomersID' type='hidden' value='" + CustomersID  + "'>" + "</form></td></tr>"; 
 
			} 
 
			con.close(); 
			// Complete the html table
			output += "</table>"; 
		} 
 
		catch (Exception e) { 
			output = "Error while reading the items."; 
			System.err.println(e.getMessage()); 
			System.err.println("----- Error for Read ! -----");
 
		} 
 
		return output; 
	}
	
	//Insert User for Power Palnt
	public String UserAssign(String UserID, String FullName, String Address, String City, String MobileNumber, String Email, String Password, String PowerPalnt) { 
		 
		String output = ""; 
 
		try { 
 
			UserAssignCon userAssignCon = new UserAssignCon();
			Connection con = userAssignCon.connect();  
 
			if (con == null) {
				
				return "Error while connecting to the database for inserting."; 
			
			} 
 
				// create a prepared statement
				String query = " insert into PowerPlant (`id`,`UserID`,`FullName`,`Address`,`City`,`MobileNumber`,`Email`,`Password`,`PowerPlant`,`Remark`)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				 
				PreparedStatement preparedStmt = con.prepareStatement(query); 
 
				// binding values
				preparedStmt.setInt(1, 0); 
				preparedStmt.setString(2, UserID); 
				preparedStmt.setString(3, FullName); 
				preparedStmt.setString(4, Address); 
				preparedStmt.setString(5, City); 
				preparedStmt.setString(6, MobileNumber);
				preparedStmt.setString(7, Email);
				preparedStmt.setString(8, Password);
				preparedStmt.setString(9, PowerPalnt);
				preparedStmt.setString(10, "");
 
				// execute the statement
				preparedStmt.execute(); 
				con.close(); 
				output = "{\"status\":\"success\"}"; 
 
		} 
 
		catch (Exception e) { 
 
			output = "{\"status\":\"Error while Create User\"}"; 
 
			System.err.println(e.getMessage());
			System.err.println("----- Insert Error ! -----");
 
		} 
 
		return output; 
	}
	
	//Read All Users
		public String readUsers() { 
			 
			String output = ""; 
	 
			try { 
	 
				UserAssignCon userAssignCon = new UserAssignCon();
				Connection con = userAssignCon.connect();  
	 
				if (con == null) {
					System.err.println("----- Connection Error for Read ! -----");
					return "Error while connecting to the database for reading."; 
				} 
	 
				// Prepare the html table to be displayed
	 
				output = "<table class='table table-hover MeeterReadTable'><tr class ='Tabletr'><th>ID</th><th>User ID</th><th>Full Name</th><th>Address</th>" + "<th>City</th>" + "<th>Mobile Number</th><th>Email</th><th>Power Plant</th>" + "<th>Update</th></tr>"; 
	 
				String query = "select * from powerplant"; 
				Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery(query); 
	 
				// iterate through the rows in the result set
				while (rs.next()) { 
	 
					String ID = Integer.toString(rs.getInt("id"));
					String UserID = rs.getString("UserID");; 
					String FullName = rs.getString("FullName"); 
					String Address = rs.getString("Address"); 
					String City = rs.getString("City"); 
					String MobileNumber = rs.getString("MobileNumber"); 				
					String Email = rs.getString("Email");
					String PowerPlant = rs.getString("PowerPlant");
	 
					// Add into the html table
					output += "<tr><td>" + ID + "</td>";
					output += "<td>" + UserID + "</td>"; 
					output += "<td>" + FullName + "</td>"; 
					output += "<td>" + Address + "</td>"; 
					output += "<td>" + City + "</td>";  
					output += "<td>" + MobileNumber + "</td>";
					output += "<td>" + Email + "</td>";
					output += "<td>" + PowerPlant + "</td>";
	 
					// buttons
					output += "<td><input name='upuser' id='upuser' type='button' value='Update' class='upuser btn btn-danger'></td></tr>"; 
	 
				} 
	 
				con.close(); 
				// Complete the html table
				output += "</table>"; 
				String out = "{\"status\":\"success\", \"data\":\""+output+"\"}";
				return out;
			} 
	 
			catch (Exception e) { 
				
				System.err.println(e.getMessage()); 
				System.err.println("----- Error for Read ! -----");
				String out = "{\"status\":\"error\", \"data\":\"Error while reading the item.\"}";
				return out; 
			} 
	  
		}
	
	//Update Power Plant
	public String UpdatePowerPlant(String UserID, String PowerPalnt) { 

		String output = ""; 
 
		try { 
 
			UserAssignCon userAssignCon = new UserAssignCon();
			Connection con = userAssignCon.connect();  
 
			if (con == null) {
				
				return "Error while connecting to the database for updating."; 
			} 
 
			// create a prepared statement
			String query = "UPDATE PowerPlant SET PowerPlant=? WHERE UserID=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
 
			// binding values
			preparedStmt.setString(1, PowerPalnt);  
			preparedStmt.setString(2, UserID);
 
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			output = "{\"status\":\"success\"}"; 
		} 
 
		catch (Exception e) { 
			
			output = "{\"status\":\"Error while Update User\"}"; 
			System.err.println(e.getMessage()); 
		} 
 
		return output; 
 
	}
	
	//Delete Pending List
	public String DeletePendigUsers(String CustomersID) { 
		 
		String output = ""; 
 
		try { 
 
			UserAssignCon userAssignCon = new UserAssignCon();
			Connection con = userAssignCon.connect(); 
 
			if (con == null) {
				
				return "Error while connecting to the database for deleting."; 
			} 
 
			// create a prepared statement
			String query = "delete from Customers where CustomersID=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(CustomersID)); 
 
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			output = "{\"status\":\"success\"}"; 
 
		} 
 
		catch (Exception e) { 
			output = "{\"status\":\"Error while Delete\"}"; 
			System.err.println(e.getMessage()); 
 
		} 
 
		return output; 
 
	} 
}
