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
import com.przepisy.dao.UserDao;
import com.przepisy.dao.UserLoginDao;
import com.przepisy.models.User;
import com.przepisy.utility.Image;


@WebServlet("/UserPanel")
public class UserPanelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserPanelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        try {
		request.setAttribute("login", session.getAttribute("login"));
        request.setAttribute("name", session.getAttribute("name"));
        request.setAttribute("email", session.getAttribute("email"));
        String img_path = (String) session.getAttribute("login");
        img_path = Image.GetUserAvatar(img_path);
        System.out.println(img_path);
        request.setAttribute("img_path", img_path);
        int premium = (int) session.getAttribute("premium");
        String isPremium;
        if (premium == 0) {
        	isPremium = "NIE";
        } else {
        	isPremium = "TAK";
        }
        request.setAttribute("premium",isPremium);
        request.setAttribute("premium", session.getAttribute("premium"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UserPanel.jsp");
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
