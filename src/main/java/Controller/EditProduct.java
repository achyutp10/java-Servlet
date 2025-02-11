package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Clothe;
import models.ClothesDAO;

@SuppressWarnings("serial")
@WebServlet("/editProduct")
public class EditProduct extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Clothe product = new ClothesDAO().getProductById(id);
		request.setAttribute("product",product);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/editProduct.jsp");
		rd.forward(request, response);
	}
}
