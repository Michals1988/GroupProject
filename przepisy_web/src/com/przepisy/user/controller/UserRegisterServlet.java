package com.przepisy.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.przepisy.security.Hash256;
import com.przepisy.user.dao.UsersRegisterDao;
import com.przepisy.user.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UsersRegisterDao userDao = new UsersRegisterDao();
       
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
		Hash256 hashed_password = new Hash256();
		
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String active = request.getParameter("active");
		String admin = request.getParameter("admin");
		
		User user = new User();
		
		
		//user.setId(id);  ID automatycznie generowane jest w konstruktorze klasu User
		
		user.setLogin(login);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		//user.setActive(Boolean.parseBoolean(active)); - z zasady user jest aktywny
		//user.setAdmin(Boolean.parseBoolean(admin));   - z zasady user nie jest administratorem
		
		try {
			
			 if (UsersRegisterDao.UserCheckIfExist(user.getLogin(), user.getEmail())==0)
			 {
				 if(UsersRegisterDao.registerUser(user)==1) {
					 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/successmsg.jsp");
					 dispatcher.forward(request, response);
				 }else {
					 System.out.println("cos poszlo nie tak przy rejestracji");
				 }					 				 				 
			 } else {
				 System.out.println("user istnieje");
			 }
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
