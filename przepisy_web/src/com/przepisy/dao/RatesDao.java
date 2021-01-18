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
	
	public static float GetRateForRecipe(String userId,String recipeId) {
		
		float rate=0;
		
		String QUERY_GET_RATE = "select rate from rates where id_recipe = ? and id_user = ? ";
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_GET_RATE)) {
                preparedStatement.setString(1, recipeId);
                preparedStatement.setString(2, userId);

                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	rate = resultSet.getFloat("rate");                 	
                	}

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }

				
		return rate;
	}
		
	
	public static void InsertRateForRecipe(String userId,String recipeId,int rate) {
		
		String QUERY_INSERT_RATE = "insert into rates values (?,?,?,?)";
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_INSERT_RATE)) {
                preparedStatement.setString(1, java.util.UUID.randomUUID().toString());
                preparedStatement.setString(2, recipeId);
                preparedStatement.setInt(3, rate);
                preparedStatement.setString(4, userId);
                

                System.out.println(preparedStatement);
                       
                preparedStatement.executeUpdate();
                
            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }

				
		
	}
	
public static void UpdateRateForRecipe(String userId,String recipeId,int rate) {
		
		String QUERY_INSERT_RATE = "update rates set rate = ? where id_user = ? and id_recipe = ?";
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_INSERT_RATE)) {
                preparedStatement.setInt(1, rate);
                preparedStatement.setString(2, userId);
                preparedStatement.setString(3, recipeId);
     
                System.out.println(preparedStatement);
                       
                preparedStatement.executeUpdate();
                
            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }
					
	}		
		
}


