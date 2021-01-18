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
import com.przepisy.dao.RatesDao;
import com.przepisy.dao.RecipeDao;
import com.przepisy.models.Categories;
import com.przepisy.models.Recipe;
import com.przepisy.models.RecipeComponents;

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
		String recipeId = request.getParameter("recipeId");
		Recipe recipe = RecipeDao.GetFullRecipe(recipeId);
		generateCategoriesList(request, response);
		ArrayList<RecipeComponents> recipeComponents = new ArrayList<>();
		
		request.setAttribute("recipeName", recipe.recipe_header.getName());
		request.setAttribute("recipeId", recipe.recipe_header.getId());
		request.setAttribute("recipeNote", recipe.recipe_header.getNote());
		request.setAttribute("recipeDescr", recipe.recipe_header.getDescription());
		request.setAttribute("userName", recipe.recipe_header.getUserName());
		request.setAttribute("dataCreation", recipe.recipe_header.getData_creation());
		request.setAttribute("videoLink", recipe.recipe_header.getVideo_link());
		request.setAttribute("categoryName", recipe.recipe_header.getCategoryCode());
		request.setAttribute("recipeRate", recipe.recipe_header.getRate());
		
		for (int i=0; i<recipe.recipe_row.size(); i++) {
			RecipeComponents recipeComp = new RecipeComponents();
			recipeComp.name = recipe.recipe_row.get(i).getComponentCode();
			recipeComp.count = String.valueOf(recipe.recipe_row.get(i).getComponente_qta());
			recipeComp.unit = recipe.recipe_row.get(i).getUnitDescription();
			recipeComp.completeComponent = recipeComp.getCompleteComponent();
			recipeComponents.add(recipeComp);
		}
		
		request.setAttribute("components", recipeComponents);

		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/recipeSite.jsp");
        dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rate = request.getParameter("categoryAddRate");
		String recipeId = request.getParameter("recipeId");
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("id");
		
		if (RatesDao.GetRateForRecipe(userId, recipeId) == 0) {
			RatesDao.InsertRateForRecipe(userId, recipeId, rate);
		} else {
			RatesDao.UpdateRateForRecipe(userId, recipeId, rate);
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
