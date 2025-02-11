package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import models.Clothe;
import models.ClothesDAO;

@SuppressWarnings("serial")
@WebServlet("/addProduct")
@MultipartConfig
public class AddProduct extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String stock = request.getParameter("stock");
		String category = request.getParameter("category");
		String rating = request.getParameter("rating");
		String brand = request.getParameter("brand");
		String relativePath = "productImage/"+id+".png";
		
		Clothe clothe = new Clothe(id, name, relativePath, price, stock, category, rating, brand);
		ClothesDAO pDao = new ClothesDAO();
		String message = pDao.addProduct(clothe);
		
		HttpSession session = request.getSession();
		session.setAttribute("SuccessMessage", message);

		
		if(message.equals("Successfully Added")) {
			Part image = request.getPart("image");
			String imagePath = getServletContext().getInitParameter("imagePath");
			String fullPath = imagePath+relativePath;
			image.write(fullPath);
		}
		
		response.sendRedirect("view/addProduct.jsp");
		
	}
}
