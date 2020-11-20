package com.przepisy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.przepisy.dao.CategoriesDao;
import com.przepisy.models.Categories;

public class CategoryAddServlet {
	HttpSession session;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("print1: "+request.getSession().getId());
		System.out.println("print2: "+request.getSession(false));
		session = request.getSession(false);
		if (session != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/categoryAdd.jsp");
			dispatcher.forward(request, response);
		} else { 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
			dispatcher.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoryCode = request.getParameter("categoryCode");
		String categoryDescription = request.getParameter("categoryDescription");
			
		Categories categories = new Categories();
				
		categories.setCode(categoryCode);
		categories.setDescription(categoryDescription);
		
		session = request.getSession(false);
		if (session != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/categoryAdd.jsp");
			dispatcher.forward(request, response);
		} else { 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
			dispatcher.forward(request, response);
		}
			
			 if (CategoriesDao.CheckIfCategoryExist(categoryCode)==0)
			 {
				 CategoriesDao.AddNewCategory(categories);
			 } else {
				 System.out.println("Jednostka z takim kodem juz istnieje!");
			 }
		
	}

}
