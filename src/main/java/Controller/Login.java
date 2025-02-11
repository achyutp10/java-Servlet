package controller;


import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.AESEncryption;
import models.ClothesDAO;
import models.Customer;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String encryptedPassword = AESEncryption.encrypt(password);
		
		ClothesDAO log = new ClothesDAO();
		boolean isValid = log.loginUser(email, encryptedPassword);
		
		HttpSession session = request.getSession();
		session.setAttribute("loggedInEmail", email);
		
		if (isValid) {
			Customer cust = log.getCustomerEmail(email);
			session.setAttribute("loggedInRole", cust.getRole());
			if (cust.getRole().equals("admin")) {
				response.sendRedirect("admin");
			}
			else {
				response.sendRedirect("view/index");
			}
		}
		else {
			session.setAttribute("loginError", "Invalid id or password");
			response.sendRedirect("view/login.jsp");
		}
	}
}