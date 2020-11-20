package com.przepisy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class UserLogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// request.setAttribute("errorMessage", " ");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		HttpSession session = request.getSession(false);
		System.out.println("User=" + session.getAttribute("user"));
		if (session != null) {
			session.invalidate();
		}
		response.sendRedirect("login");
		/*
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
		 * dispatcher.forward(request, response);
		 */
	}

}
