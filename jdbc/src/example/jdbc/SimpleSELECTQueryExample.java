package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSELECTQueryExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Load the driver
		String driverClassname = "com.mysql.cj.jdbc.Driver";
		String  url = "jdbc:mysql://localhost:3306/zomato";
		String uid = "root";
		String pwd = "password";
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driverClassname);
			System.out.println("Driver loaded");
			//Establish the connection
			 dbConnection = DriverManager.getConnection(url,uid,pwd);
			System.out.println("Connected to Db");
//			Obtain some statement
			stmt =  dbConnection.createStatement();
			System.out.println("obtain the statement");
//			Execute SQl Query
			String sqlQuery = "select rest_name, rest_branch_count, rest_cuisine from resutaurant_master";

			rs = stmt.executeQuery(sqlQuery);
			System.out.println("Executed sql select and obtained ResultSet");
			
//		    In case of select query,obtain ResultSet and perform navigation
			while(rs.next()) {
				String restaurantName = rs.getString(1);
				int branchCount = rs.getInt(2);
				String restaurantCuisine = rs.getString(3);
				System.out.println(restaurantName + ":" + branchCount +":" + restaurantCuisine);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to proceed");
		}
		finally {
//			Closing all the resources : ResultSet,Statement,connection
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		



		
		

	}

}
