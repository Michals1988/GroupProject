package com.przepisy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.przepisy.dao.FavouritesDao;


@WebServlet("/DeleteFavourites")
public class DeleteFavouritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteFavouritesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("id");
		String recipeId = request.getParameter("recipeId");
		
		FavouritesDao.DeleteFavourite(recipeId, userId);
		response.sendRedirect("FavouritesServlet");
	}

}
