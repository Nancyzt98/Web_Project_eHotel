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

/**
 * Servlet implementation class HostRegisterServlet
 */
@WebServlet("/hostRegister")
public class HostRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HostRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
//		employee account = new employee();
		String houseNum = req.getParameter("houseNum");
		String houseStr = req.getParameter("houseStr");
		String houseCity = req.getParameter("houseCity");
		String houseProv = req.getParameter("houseProv");
		String hostName = req.getParameter("hostName");
		String host_SSN = req.getParameter("host_SSN");
		String hostEmail = req.getParameter("hostEmail");
		String hostPhone = req.getParameter("hostPhone");
		String hostPwd = req.getParameter("hostPwd");
		
		String[] param = new String[] {houseNum,houseStr,houseCity,houseProv,hostName,host_SSN,hostEmail,hostPhone,hostPwd};
		
		PostgreSqlConn con = new PostgreSqlConn();
		boolean pwdfromdb = con.insertNewHost(param);
		
		System.out.println(pwdfromdb);
		
//		if (pwdfromdb) {			
//				System.out.println("success");
//				
//				ArrayList<Room> bookedRooms = con.getbookedRooms(hostName);
//				
//				ArrayList<Room> allRooms = con.getAllAvailRooms();
//				
//				System.out.println(allRooms);
//				
//				req.setAttribute("hostName", hostName);
//				req.setAttribute("bookedRooms", bookedRooms);
//				req.setAttribute("allRooms", allRooms);
//
//				req.getRequestDispatcher("booking.jsp").forward(req, resp);
//				return;			
//		}
//		resp.sendRedirect("register_failure.jsp");
		System.out.println("success");
		return;
	}
}
