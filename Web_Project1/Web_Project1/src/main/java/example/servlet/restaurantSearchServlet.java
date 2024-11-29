package example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;

import example.Dao.DaoInterface;
import example.bean.Restaurant;

 import example.jdbc.dao.RestaurantDao;

/**
 * Servlet implementation class restaurantSearchServlet
 */
@WebServlet("/search")
public class restaurantSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("r_id");
		int restaurantId = Integer.parseInt(id);
		DaoInterface<Restaurant,Integer> daoRef = new RestaurantDao();
		Restaurant foundRestaurant = daoRef.retrieveOne(restaurantId);
		
	    if(foundRestaurant == null){
	    
	    //obtain requestDispatcher for search_restaurant.html
	    // Display appropriate message and divert the control to that html
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("display");
	    out.println("<h2>Restaurant with given id</h2>");	 
	    dispatcher.include(request,response);   
	    
	    }else{
	    
	     //obtain requestDispatcher data to the current request
	     //attach the request data to the current request
	     //forward the request to the next servlet
	     
	     RequestDispatcher dispatcher=
	                             request.getRequestDispatcher("display");
	     //Attach the restaurant data to the current request
	     request.setAttribute("searchedRestaurant",foundRestaurant);
	     dispatcher.forward(request, response);
	     
	    }
	    
//		doGet(request, response);
	}

}
