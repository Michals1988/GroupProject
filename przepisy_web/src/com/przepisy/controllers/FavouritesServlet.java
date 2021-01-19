package com.przepisy.controllers;

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

import com.przepisy.dao.CategoriesDao;
import com.przepisy.dao.FavouritesDao;
import com.przepisy.dao.RecipeDao;
import com.przepisy.models.Categories;
import com.przepisy.models.TopRecipe;

@WebServlet("/FavouritesServlet")
public class FavouritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FavouritesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("id");
		String userName = (String) session.getAttribute("login");
		request.setAttribute("login", userName);
		generateCategoriesList(request, response);
		
		ArrayList<TopRecipe> favouritesRecipes = RecipeDao.GetFavouritesRecipes(userId);
		/*for (int recipePosition=0; recipePosition<favouritesRecipes.size(); recipePosition++) {
			int htmlPosition = recipePosition+1;
			request.setAttribute("fav"+ htmlPosition +"RecipeRating", favouritesRecipes.get(recipePosition).getRate());
			request.setAttribute("fav"+ htmlPosition +"RecipeName", favouritesRecipes.get(recipePosition).getRecipeName());
			request.setAttribute("fav"+ htmlPosition +"RecipeCategory", favouritesRecipes.get(recipePosition).getCategoryName());
		}*/
		request.setAttribute("favouritesRecipes", favouritesRecipes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Favourites.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("id");
		String recipeId = request.getParameter("recipeId");
		
		int result = 0;
		ArrayList<String> favIds = FavouritesDao.GetFavouritesIds(userId);
		for (int i=0; i<favIds.size(); i++) {
			if (favIds.get(i).contains(recipeId)) {
				result++;
			}
		}
		
		if (result == 0) {
			FavouritesDao.InsertFavourite(recipeId, userId);
		} 			
		
		doGet(request, response);
	}
	
	private void generateCategoriesList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categories> listCategories = CategoriesDao.listAllActiveCategories();
        request.setAttribute("listCategories", listCategories);
                             
        for (Categories x: listCategories) {
            System.out.println(x.getCode());
        }

	}
}
