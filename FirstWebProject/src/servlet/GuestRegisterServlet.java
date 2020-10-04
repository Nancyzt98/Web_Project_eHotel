package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connections.PostgreSqlConn;
import entities.Room;

/**
 * Servlet implementation class GuestRegisterServlet
 */
@WebServlet("/guestRegister")

public class GuestRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
		HttpSession session = req.getSession();
//		employee account = new employee();
		String guestName = req.getParameter("guestName");
		String guest_SSN = req.getParameter("guest_SSN");
		String guestAddress = req.getParameter("guestAddress");
		String guestEmail = req.getParameter("guestEmail");
		String guestPhone = req.getParameter("guestPhone");
		String guestPwd = req.getParameter("guestPwd");
		
		String[] param = new String[] {guestName,guest_SSN,guestAddress,guestEmail,guestPhone,guestPwd};
		
		PostgreSqlConn con = new PostgreSqlConn();
		boolean pwdfromdb = con.insertNewGuest(param);
		
		System.out.println(pwdfromdb);
		resp.sendRedirect("RegisterSuccess.jsp");
		
//		if (pwdfromdb) {			
//				System.out.println("success");
//				
//				ArrayList<Room> bookedRooms = con.getbookedRooms(guestName);
//				
//				ArrayList<Room> allRooms = con.getAllAvailRooms();
//				
//				System.out.println(allRooms);
//				
//				req.setAttribute("guestName", guestName);
//				req.setAttribute("bookedRooms", bookedRooms);
//				req.setAttribute("allRooms", allRooms);
//
//				req.getRequestDispatcher("booking.jsp").forward(req, resp);
//				return;			
//		}   
//		resp.sendRedirect("register_failure.jsp");
		return;
	}

}
