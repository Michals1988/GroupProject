package com.przepisy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.przepisy.connection.ConnectionMySQLExceptHandler;
import com.przepisy.connection.ConnectionMysql;
import com.przepisy.models.Categories;

public class CategoriesDao {
	public static int CheckIfCategoryExist (String categoryCode) {
		
		int result =0;
		
		String QUERY_CODE_EXIST = "select count(id) as xx from categories where code = ?"; 
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_CODE_EXIST)) {
                preparedStatement.setString(1, categoryCode);

                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	  result = resultSet.getInt("xx");                 	
                	}

            } catch (SQLException e) {           	
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }
		return result;
	}
	
	public static void AddNewCategory(Categories category) {
		
		
		String ADD_CATEGORY_QUERY = "insert into categories values(?,?,?,?)";
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(ADD_CATEGORY_QUERY)) {
                preparedStatement.setString(1, category.getGeneratedID());
                preparedStatement.setString(2, category.getCode());
                preparedStatement.setString(3, category.getDescription());
                preparedStatement.setString(4, "0");

                System.out.println(preparedStatement);
                       
                preparedStatement.executeUpdate();
                
             

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }			
	}
	
	public static List<Categories> listAllActiveCategories()  {
		
		List<Categories> listCategories = new ArrayList<>();
         
        String SELECT_ACTIVE_CATEGORIES = "SELECT id,code,description,active FROM categories order by code";
         
        Connection con = ConnectionMysql.getCon();
        
        try (        		
                PreparedStatement preparedStatement = con.prepareStatement(SELECT_ACTIVE_CATEGORIES)) {
          
                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	  String id = resultSet.getString("id");
                	  String code = resultSet.getString("code");
                	  String description = resultSet.getString("description");
                	  int active = resultSet.getInt("active"); 
                	  
                	  Categories categories = new Categories();
                	  categories.setId(id);
                	  categories.setCode(code);
                	  categories.setDescription(description);
                	  categories.setActive(active);
                	  listCategories.add(categories);               	
                	}

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }		         
        return listCategories;
    }

}
