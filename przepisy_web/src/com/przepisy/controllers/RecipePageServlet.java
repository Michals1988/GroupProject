package com.przepisy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.przepisy.dao.RecipeDao;
import com.przepisy.models.Recipe;

@WebServlet("/RecipePage")
public class RecipePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RecipePageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("login");
		request.setAttribute("login", userName);
		String recipeId = request.getParameter("hiddenRecipeId");
		Recipe recipe = RecipeDao.GetFullRecipe(recipeId);
		
		request.setAttribute("recipeName", recipe.recipe_header.getName());
		request.setAttribute("recipeId", recipe.recipe_header.getId());
		request.setAttribute("recipeNote", recipe.recipe_header.getNote());
		request.setAttribute("recipeDescr", recipe.recipe_header.getDescription());
		request.setAttribute("userName", recipe.recipe_header.getUserName());
		request.setAttribute("dataCreation", recipe.recipe_header.getData_creation());
		request.setAttribute("videoLink", recipe.recipe_header.getVideo_link());
		request.setAttribute("categoryName", recipe.recipe_header.getCategoryCode());
		request.setAttribute("recipeRate", recipe.recipe_header.getRate());
		
		request.setAttribute("components", recipe.recipe_row);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/recipeSite.jsp");
        dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
