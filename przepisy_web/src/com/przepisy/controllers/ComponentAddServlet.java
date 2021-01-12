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

import com.przepisy.dao.ComponentsDao;
import com.przepisy.dao.UnitsDao;
import com.przepisy.models.Components;
import com.przepisy.models.Units;


@WebServlet("/ComponentAdd")
public class ComponentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;  
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenerateComponentsList(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String unit_id = request.getParameter("component_id");
		request.setAttribute("selectedUnitId", unit_id);
						
		
		String componentCode = request.getParameter("componentCode");
		String componentDescription = request.getParameter("componentDescription");
				
		Components component = new Components();
				
		component.setCode(componentCode);
		component.setId_unit(unit_id);
		component.setDescription(componentDescription);
		
		session = request.getSession(false);
		if (session != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/ComponentAdd.jsp");
			dispatcher.forward(request, response);
		} else { 
			GenerateComponentsList(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginuser.jsp");
			dispatcher.forward(request, response);
		}
			
			 if (ComponentsDao.CheckIfComponentExist(componentCode)==0)
			 {
				 ComponentsDao.AddNewComponent(component);
			 } else {
				 System.out.println("Komponent z takim kodem juz istnieje");
			 }
		
	}
	
	private void GenerateComponentsList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		   
        	List<Units> listUnits = UnitsDao.listAllActiveUnits();
            request.setAttribute("listUnits", listUnits);
                                 
            for (Units x: listUnits) {
                System.out.println(x.getDescription());
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/ComponentAdd.jsp");
            dispatcher.forward(request, response);
 
        
        }
    }



