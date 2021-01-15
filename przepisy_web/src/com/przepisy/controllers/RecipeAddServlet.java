package com.przepisy.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.przepisy.dao.CategoriesDao;
import com.przepisy.dao.ComponentsDao;
import com.przepisy.dao.RecipeDao;
import com.przepisy.models.Categories;
import com.przepisy.models.Components;
import com.przepisy.models.Recipe;
import com.przepisy.models.RecipeRow;

@WebServlet("/addRecipe")
public class RecipeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Categories> listCategories;

	public RecipeAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("login");
		request.setAttribute("login", userName);
		generateCategoriesList(request, response);
		GenerateComponentsList(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String userId = (String) session.getAttribute("id");
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("USER ID ---- " + userId);
		
		String recipeId = java.util.UUID.randomUUID().toString();
		String action = request.getServletPath();
		String componentId = request.getParameter("component");
		
		String recipeName = request.getParameter("recipeName");
		String shortDescription = request.getParameter("shortDescription");
		String longDescription = request.getParameter("longDescription");
		String category = request.getParameter("category");
		String videoLink = request.getParameter("videoLink");
		
		String componentsJSON = request.getParameter("hiddenComponents");
		String qtaJSON = request.getParameter("hiddenQta");
		Gson gson = new Gson();
		String[] componentsIds = gson.fromJson(componentsJSON, String[].class);
		String[] componentsQta = gson.fromJson(qtaJSON, String[].class);
		
		Recipe recipe = new Recipe();
		
		System.out.println("RECIPE ID ------  " + recipeId);
		
		recipe.recipe_header.setId(recipeId);
		recipe.recipe_header.setName(recipeName);
		//recipe.recipe_header.generateId();
		recipe.recipe_header.setDescription(shortDescription);
		recipe.recipe_header.setNote(longDescription);
		recipe.recipe_header.setCategoryId(category);
		recipe.recipe_header.setActive(1);
		recipe.recipe_header.setUserId(userId);
		recipe.recipe_header.setVideo_link(videoLink);
		recipe.recipe_header.setData_creation(formatter.format(date));
		
		int componentPosition = 0;
		for (String comp : componentsIds) {
			RecipeRow recipeRow = new RecipeRow();
			recipeRow.setId(java.util.UUID.randomUUID().toString());
			System.out.println("RECIPE ROW ID " + recipeRow.getId());
			recipeRow.setId_recipe(recipeId);
			//recipeRow.setId_recipe(recipe.recipe_header.getId());
			recipeRow.setComponentId(comp);
			recipeRow.setComponente_qta(Float.parseFloat(componentsQta[componentPosition]));
			recipeRow.setComponente_pos(componentPosition+1);
			System.out.println("RECIPE ROW ID " + recipeRow.getComponente_pos());
			recipe.recipe_row.add(recipeRow);
			componentPosition++;
		}
		
		RecipeDao.InsertRecipe(recipe);

		
		session = request.getSession(false);
		if (session != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/MainPage.jsp");
			response.sendRedirect("RecipePage?recipeId=" + recipeId);
			//dispatcher.forward(request, response);
		} else { 
			GenerateComponentsList(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
			dispatcher.forward(request, response);
		}
		//GenerateComponentsList(request, response);
	}

	private void GenerateComponentsList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Components> listComponents = ComponentsDao.listAllActiveComponents(); 

		request.setAttribute("listComponents", listComponents);

		for (Components x : listComponents) {
			System.out.println(x.getDescription());
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addRecipe.jsp");
		dispatcher.forward(request, response);

	}
	
	private void generateCategoriesList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listCategories = CategoriesDao.listAllActiveCategories();
        request.setAttribute("listCategories", listCategories);
                             
        for (Categories x: listCategories) {
            System.out.println(x.getCode());
        }
        
	}
	
}
