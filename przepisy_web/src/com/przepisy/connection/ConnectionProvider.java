package com.przepisy.connection;

public interface ConnectionProvider {  
	
	String DRIVER="com.mysql.cj.jdbc.Driver";  
	String CONNECTION_URL="jdbc:mysql://localhost:3306/przepisy?allowPublicKeyRetrieval=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";  
	String USERNAME="root";  
	String PASSWORD="root";  
  
}  
