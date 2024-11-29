package example.jdbc;

import example.jdbc.been.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class DeleteUsingDaoExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoInterface<Restaurant,Integer> daoRef = new RestaurantDao();
		daoRef.delete(101);

	}

}
