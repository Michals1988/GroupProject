package com.przepisy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.przepisy.connection.ConnectionMySQLExceptHandler;
import com.przepisy.connection.ConnectionMysql;
import com.przepisy.models.Comments;

public class CommentsDao {
	
	public static ArrayList<Comments> GetCommentsForRecipe(String recipeId){
		ArrayList<Comments> commentsList = new ArrayList<>();
		
		Connection con = ConnectionMysql.getCon();
		
		try {
			
			String LOAD_COMMENTS_WITH_DETAILS= "select    a.id 				as ComId,"
												+ "       a.id_recipe 		as RecipeId,"
												+ "       a.id_user 		as UserId,"
												+ "       a.description 	as description,"
												+ "       a.data 			as CommentData,"
												+ "       b.login 			as UserLogin,"
												+ "       from comments 	as a"
												+ "       left join users 	as b"
												+ "       on a.id_user = b.id"
												+ " where a.id_recipe = ? ";
			
			PreparedStatement preparedStatement = con.prepareStatement(LOAD_COMMENTS_WITH_DETAILS);
	        preparedStatement.setString(1, recipeId);
	        
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	        	
	        	  Comments comment = new Comments();
	        	  
	        	  comment.setId(resultSet.getString("ComId"));
	        	  comment.setId_recipe(resultSet.getString("RecipeId"));
	        	  comment.setId_user(resultSet.getString("UserId"));
	        	  comment.setData(resultSet.getString("CommentData"));
	        	  comment.setUser_login(resultSet.getString("UserLogin"));
	        	  commentsList.add(comment);
	        }
		
		
		
		
		
	}catch(SQLException e) {
		ConnectionMySQLExceptHandler.printSQLException(e);
	}
					return commentsList;
}
}
