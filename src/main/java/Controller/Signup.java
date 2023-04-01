package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.CustomerDB;
@WebServlet("/registration")

public class Signup extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name = request.getParameter("custName");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		System.out.println(name+email+password);
		
		CustomerDB cdb = new CustomerDB();
		String message = cdb.signup(name, email, password);
		
		PrintWriter out = response.getWriter();
		out.println("<h1>"+message+"</h1");
		
		response.setContentType("text/html");
	}

}
