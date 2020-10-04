package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connections.PostgreSqlConn;
import entities.Employee;

/**
 * Servlet implementation class EmployeeLoginServlet
 */
@WebServlet("/employeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		
		PostgreSqlConn con = new PostgreSqlConn();
//		String pwdfromdb = con.getpwdbyUname(uname);
		
		
//		if (upass.equals(pwdfromdb)) {			
//				System.out.println("success");
//				req.setAttribute("employee_id", uname);
//				resp.sendRedirect("login_success.jsp?employee_id="+uname);
//				return;			
//		}
		resp.sendRedirect("Employee_LoginMenu.html");
		return;
	}

}
