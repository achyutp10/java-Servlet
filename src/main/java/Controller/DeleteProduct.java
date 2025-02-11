package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Clothe;
import models.ClothesDAO;

@SuppressWarnings("serial")
@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String product = new ClothesDAO().deleteProductById(id);
		request.setAttribute("product",product);
		RequestDispatcher rd = request.getRequestDispatcher("admin");
		rd.forward(request, response);
	}
}
