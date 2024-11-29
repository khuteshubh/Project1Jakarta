package example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.been.Restaurant;
import example.jdbc.utils.JdbcUtils;

public class RestaurantDao implements DaoInterface<Restaurant,Integer> {

	@Override
	public Collection<Restaurant> retrieveAll() {
		/* This method connects to DB, fetches all record, convert them
		into java objects of restaurant class, puts those objects into some
		collection and returns  the collection
		*/
		Collection<Restaurant> allRestaurants = new ArrayList<>();
		String sqlQuery = "select * from  resutaurant_master";
		try (
				Connection conn = JdbcUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				){
			while(rs.next()) {
				int restaurantId = rs.getInt(1);
				String restaurantName = rs.getString(2);
				int branchCount = rs.getInt(4);
				String restaurantCuisine = rs.getString(3);
				Restaurant rst = new Restaurant(restaurantId,restaurantName,restaurantCuisine,branchCount);
				allRestaurants.add(rst);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
         return allRestaurants;
	}

	@Override
	public Restaurant retrieveOne(Integer id) {
		// TODO Auto-generated method stub
		Restaurant foundRestaurant = null;
		String sqlQuery = "select * from resutaurant_master where  rest_id = ?";
		try (
				Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
				
				)
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int restaurantId = rs.getInt(1);
				String restaurantName = rs.getString(2);
				int branchCount = rs.getInt(4);
				String restaurantCuisine = rs.getString(3);
				foundRestaurant = new Restaurant(restaurantId,restaurantName,restaurantCuisine,branchCount);
				
			}
			
		}catch(Exception ex){
		    ex.printStackTrace();	
		}
		return foundRestaurant;
	}
		
	    @Override
		public void create(Restaurant newRestaurant){
//			This method accepts a 'restaurant' object;newRestaurant and stores it as a record in the DB table
			String sqlQuery=
					"insert into resutaurant_master values(?,?,?,?)";
			try (
					Connection conn = JdbcUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
					
					)
			{
//				Extracting the values from restaurant object newRestaurant
//				using getter methods.
				int restaurantId = newRestaurant.getRestaurantId();
				String restaurantName = newRestaurant.getName();
				String restaurantCuisine = newRestaurant.getCuisine();
				int restaurantBranchCount = newRestaurant.getBranchCount();
				pstmt.setInt(1, restaurantId);
				pstmt.setString(2, restaurantName);
				pstmt.setString(3, restaurantCuisine);
				pstmt.setInt(4, restaurantBranchCount);
				int updateCount = pstmt.executeUpdate();
				System.out.println(updateCount + " record Inserted.");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			
		
	}
	    @Override
	    public void update(Restaurant modifiedRestaurant) {
//	    	This method receives the modified state of the restaurant
//	    	object:modifiesRestaurant and reflects that state into DB
	    	String sqlQuery=
					"update into resutaurant_master set rest_name=?,rest_cuisine=?,rest_branch_count=? where rest_id=?";
	    	try (
					Connection conn = JdbcUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
					
					)
			{
//	    		capturing the modified state of restaurant object:modifiedRestaurant 
	    		int restaurantId = modifiedRestaurant.getRestaurantId();
				String restaurantName = modifiedRestaurant.getName();
				String restaurantCuisine = modifiedRestaurant.getCuisine();
				int restaurantBranchCount = modifiedRestaurant.getBranchCount();
				pstmt.setInt(4, restaurantId);
				pstmt.setString(1, restaurantName);
				pstmt.setString(2, restaurantCuisine);
				pstmt.setInt(3, restaurantBranchCount);
				int updateCount = pstmt.executeUpdate();
				System.out.println(updateCount + " record updated.");
	       }
	    	catch(Exception ex) {
	    	ex.printStackTrace();
	    	}
	    
	    }
	    
	    @Override
	    public void delete(Integer id) {
//	    	this method perform record deletion against identity
	    	String sqlQuery=
	    			"delete from resutaurant_master where rest_id=?";
	    	try (
					Connection conn = JdbcUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
					
					)
			{
	    		pstmt.setInt(1,id);
	    		int updateCount = pstmt.executeUpdate();
	    		System.out.println(updateCount + " record deleted");
			}
	    	catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
	    }
	
	
	
	    
	

}
