package com.przepisy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.przepisy.connection.ConnectionMySQLExceptHandler;
import com.przepisy.connection.ConnectionMysql;

public class RatesDao {
	
	public static float GetRateById(String recipeId) {
		
		float rate=0;
				
		String QUERY_GET_RATE = "select ROUND(AVG(rate),1) as Rate "
				+ " from rates where id_recipe = ?"
				+ " group by id_recipe"; 
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_GET_RATE)) {
                preparedStatement.setString(1, recipeId);

                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	rate = resultSet.getFloat("Rate");                 	
                	}

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }

				
		return rate;
	}

}
