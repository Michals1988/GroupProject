package com.przepisy.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.przepisy.dao.UserDao;
import com.przepisy.dao.UserLoginDao;
import com.przepisy.models.Components;
import com.przepisy.models.User;

@WebServlet("/addRecipe")
public class RecipeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Components> listComponents = new ArrayList<>();
	
	public RecipeAddServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        try {
		request.setAttribute("recipeName", session.getAttribute("recipeName"));
        request.setAttribute("shortDescription", session.getAttribute("shortDescription"));
        request.setAttribute("longDescription", session.getAttribute("longDescription"));
        request.setAttribute("category", session.getAttribute("category"));
        request.setAttribute("premium", session.getAttribute("premium"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addRecipe.jsp");
        dispatcher.forward(request, response);
        } catch(NullPointerException e) {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession(false);
		String login = (String) session.getAttribute("login");
		String password = request.getParameter("oldPassword");
		User user = new User();
		
		user.setLogin(login);
		user.setPassword(password);
		
		if (UserLoginDao.LogInUser(user)==1)
		 {
			if (password.equals(request.getParameter("newPassword"))) {
				System.out.println("NOWE HASLO NIE MOZE BYC TAKIE JAK STARE");
			}else {
			if (request.getParameter("newPassword")
					.equals(request.getParameter("newPasswordConfirm"))) {
				UserDao.ChangePassword(login,  request.getParameter("newPassword"));
			} else {
				System.out.println("NOWE HASLA SIE NIE ZGADZAJA");
			}
			}
		 } else {
			 System.out.println("STARE HASLO NIEPRAWIDLOWE");
		 }
		doGet(request, response);
	}
}
