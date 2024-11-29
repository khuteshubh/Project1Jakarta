package example.jdbc;

import example.jdbc.been.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class CreateUsingDaoExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoInterface<Restaurant,Integer> daoRef = new RestaurantDao();
		Restaurant rst = new Restaurant(106,"Maninland china","Chinese",5);
		daoRef.create(rst);

	}

}
