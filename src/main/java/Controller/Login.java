package Controller;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.CustomerDB;

@WebServlet("/login")
public class Login extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("Id");
		String password = request.getParameter("pass");
		
		CustomerDB sdb = new CustomerDB();
		boolean isValid = sdb.checkLogin(id,password);
		
		HttpSession session = request.getSession();
		if (isValid) {
			session.setAttribute("loggedInId",id);
			response.sendRedirect("StudentProfile.jsp");
		}
		else {
			session.setAttribute("loginError", "Invalid ID or PWD");
			response.sendRedirect("Login.jsp");
		}
	}

}
