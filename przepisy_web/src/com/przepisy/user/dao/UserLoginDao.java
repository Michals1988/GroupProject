package com.przepisy.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.przepisy.connection.ConnectionMysql;
import com.przepisy.models.User;

public class UserLoginDao {
   
    public static int LogInUser(User user) {
    	
    	int result = 0;

    	String CHECK_USERS_SQL = " select count(login) as xxx from users" +
                				 "  where login = ? " +
                				 "  and password = ?";
    	
    	Connection con = ConnectionMysql.getCon(); 
    	
    	try (        		
                PreparedStatement preparedStatement = con.prepareStatement(CHECK_USERS_SQL)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPasswordHashed());

                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	  result  = resultSet.getInt("xxx");
                	}

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
    	
    	//result zwraca ilosc znalezionych userow o tym samym loginie lub hasle, 0 = NIE OK
    	return result;
    }
    
    
    public static void LoadUserDataByLogin(User user,String login) {
    	
    	String LoadUserInfo = " select id,login,password,name,email,active,admin "
    						+  " from users"
    						+  "where login = ?";

    	Connection con = ConnectionMysql.getCon(); 

    	try (        		
    		PreparedStatement preparedStatement = con.prepareStatement(LoadUserInfo)) {
    		preparedStatement.setString(1, login);
    		

    		System.out.println(preparedStatement);
      
    		ResultSet resultSet = preparedStatement.executeQuery();

    		while (resultSet.next()) {
    				user.setId(resultSet.getString("id"));
    				user.setLogin(resultSet.getString("login")); 
    				user.setPassword(resultSet.getString("password")); 
    				user.setName(resultSet.getString("name")); 
    				user.setEmail(resultSet.getString("email")); 
    				user.setActive(resultSet.getBoolean("actvie")); 
    				user.setAdmin(resultSet.getBoolean("admin")); 
    		}

    		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
			}
    	
    }
    
    
    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}