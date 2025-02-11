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

@WebServlet("/fetchOrder")
public class FetchOrder extends HttpServlet  {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClothesDAO dao = new ClothesDAO();
		String findEmail = (String) session.getAttribute("loggedInEmail");
		Customer customer = dao.getCustomerEmail(findEmail);
		ArrayList<Order> order = dao.getOrderByUser(customer.getId()); 
		
		request.setAttribute("order",order);
		RequestDispatcher rd = request.getRequestDispatcher("view/ordered.jsp");
		rd.forward(request, response);
		
	}
}
