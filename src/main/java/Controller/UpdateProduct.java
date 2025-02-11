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

import models.Clothe;
import models.ClothesDAO;


@SuppressWarnings("serial")
@WebServlet("/updateProduct")
@MultipartConfig
public class UpdateProduct extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String stock = request.getParameter("stock");
		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		String rating = request.getParameter("rating");
		String relativePath = "productImage/"+id+".png";
	
		Clothe clothe = new Clothe(id, name, relativePath, price, stock, category, rating, brand);
		ClothesDAO dao = new ClothesDAO();
		String message = dao.updateProduct(clothe);
		HttpSession session = request.getSession();
		session.setAttribute("Message", message);
		
		Part image = request.getPart("photo");
		if(message.equals("Successfully Updated") && image!=null && image.getInputStream().available() > 0) {
		
			String imagePath = getServletContext().getInitParameter("imagePath");
			String fullPath = imagePath+relativePath;
			image.write(fullPath);
		}
		response.sendRedirect("editProduct?id="+id);
	}
}