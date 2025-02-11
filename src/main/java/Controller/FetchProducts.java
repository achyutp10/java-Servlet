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
@WebServlet("/admin")
public class FetchProducts extends HttpServlet {
		
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		ClothesDAO sdao = new ClothesDAO();
		ArrayList<Clothe> clotheList =  sdao.fetchClothe();
		request.setAttribute("clotheList",clotheList);
		RequestDispatcher rd = request.getRequestDispatcher("view/adminPanel.jsp");
		rd.forward(request, response);
	}
}


