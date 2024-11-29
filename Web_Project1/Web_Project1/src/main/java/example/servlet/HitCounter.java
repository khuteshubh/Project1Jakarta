package example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HitCounter
 */
@WebServlet("/hitCounter")
public class HitCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitCounter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//obtaining httpsession
		HttpSession session = request.getSession();
		boolean newSession = session.isNew();
		int countValue = 0 ;
		if(newSession) {
			countValue = 1;
			
			
		}else {
			Integer currentCount = (Integer)session.getAttribute("counterValue");
			countValue = currentCount + 1;
			
		}
		session.setAttribute("counterValue",countValue);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("Context.html");
		out.println("<h1>Hit Count: "+ countValue +" </h1>");
		dispatcher.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
