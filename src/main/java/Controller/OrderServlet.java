package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Cart;
import models.ClothesDAO;
import models.Customer;
import models.Order;


@WebServlet("/view/checkout")
public class OrderServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] products = request.getParameterValues("productId");
		String[] cartId = request.getParameterValues("cartId");
		ClothesDAO dao = new ClothesDAO();
		HttpSession session = request.getSession();
		String findEmail = (String) session.getAttribute("loggedInEmail");
		Customer customer = dao.getCustomerEmail(findEmail);
		String[] prices = request.getParameterValues("price");
		String[] quantities = request.getParameterValues("quantity");
		String id = null;
		
		double totalPrice = 0;
		for (int i = 0; i < products.length; i++) {
			
		    String product = products[i];
		    double price = Double.parseDouble(prices[i]);
		    int quantity = Integer.parseInt(quantities[i]);
		    
		    
		    double setTotal = price * quantity;
			String setPrice = Double.toString(setTotal);
			
		    Order order = new Order(id, product, setPrice, quantities[i], customer.getId());
		    String message = dao.createOrder(order);
		    if (message.equals("Successfully Added")) {
		    	dao.deleteCartById(cartId[i]);
			    double total = price * quantity;
			    totalPrice+=total;
			    response.sendRedirect("../fetchCart");
		    }
		    else {
		    	response.sendRedirect("../fetchCart");
		    }
		}
		System.out.println(totalPrice);
	}

	private String toString(double d) {
		// TODO Auto-generated method stub
		return null;
	}
}