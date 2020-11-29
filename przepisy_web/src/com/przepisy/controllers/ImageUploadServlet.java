package com.przepisy.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.przepisy.utility.Image;


@WebServlet("/ImageUploadServlet")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 *1,
	maxFileSize = 1024 * 1024 * 10,
	maxRequestSize = 1024 * 1024 *100
	)
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Part filePart = request.getPart("file");
		
		String fileName = filePart.getSubmittedFileName();
		String extension = Image.GetExtensionFromName(fileName);
		
		fileName = (String) session.getAttribute("login");
		
		
		File file = new File("C:/PROJEKT/Images");		
		boolean fileExists = file.exists();
		System.out.println("Czy sciezka i folder istnieje? " + fileExists);
		
		if (fileExists==false)
		{
			System.out.println("Tworzymy sciezke");
			boolean dirCreated = file.mkdirs();	
			System.out.println("Czy stworzono sciezke? :  " + dirCreated);
		}
		
		
		for (Part part: request.getParts()) {
			part.write( "C:/PROJEKT/Images/" + fileName+"."+extension);
		}
		System.out.println("wrzucono plik");
		
		Image.ResizeImage(100,100, "C:/PROJEKT/Images/" + fileName+"."+extension);
		response.sendRedirect("UserPanel");
	}

}
