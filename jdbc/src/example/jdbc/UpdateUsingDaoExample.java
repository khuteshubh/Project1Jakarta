package example.jdbc;

import example.jdbc.been.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class UpdateUsingDaoExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoInterface<Restaurant,Integer> daoRef = new RestaurantDao();
		Restaurant rst = daoRef.retrieveOne(104);
        //changing the name and branch count using setter
		rst.setName("New Little Italy");
		rst.setBranchCount(20);
		daoRef.update(rst);
		System.out.println("Data updated");
		
		
	}

}
