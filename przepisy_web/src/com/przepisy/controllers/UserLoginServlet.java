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

import com.przepisy.dao.PremiumDao;
import com.przepisy.dao.UserLoginDao;
import com.przepisy.models.Premium;
import com.przepisy.models.User;


@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.setAttribute("errorMessage", " ");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
			
		User user = new User();
				
		user.setLogin(login);
		user.setPassword(password);
		
		
			
			 if (UserLoginDao.LogInUser(user)==1)
			 {
				 HttpSession session = request.getSession(true);
				 Cookie loginCookie = new Cookie("user", login);
				 loginCookie.setMaxAge(30*60);
				 response.addCookie(loginCookie);
				 //response.sendRedirect("index.jsp");
				 Premium premium = new Premium();
				 UserLoginDao.LoadUserDataByLogin(user, user.getLogin());
				 PremiumDao.LoadPremiumInfo(premium, user.getId());
				 session.setAttribute("id", user.getId());
				 session.setAttribute("login", user.getLogin());
				 session.setAttribute("email", user.getEmail());
				 session.setAttribute("premium", premium.getLevel());
				 System.out.println("zalogowano");
				 System.out.println("sesja 'id usera: "+session.getAttribute("id"));
				 System.out.println("sesja login usera"+session.getAttribute("login"));
				 System.out.println("sesja email usera"+session.getAttribute("email"));
				 System.out.println("sesja premium usera"+session.getAttribute("premium"));
			 } else {
				 System.out.println("user nie istnieje");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
				 request.setAttribute("errorMessage", "Invalid user or password");
				 dispatcher.forward(request, response);
			 }
			
			
		
	}
}