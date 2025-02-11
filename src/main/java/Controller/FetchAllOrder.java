package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.ClothesDAO;
import models.Customer;
import models.Order;

@WebServlet("/fetchAllOrder")
public class FetchAllOrder extends HttpServlet  {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClothesDAO dao = new ClothesDAO();
		ArrayList<Order> order = dao.getOrders(); 
		request.setAttribute("order",order);
		RequestDispatcher rd = request.getRequestDispatcher("view/adminOrders.jsp");
		rd.forward(request, response);
		
	}
}