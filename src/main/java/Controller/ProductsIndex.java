package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Clothe;
import models.ClothesDAO;

@SuppressWarnings("serial")
@WebServlet("/view/index")
public class ProductsIndex extends HttpServlet {
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String sortOption = request.getParameter("sort");
			ClothesDAO sdao = new ClothesDAO();
			ArrayList<Clothe> clotheList =  sdao.fetchClothe();
			
			 // sort products if sort option is provided
	        if (sortOption != null && !sortOption.isEmpty()) {
	            switch (sortOption) {
	                case "name_asc":
	                	clotheList = sdao.sortByNameAsc();
	                    break;
	                case "name_desc":
	                	clotheList = sdao.sortByNameDesc();
	                    break;
	                case "price_desc":
	                	clotheList = sdao.sortByPriceDesc();
	                    break;
	                case "rating_desc":
	                	clotheList = sdao.sortByRatingDesc();
	                    break;
	                default:
	                    // do nothing
	            }
	        }
			
			request.setAttribute("clotheList",clotheList);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
}
