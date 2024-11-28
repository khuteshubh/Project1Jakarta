package example.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;

import java.io.PrintWriter;

import example.bean.Restaurant;


/**
 * Servlet implementation class restauranDisplayServlet
 */
@WebServlet("/restauranDisplayServlet")
public class restauranDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public restauranDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Object obj = request.getAttribute("searchedRestaurnat");
		Restaurant currentRestaurant = (Restaurant)obj;
		String name = currentRestaurant.getName();
		String cuisine = currentRestaurant.getCuisine();
		int branchCount = currentRestaurant.getBranchCount();
		out.println("<h1>Restaurant Details:</h1>");
		out.println("<h2>Name: " +name+ "</h2>");
		out.println("<h2>Cuisine: " + cuisine + "</h2>");
		out.println("<h2>BranchCount: " + branchCount + "</h2>");
		
		
	}

}
