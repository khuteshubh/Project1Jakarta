package example.jdbc;

import java.util.Collection;

import example.jdbc.been.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;
public class RetrieveAllUsingDaoExample {

	public static void main(String[] args) {
    
		DaoInterface<Restaurant,Integer> daoRef = new RestaurantDao();
        Collection<Restaurant> allAvailablesRestaurants =daoRef.retrieveAll();
        for(Restaurant currentRestaurant: allAvailablesRestaurants)
        	System.out.println(currentRestaurant);
        System.out.println("===============");
        allAvailablesRestaurants.stream().forEach(rst -> System.out.println(rst));
	}

}
