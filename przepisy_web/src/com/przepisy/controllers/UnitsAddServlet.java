package com.przepisy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.przepisy.dao.UnitsDao;
import com.przepisy.models.Units;



@WebServlet("/UnitAdd")
public class UnitsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UnitAdd.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String unit_code = request.getParameter("unit_code");
		String unit_descr = request.getParameter("unit_descr");
			
		Units unit = new Units();
				
		unit.setCode(unit_code);
		unit.setDescription(unit_descr);
		
		
			
			 if (UnitsDao.CheckIfUnitExist(unit_code)==0)
			 {
				 UnitsDao.AddNewUnit(unit);
			 } else {
				 System.out.println("Jednostka z takim kodem juz istnieje!");
			 }
			
			
		
	}
}
