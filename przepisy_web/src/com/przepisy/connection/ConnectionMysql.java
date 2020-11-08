package com.przepisy.connection;
 
import java.sql.*; 
import static com.przepisy.connection.ConnectionProvider.*;  
  
public class ConnectionMysql {  
	
	private static Connection con=null;  
	
	static{  
	try{  
		 Class.forName(DRIVER);  
		 con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  
		}catch(Exception e){}  
		}  
  
public static Connection getCon(){  
	
    return con;  
}  
  
}  