package controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import models.Cart;
import models.ClothesDAO;
import models.Customer;


@SuppressWarnings("serial")
@WebServlet("/cart")
public class AddToCart extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String cartId = null; // initialize cartId to a non-null value
	    String id = request.getParameter("id");
	    HttpSession session = request.getSession();
	    String findEmail = (String) session.getAttribute("loggedInEmail");
	    ClothesDAO dao = new ClothesDAO();
	    Customer customer = dao.getCustomerEmail(findEmail);
	    
	    Cart cart = new Cart(cartId, id, id, customer.getId());
	    String message = dao.createCart(cart);
	    
	    // set the message as an attribute of the request
	    //request.setAttribute("message", message);
	    
	    response.sendRedirect("view/product");
	    // forward the request to a JSP page that can display the message
	    //request.getRequestDispatcher("view/product").forward(request, response);
	}

}
