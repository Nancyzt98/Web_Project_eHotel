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
 * Servlet implementation class RoomBookServlet
 */
@WebServlet("/roomBook")
public class RoomBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomBookServlet() {
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
		String propAddress = req.getParameter("propAddress");
//		String propType = req.getParameter("propType");
//		String roomType = req.getParameter("roomType");
//		String startDate = req.getParameter("startDate");
//		String endDate = req.getParameter("endDate");
//		String price = req.getParameter("price");
//		String paymentType = req.getParameter("paymentType");
//		String room_status = req.getParameter("room_status");
		String guest_SSN = req.getParameter("guest_SSN");
//		String branch_id = req.getParameter("branch_id");
		
		PostgreSqlConn con = new PostgreSqlConn();
		String userSSN = con.bookRoom(guest_SSN,propAddress);
		
		ArrayList<Room> allRooms = con.getAllAvailRooms();
		req.setAttribute("allRooms", allRooms);
		

		ArrayList<Room> bookedRooms = con.getbookedRooms(userSSN);
		req.setAttribute("bookedRooms", bookedRooms);
		
		

		req.getRequestDispatcher("booking.jsp").forward(req, resp);
		return;	
		
	}

}
