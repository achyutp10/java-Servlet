package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import models.AESEncryption;
import models.ClothesDAO;
import models.Customer;

@SuppressWarnings("serial")
@WebServlet("/registration")
@MultipartConfig
public class Signup extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("custName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String encryptedPassword = AESEncryption.encrypt(password);
		String relativePath = "customerImage/"+id+".png";
		String role = "normal";
		
		Customer customer = new Customer(id, name, gender, address, phone, email, encryptedPassword, relativePath, role);
		
		ClothesDAO sdao = new ClothesDAO();
		String message = sdao.registerUser(customer);
		
		

		HttpSession session = request.getSession();
		session.setAttribute("RegisterMessage", message);
		
		
		if(message.equals("Successfully Added")) {
			Part image = request.getPart("profile");
			String imagePath = getServletContext().getInitParameter("imagePath");
			String fullPath = imagePath+relativePath;
			image.write(fullPath);
		}
		
		response.sendRedirect("view/login.jsp");
		
	}
}
