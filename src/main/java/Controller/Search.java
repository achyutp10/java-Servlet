package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ClothesDAO;
import models.Clothe;

@WebServlet("/view/search")
public class Search extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("search");
        ClothesDAO sdao = new ClothesDAO();
        ArrayList<Clothe> clotheList;
        if (query != null && !query.isEmpty()) {
            // if the query parameter is provided, fetch the matching products
            clotheList = sdao.fetchClotheName(query);
            
        } else {
            // otherwise, fetch all the products
            clotheList = sdao.fetchClothe();
        }
        
       
        request.setAttribute("clotheListSearch", clotheList);
        RequestDispatcher rd = request.getRequestDispatcher("index");
        rd.forward(request, response);
    }
}
