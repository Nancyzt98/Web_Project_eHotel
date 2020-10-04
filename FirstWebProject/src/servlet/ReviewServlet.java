package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connections.PostgreSqlConn;
import entities.Room;
import entities.Employee;
/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/reviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String ratings = req.getParameter("ratings");
		String cleanliness = req.getParameter("cleanliness");
		String review = req.getParameter("review");
		String propAddress = req.getParameter("propAddress");
		
		String[] param = new String[] {ratings,cleanliness,review,propAddress};
		PostgreSqlConn con = new PostgreSqlConn();
		boolean result = con.insertReviews(param);
		boolean rs = con.updatePropertyReviews(ratings,propAddress);
		resp.getWriter().println("Submit Successfully!");
		return;
	}

}
