package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Cart;
import models.Clothe;
import models.ClothesDAO;
import models.Customer;

@SuppressWarnings("serial")
@WebServlet("/fetchCart")
public class FetchCart extends HttpServlet {
		
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClothesDAO dao = new ClothesDAO();
		String findEmail = (String) session.getAttribute("loggedInEmail");
		Customer customer = dao.getCustomerEmail(findEmail);
		ArrayList<Cart> cart = dao.getCartByUser(customer.getId()); 
		
		request.setAttribute("cart",cart);
		RequestDispatcher rd = request.getRequestDispatcher("view/cart.jsp");
		rd.forward(request, response);
	}
}
