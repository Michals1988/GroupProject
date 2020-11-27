package com.przepisy.utility;


import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

public class Image {
	
	public static String GetExtensionFromName(String fileName) {
		
		String extension="";
	 
	    int index = fileName.lastIndexOf('.');
	    if(index > 0) {
	      extension = fileName.substring(index + 1);
	      System.out.println("File extension is " + extension);
	    }
	    
	   return extension;
	  }
	
	
	public static int ResizeImage(int x, int y,String path){
		try {
			Thumbnails.of(path)
			.size(600, 420)
			.keepAspectRatio(false)
			.toFile(path);
		} catch (IOException e) {
			System.out.println("nie udalo sie zmodyfikowac obrazu");			
			e.printStackTrace();
			return 0;
			
		}
		return 1;
    }
	
	public static String GetUserAvatar(String login) {
		
		String startPath = "C:/PROJEKT/Images";
		
		File file_png = new File("C:/PROJEKT/Images/"+login+".png");		
		boolean fileExists_png = file_png.exists();
		
		File file_jpg = new File("C:/PROJEKT/Images/"+login+".jpg");		
		boolean fileExists_jpg = file_png.exists();
		
		File file_default = new File("C:/PROJEKT/Images/"+"default"+".jpg");		
		boolean fileExist_default = file_default.exists();
		
		
		if (fileExists_png==true)
		{
			return "C:/PROJEKT/Images/"+login+".png"; 
		}
		
		if (fileExists_jpg==true)
		{
			return "C:/PROJEKT/Images/"+login+".jpg"; 
		}
		
		if (fileExist_default==true)
		{
			return "C:/PROJEKT/Images/"+"default"+".jpg"; 
		}
		
		
		return null;
	}
	
	
	
}


