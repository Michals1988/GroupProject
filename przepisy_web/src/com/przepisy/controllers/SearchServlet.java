package com.przepisy.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.przepisy.dao.RecipeDao;
import com.przepisy.models.TopRecipe;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<TopRecipe> listFoundRecipe;

    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("login");
		request.setAttribute("login", userName);
		
		for (int recipePosition=0; recipePosition<listFoundRecipe.size(); recipePosition++) {
			int htmlPosition = recipePosition+1;
			request.setAttribute("found"+ htmlPosition +"RecipeRating", listFoundRecipe.get(recipePosition).getRate());
			request.setAttribute("found"+ htmlPosition +"RecipeName", listFoundRecipe.get(recipePosition).getRecipeName());
			request.setAttribute("found"+ htmlPosition +"RecipeCategory", listFoundRecipe.get(recipePosition).getCategoryName());
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/searchPage.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchInput = request.getParameter("mainPage_Search");
		
		listFoundRecipe = RecipeDao.GetRecipeListByName(searchInput);
		
		doGet(request, response);
	}

}
