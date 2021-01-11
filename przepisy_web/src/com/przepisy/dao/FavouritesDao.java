package com.przepisy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.przepisy.connection.ConnectionMySQLExceptHandler;
import com.przepisy.connection.ConnectionMysql;



public class FavouritesDao {
	
public static void InsertFavourite(String recipeId,String userId) {
		
		String QUERY_FAVOURITE_INSERT = "insert into favourite values(?,?,?)"; 
		
		Connection con = ConnectionMysql.getCon();
		
		try {       		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_FAVOURITE_INSERT);
                preparedStatement.setString(1, java.util.UUID.randomUUID().toString());
                preparedStatement.setString(2, recipeId);
                preparedStatement.setString(3, userId);

                System.out.println(preparedStatement);
                       
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }
		
	}


public static ArrayList<String> GetFavouritesIds(String userId) {
	
		Connection con = ConnectionMysql.getCon();
		ArrayList<String> FavouriteIds = new ArrayList<>();
	
		try {
		
		String QUERY_LOAD_FAV_IDS= "select recipe_header_id as id from favourite where user_id = ?";
		
		PreparedStatement preparedStatement = con.prepareStatement(QUERY_LOAD_FAV_IDS);
        preparedStatement.setString(1, userId);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
        	FavouriteIds.add(resultSet.getString("id"));     	  
        }
        	   		
	}catch (SQLException e) {
		ConnectionMySQLExceptHandler.printSQLException(e);
	}
	
	
	return	FavouriteIds;
}



}
