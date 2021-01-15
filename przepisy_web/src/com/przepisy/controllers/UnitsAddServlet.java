package com.przepisy.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.przepisy.dao.CategoriesDao;
import com.przepisy.dao.UnitsDao;
import com.przepisy.models.Categories;
import com.przepisy.models.Units;

@WebServlet("/UnitAdd")
public class UnitsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	String message = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession(false);
		String userName = (String) session.getAttribute("login");
		request.setAttribute("login", userName);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		generateCategoriesList(request, response);
		System.out.println("print1: " + request.getSession().getId());
		System.out.println("print2: " + request.getSession(false));
		session = request.getSession(false);
		if (session != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UnitAdd.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession(false);
		RequestDispatcher dispatcher;
		String unit_code = request.getParameter("unit_code");
		String unit_descr = request.getParameter("unit_descr");

		Units unit = new Units();

		unit.setCode(unit_code);
		unit.setDescription(unit_descr);

		session = request.getSession(false);
		if (session != null) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/UnitAdd.jsp");
			// dispatcher.forward(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
			dispatcher.forward(request, response);
		}

		if (UnitsDao.CheckIfUnitExist(unit_code) == 0) {
			UnitsDao.AddNewUnit(unit);
		} else {
			System.out.println("Jednostka z takim kodem juz istnieje!");
		}

		message = "Dodano!";
		request.setAttribute("message", message);
		doGet(request, response);
		dispatcher.forward(request, response);

	}

	private void generateCategoriesList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Categories> listCategories = CategoriesDao.listAllActiveCategories();
		request.setAttribute("listCategories", listCategories);

		for (Categories x : listCategories) {
			System.out.println(x.getCode());
		}
	}
}
