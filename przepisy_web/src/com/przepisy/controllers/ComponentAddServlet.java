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
import com.przepisy.dao.ComponentsDao;
import com.przepisy.dao.UnitsDao;
import com.przepisy.models.Categories;
import com.przepisy.models.Components;
import com.przepisy.models.Units;

@WebServlet("/ComponentAdd")
public class ComponentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	String message = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession(false);
		request.setAttribute("message", message);
		generateCategoriesList(request, response);
		String userName = (String) session.getAttribute("login");
		request.setAttribute("login", userName);
		GenerateComponentsList(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String unit_id = request.getParameter("component_id");
		request.setAttribute("selectedUnitId", unit_id);
		request.setAttribute("message", message);

		String componentCode = request.getParameter("componentCode");
		String componentDescription = request.getParameter("componentDescription");

		Components component = new Components();

		component.setCode(componentCode);
		component.setId_unit(unit_id);
		component.setDescription(componentDescription);

		session = request.getSession(false);
		if (session != null) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/ComponentAdd.jsp");
			//dispatcher.forward(request, response);
		} else {
			GenerateComponentsList(request, response);
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
		}

		if (ComponentsDao.CheckIfComponentExist(componentCode) == 0) {
			ComponentsDao.AddNewComponent(component);
		} else {
			System.out.println("Komponent z takim kodem juz istnieje");
		}
		message = "Dodano!";
		request.setAttribute("message", message);
		doGet(request, response);
		dispatcher.forward(request, response);
	}

	private void GenerateComponentsList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Units> listUnits = UnitsDao.listAllActiveUnits();
		request.setAttribute("listUnits", listUnits);

		for (Units x : listUnits) {
			System.out.println(x.getDescription());
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/ComponentAdd.jsp");
		dispatcher.forward(request, response);

	}
	
	private void generateCategoriesList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categories> listCategories = CategoriesDao.listAllActiveCategories();
        request.setAttribute("listCategories", listCategories);
                             
        for (Categories x: listCategories) {
            System.out.println(x.getCode());
        }
	}
}
