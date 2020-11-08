package com.przepisy.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.przepisy.registration.dao.UsersDao;
import com.przepisy.registration.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UsersDao userDao = new UsersDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
			UsersDao.registerUser(user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/successmsg.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
