package com.przepisy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.przepisy.dao.UsersRegisterDao;
import com.przepisy.models.User;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		User user = new User();
		
		user.setLogin(login);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		
		try {
			
			 if (UsersRegisterDao.UserCheckIfExist(user.getLogin(), user.getEmail())==0)
			 {
				 if(UsersRegisterDao.registerUser(user)==1) {
					 /*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/MainPage.jsp");
					 dispatcher.forward(request, response);*/
					 message = "Zarejestrowano pomyślnie";
					 response.sendRedirect("login?message=" + message);
				 }else {
					 message = "Coś poszło nie tak";
					 response.sendRedirect("login?message=" + message);
				 }					 				 				 
			 } else {
				 message = "Użytkownik istnieje";
				 response.sendRedirect("login?message=" + message);
			 }
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
