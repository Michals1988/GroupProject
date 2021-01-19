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
import com.przepisy.dao.RecipeDao;
import com.przepisy.models.Categories;
import com.przepisy.models.TopRecipe;

@WebServlet("/CategorySearchServlet")
public class CategorySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<TopRecipe> listFoundRecipe;
       
    public CategorySearchServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("login");
		generateCategoriesList(request, response);
		request.setAttribute("login", userName);
		String categoryId = (String) request.getParameter("categoryId");
		listFoundRecipe = RecipeDao.GetRecipeByCategory(categoryId);
		
		request.setAttribute("listFoundRecipe", listFoundRecipe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/categoriesPage.jsp");
        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
