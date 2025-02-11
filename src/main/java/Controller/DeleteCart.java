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
@WebServlet("/deleteCart")
public class DeleteCart extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String cart = new ClothesDAO().deleteCartById(id);
		request.setAttribute("cart",cart);
		RequestDispatcher rd = request.getRequestDispatcher("/fetchCart");
		rd.forward(request, response);
	}
}