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


@WebServlet("/MainPage")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public MainPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("login");
		ArrayList<TopRecipe> topRecipe = RecipeDao.GetTop5Recipes();
		request.setAttribute("login", userName);
		for (int recipePosition=0; recipePosition<topRecipe.size(); recipePosition++) {
			int htmlPosition = recipePosition+1;
			request.setAttribute("top"+ htmlPosition +"RecipeRating", topRecipe.get(recipePosition).getRate());
			request.setAttribute("top"+ htmlPosition +"RecipeName", topRecipe.get(recipePosition).getRecipeName());
			request.setAttribute("top"+ htmlPosition +"RecipeCategory", topRecipe.get(recipePosition).getCategoryName());
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/MainPage.jsp");
        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
