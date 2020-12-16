package com.przepisy.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.przepisy.dao.ComponentsDao;
import com.przepisy.models.Components;
import com.przepisy.models.Recipe;
import com.przepisy.models.RecipeRow;

@WebServlet("/addRecipe")
public class RecipeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	Recipe recipe;
	RecipeRow recipeRow = new RecipeRow();

	public RecipeAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			/*request.setAttribute("recipeName", session.getAttribute("recipeName"));
			request.setAttribute("shortDescription", session.getAttribute("shortDescription"));
			request.setAttribute("longDescription", session.getAttribute("longDescription"));
			request.setAttribute("category", session.getAttribute("category"));
			request.setAttribute("premium", session.getAttribute("premium"));*/
			GenerateComponentsList(request, response);

		} catch (NullPointerException e) {
			System.out.println("Sesja wygasła. Redirect do strony logowania");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			// request.setAttribute("errorMessage", " ");
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("JSESSIONID")) {
						System.out.println("JSESSIONID=" + cookie.getValue());
					}
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					System.out.println("COOKIES DESTROYED BITCH");
				}
			}
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession(false);
		String action = request.getServletPath();
		String componentId = request.getParameter("component");
		
		String componentsJSON = request.getParameter("hiddenComponents");
		Gson gson = new Gson();
		String[] componentsIds = gson.fromJson(componentsJSON, String[].class);
		
		// SPRAWDZENIE CZY WYSWIETLA DANE Z JSONA
		for (String comp : componentsIds) {
			System.out.println(comp);
		}

		/*if (action == "addRecipe") {
			String recipeName = (String) request.getParameter("recipeName");
			String shortDescription = (String) request.getParameter("shortDescription");
			String longDescription = (String) request.getParameter("longDescription");
			String category = (String) request.getParameter("category");
		} else if (action == request.getContextPath() +"/showComponents") {
			System.out.println("----------- WESZŁEM");
			recipeRow.setId(java.util.UUID.randomUUID().toString());
			recipeRow.setComponent(ComponentsDao.LoadComponentById(componentId));
			recipe.recipe_row.add(recipeRow);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addRecipe.jsp");
			dispatcher.forward(request, response);
			
		} else if (action == "showComponents") {
			System.out.println("----------- WESZŁEM BEZ KONTEXTPATH");
			recipeRow.setId(java.util.UUID.randomUUID().toString());
			recipeRow.setComponent(ComponentsDao.LoadComponentById(componentId));
			recipe.recipe_row.add(recipeRow);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addRecipe.jsp");
			dispatcher.forward(request, response);
		}*/

		//User user = new User();

		doGet(request, response);
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
}
