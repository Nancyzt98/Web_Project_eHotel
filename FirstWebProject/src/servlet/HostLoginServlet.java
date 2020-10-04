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
 * Servlet implementation class HostLoginServlet
 */
@WebServlet("/HostLoginServlet")
public class HostLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HostLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = req.getSession();
//		employee account = new employee();
		String host_SSN = req.getParameter("host_SSN");
		String upass = req.getParameter("upass");
		
		PostgreSqlConn con = new PostgreSqlConn();
//		[0]:name,[1]:pwd
		ArrayList<Room> bookedRooms = con.getbookedRooms(host_SSN);
		
		ArrayList<Room> allRooms = con.getAllAvailRooms();
		
		req.setAttribute("bookedRooms", bookedRooms);
		req.setAttribute("allRooms", allRooms);
		req.getRequestDispatcher("Host_LoginMenu.html").forward(req, resp);
		
		return;
	}

}
