package com.przepisy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.przepisy.connection.ConnectionMySQLExceptHandler;
import com.przepisy.connection.ConnectionMysql;
import com.przepisy.security.Hash256;

public class UserDao {
	public static void ChangePassword(String login, String newPassword) {
		
		String CHANGE_PASSWORD_QUERY= "update users set password = ? where"
				+ " login = ?";
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(CHANGE_PASSWORD_QUERY)) {
                preparedStatement.setString(1, Hash256.HashPassword(newPassword));
                preparedStatement.setString(2, login);

                System.out.println(preparedStatement);
                       
                preparedStatement.executeUpdate();
                
            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }			
	}

}
