package com.przepisy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.przepisy.connection.ConnectionMysql;
import com.przepisy.models.User;

public class UsersRegisterDao {

    public static int registerUser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (id, login, password, name, email, active, admin) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";

        int result = 0;
        
        Connection con= ConnectionMysql.getCon();  
               
        try (
        		
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getGeneratedId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPasswordHashed());
            preparedStatement.setString(4, user.getName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setBoolean(6, user.isActive());
            preparedStatement.setBoolean(7, user.isAdmin());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        	
        // result zwraca ilo�� zmienionych wierszy
        return result;
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
    
    public static int UserCheckIfExist(String login, String email) {
    	
    	int result = 0;

    	String CHECK_USERS_SQL = " select count(name) as xxx from users" +
                				 "  where login = ? " +
                				 "  or email = ?";
    	
    	Connection con= ConnectionMysql.getCon(); 
    	
    	try (        		
                PreparedStatement preparedStatement = con.prepareStatement(CHECK_USERS_SQL)) {
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, email);

                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	  result  = resultSet.getInt("xxx");
                	}

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
    	
    	//result zwraca ilosc znalezionych userow o tym samym loginie lub hasle, 0 = OK
    	return result;
    }
    
}