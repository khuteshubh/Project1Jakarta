package example.jdbc;

import example.jdbc.been.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class RetrieveOneUsingDaoExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoInterface<Restaurant,Integer> daoRef = new RestaurantDao();
		
		 Restaurant restaurantObj = daoRef.retrieveOne(105);
		 if(restaurantObj != null) {
			 System.out.println(restaurantObj);
			 
		 }else {
			 System.out.println("Restaurant with given ID does not exits.");
		 }
	     

	}

}
