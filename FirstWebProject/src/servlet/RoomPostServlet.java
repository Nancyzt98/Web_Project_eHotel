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
 * Servlet implementation class RoomPostServlet
 */
@WebServlet("/roomPostServlet")
public class RoomPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomPostServlet() {
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
		String propType = req.getParameter("propType");
		String roomType = req.getParameter("roomType");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String price = req.getParameter("price");
		String paymentType = req.getParameter("paymentType");
//		String room_status = req.getParameter("room_status");
//		String guest_SSN = req.getParameter("guest_SSN");
		String branch_id = req.getParameter("branch_id");
		String host_SSN = req.getParameter("host_SSN");
		
		String[] param = new String[] {propAddress,propType,roomType,startDate,endDate,price,paymentType,"available","",branch_id,"",host_SSN};
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		boolean result = con.insertNewProperty(param);
		
//		Room room = new Room();
//		room.setPropAddress(propAddress);
//		room.setPropType(propType);
//		room.setRoomType(roomType);
//		room.setStartDate(startDate);
//		room.setEndDate(endDate);
//		room.setPrice(price);
//		room.setPaymentType(paymentType);
//		room.setRoom_status("available");
//		room.setBranch_id(branch_id);
//		Room room = new Room(propAddress,propType,roomType,startDate,endDate,price,paymentType,"available","",branch_id);
		
		ArrayList<Room> allRooms = con.getAllAvailRooms();

		req.setAttribute("allRooms", allRooms);
		resp.getWriter().println("Submit Successfully!");
//		resp.sendRedirect("Host_LoginMenu.html");
		return;
	
	}

}
