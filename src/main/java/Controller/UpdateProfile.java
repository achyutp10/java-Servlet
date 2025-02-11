package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.Customer;
import models.AESEncryption;
import models.ClothesDAO;


@SuppressWarnings("serial")
@WebServlet("/updateProfile")
@MultipartConfig
public class UpdateProfile extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String encryptedPassword = AESEncryption.encrypt(password);
		String relativePath = "customerImage/"+id+".png";
		String role = request.getParameter("role");
	
		Customer customer = new Customer(id, name, gender, address, phone, email, encryptedPassword, relativePath, role);
		ClothesDAO dao = new ClothesDAO();
		String message = dao.updateProfile(customer);
				
		
		Part image = request.getPart("photo");
		if(message.equals("Successfully Updated") && image!=null && image.getInputStream().available() > 0) {
		
			String imagePath = getServletContext().getInitParameter("imagePath");
			String fullPath = imagePath+relativePath;
			image.write(fullPath);
		}
		response.sendRedirect("view/profile");
	}
}
