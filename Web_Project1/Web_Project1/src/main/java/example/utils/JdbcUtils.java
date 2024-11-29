package example.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
	//This is a utility class for obtaining a connection and returning the same.
	public static Connection getConnection() throws Exception{
		//Here class.forName is not used because it is not needed.
		//The driver gets loaded automatically.
		Class.forName("com.mysql.cj.Driver");
		String url = "jdbc:mysql://localhost:8888/zomato";
		String uid = "root";
		String pwd = "password";
		Connection dbConnection = 
				DriverManager.getConnection(url,uid,pwd);
		return dbConnection;
		
		
	}

}
