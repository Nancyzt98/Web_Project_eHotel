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
 * Servlet implementation class GuestLoginServlet
 */
@WebServlet("/guestlogin")
public class GuestLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestLoginServlet() {
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
//		employee account = new employee();
		String guest_SSN = req.getParameter("guest_SSN");
		String upass = req.getParameter("upass");
		
		PostgreSqlConn con = new PostgreSqlConn();
//		[0]:name,[1]:pwd
//		String[] pwdfromdb = con.getuserinfobyguestSSN(guest_SSN);
		
		ArrayList<Room> bookedRooms = con.getbookedRooms(guest_SSN);
		
		ArrayList<Room> allRooms = con.getAllAvailRooms();
		
		req.setAttribute("bookedRooms", bookedRooms);
		req.setAttribute("allRooms", allRooms);
		req.getRequestDispatcher("booking.jsp").forward(req, resp);
		
//		req.getRequestDispatcher("Guest_LoginMenu.html").forward(req, resp);
		return;
	
	}

}
