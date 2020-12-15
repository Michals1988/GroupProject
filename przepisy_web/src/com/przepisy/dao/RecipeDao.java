package com.przepisy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.przepisy.connection.ConnectionMySQLExceptHandler;
import com.przepisy.connection.ConnectionMysql;
import com.przepisy.models.Recipe;
import com.przepisy.models.RecipeHeader;
import com.przepisy.models.RecipeRow;

public class RecipeDao {
	
	
	public static void InsertRecipe(Recipe recipe) {
		
		 InsertRecipeHeader(recipe.getRecipe_header());
		 
		 ArrayList<RecipeRow> recipe_row = recipe.getRecipe_row();
		 
		 for (int i=0;i<recipe_row.size();i++) {
			 InsertRecipeRow(recipe_row.get(i));
		 }
		
	}
	
	
	public static void InsertRecipeHeader(RecipeHeader recipe_header) {
		
		String QUERY_RECIPE_HEADER_INSERT = "insert into recipe_header values(?,?,?,?,?,?,?,?,?,?)"; 
		
		Connection con = ConnectionMysql.getCon();
		
		try   {      		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_RECIPE_HEADER_INSERT) ;
                preparedStatement.setString(1, recipe_header.getId());
                preparedStatement.setString(2, recipe_header.getName());
                preparedStatement.setString(3, recipe_header.getDescription());
                preparedStatement.setInt(4, 1);
                preparedStatement.setString(5, recipe_header.getUserId());
                preparedStatement.setString(6, recipe_header.getData_creation());
                preparedStatement.setString(7, recipe_header.getVideo_link());
                preparedStatement.setString(8, recipe_header.getNote());
                preparedStatement.setString(9,"");
                preparedStatement.setString(10, recipe_header.getCategoryId());

                System.out.println(preparedStatement);
                       
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }
		
	}
	
public static void InsertRecipeRow(RecipeRow recipe_row) {
		
		String QUERY_RECIPE_ROW_INSERT = "insert into recipe_row values(?,?,?,?,?)"; 
		
		Connection con = ConnectionMysql.getCon();
		
		try {       		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_RECIPE_ROW_INSERT);
                preparedStatement.setString(1, recipe_row.getId());
                preparedStatement.setString(2, recipe_row.getId_recipe());
                preparedStatement.setString(3, recipe_row.getComponentId());
                preparedStatement.setInt(4, recipe_row.getComponente_pos());


                System.out.println(preparedStatement);
                       
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }
		
	}

}
