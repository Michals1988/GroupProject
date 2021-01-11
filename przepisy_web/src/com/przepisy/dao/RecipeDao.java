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
import com.przepisy.models.TopRecipe;
import com.przepisy.utility.Image;


public class RecipeDao {
	
	
	public static void InsertRecipe(Recipe recipe) {
		
		 InsertRecipeHeader(recipe.getRecipe_header());
		 
		 for (RecipeRow r : recipe.recipe_row) {
			 InsertRecipeRow(r);
			}				
	}
	
	
	public static void InsertRecipeHeader(RecipeHeader recipe_header) {
		
		String QUERY_RECIPE_HEADER_INSERT = "insert into recipes_header values(?,?,?,?,?,?,?,?,?,?)"; 
		
		Connection con = ConnectionMysql.getCon();
		
		try   {      		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_RECIPE_HEADER_INSERT) ;
                preparedStatement.setString(1, recipe_header.getId());
                preparedStatement.setString(2, recipe_header.getName());
                preparedStatement.setString(3, recipe_header.getDescription());
                preparedStatement.setInt(4, recipe_header.getActive());
                preparedStatement.setString(5, recipe_header.getUserId());
                preparedStatement.setString(6, recipe_header.getData_creation());
                preparedStatement.setString(7, "");
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
		
		String QUERY_RECIPE_ROW_INSERT = "insert into recipes_row values(?,?,?,?,?)"; 
		
		Connection con = ConnectionMysql.getCon();
		
		try {       		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_RECIPE_ROW_INSERT);
                preparedStatement.setString(1, recipe_row.getId());
                preparedStatement.setString(2, recipe_row.getId_recipe());
                preparedStatement.setString(3, recipe_row.getComponentId());
                preparedStatement.setFloat(4, recipe_row.getComponente_qta());
                preparedStatement.setInt(5, recipe_row.getComponente_pos());

                System.out.println(preparedStatement);
                       
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }
		
	}

public static ArrayList<String> GetTop5RecipesId() {
	
	ArrayList<String> RecipesIds = new ArrayList<>();
	int recipes_qta = 5;
	String result ="";
	
	String QUERY_RECIPE_TOP_LOAD= "select avg(rate) as rate, id_recipe as recipeid from rates"
								+ " group by id_recipe"
								+ " order by avg(rate) DESC"
								+ " limit ? " ;
	
	
	Connection con = ConnectionMysql.getCon();
	
	try {       		
        PreparedStatement preparedStatement = con.prepareStatement(QUERY_RECIPE_TOP_LOAD);
        preparedStatement.setInt(1, recipes_qta);
        
        System.out.println(preparedStatement);
               
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
        	  result = resultSet.getString("recipeid");  
        	  RecipesIds.add(result);
        	}

    } catch (SQLException e) {
    	ConnectionMySQLExceptHandler.printSQLException(e);
    }
	return RecipesIds;
}

public static ArrayList<String> GetRecipesIdsByName(String name) {
	System.out.println("GetRecipesIdsByName przejął nazwę " + name);
	ArrayList<String> RecipesIds = new ArrayList<>();
	String result ="";
	String queryParameter = "";
	
	String QUERY_RECIPE_TOP_LOAD= "select id from recipes_header where name like ?";
	
	Connection con = ConnectionMysql.getCon();
	
	try {       		
        PreparedStatement preparedStatement = con.prepareStatement(QUERY_RECIPE_TOP_LOAD);
        queryParameter = "%" + name + "%";
        preparedStatement.setString(1, queryParameter);
        
        System.out.println(preparedStatement);
               
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
        	  result = resultSet.getString("id");  
        	  RecipesIds.add(result);
        	}

    } catch (SQLException e) {
    	ConnectionMySQLExceptHandler.printSQLException(e);
    }
	return RecipesIds;
}


public static ArrayList<TopRecipe> GetTop5Recipes() {
	
	
	ArrayList<TopRecipe> listTopRecipe = new ArrayList<>(); 
	ArrayList<String> RecipesIds = GetTop5RecipesId();
	
	Connection con = ConnectionMysql.getCon();
	
	for(int i=0;i<RecipesIds.size();i++)
	{
		TopRecipe topRecipe = new TopRecipe();
		
			String LOAD_RECIPE_WITH_DETAILS= "select 	a.id 			as RecipeId,"
					   									+" a.name 			as RecipeName,"
					   									+" a.description 	as RecipeDescr, "
					   									+" a.id_user 		as UserId,"
					   									+" c.login	 		as Username,"
					   									+" a.data_creation as DataCreation,"
					   									+" a.id_category 	as CategoryId,"
					   									+" b.code 			as CategoryName"
					   									+" from recipes_header as a"
					   									+" left join categories as b"
					   									+" on a.id_category = b.id"
					   									+" left join users as c"
					   									+" on a.id_user = c.id"
					   									+" where a.id = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(LOAD_RECIPE_WITH_DETAILS);
	        preparedStatement.setString(1, RecipesIds.get(i));
	        
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	        	  topRecipe.setRecipeId(resultSet.getString("RecipeId"));
	        	  topRecipe.setRecipeName(resultSet.getString("RecipeName"));
	        	  topRecipe.setRecipeDescr(resultSet.getString("RecipeDescr"));
	        	  topRecipe.setUserId(resultSet.getString("UserId"));
	        	  topRecipe.setUsername(resultSet.getString("Username"));
	        	  topRecipe.setDataCreation(resultSet.getString("DataCreation"));
	        	  topRecipe.setCategoryId(resultSet.getString("CategoryId"));
	        	  topRecipe.setCategoryName(resultSet.getString("CategoryName"));
	        	  topRecipe.setImgPath(Image.GetUserAvatar(topRecipe.getRecipeId()));
	        	}
	        topRecipe.setRate(RatesDao.GetRateById(topRecipe.getRecipeId()));
	        listTopRecipe.add(topRecipe);
		} catch (SQLException e) {
			ConnectionMySQLExceptHandler.printSQLException(e);
		}
		
	}
	
	return listTopRecipe;
}


public static Recipe GetFullRecipe (String RecipeId) {
	Recipe recipe = new Recipe();
	
	
	Connection con = ConnectionMysql.getCon();
	
	try {
		
		String LOAD_RECIPE_WITH_DETAILS= "select 	a.id 			as RecipeId,"
													+" a.name 			as RecipeName,"
													+" a.description 	as RecipeDescr, "
													+" a.note 	        as Note, "
													+" a.id_user 		as UserId,"
													+" a.video_link  	as VideoLink,"
													+" c.login	 		as Username,"
													+" a.data_creation as DataCreation,"
													+" a.id_category 	as CategoryId,"
													+" b.code 			as CategoryName"
													+" from recipes_header as a"
													+" left join categories as b"
													+" on a.id_category = b.id"
													+" left join users as c"
													+" on a.id_user = c.id"
													+" where a.id = ?";
		
		PreparedStatement preparedStatement = con.prepareStatement(LOAD_RECIPE_WITH_DETAILS);
        preparedStatement.setString(1, RecipeId);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
        	  recipe.recipe_header.setId(resultSet.getString("RecipeId"));  
        	  recipe.recipe_header.setName(resultSet.getString("RecipeName"));
        	  recipe.recipe_header.setDescription(resultSet.getString("RecipeDescr"));
        	  recipe.recipe_header.setNote(resultSet.getString("Note"));
        	  recipe.recipe_header.setUserId(resultSet.getString("UserId"));
        	  recipe.recipe_header.setUserLogin(resultSet.getString("Username"));
        	  recipe.recipe_header.setData_creation(resultSet.getString("DataCreation"));
        	  recipe.recipe_header.setVideo_link(resultSet.getString("VideoLink"));
        	  recipe.recipe_header.setCategoryId(resultSet.getString("CategoryId"));
        	  recipe.recipe_header.setCategoryCode(resultSet.getString("CategoryName"));
        	  recipe.recipe_header.setRate(RatesDao.GetRateById(RecipeId));
        }
        	  
        String LOAD_RECIPE_ROWS_WITH_DETAILS = "select 	   a.id 			as RowId,"
										        		+ "a.id_recipe 		as RecipeId,"
										        		+ "a.id_componente 	as ComponenteId,"
										        		+ "a.componente_qta as ComponenteQta,"
										        		+ "a.componente_pos as ComponentePos,"
										        		+ "b.code			as ComponenteCode,"
										        		+ "c.code 			as UnitCode"
										        		+ "from recipes_row as a"
										        		+ "left join components as b"
										        			+ "on a.id_componente = b.id"
										        		+ "left join units as c"
										        			+ "on b.id_unit = c.id"
										        		+ " where a.id_recipe = ?";
        
        preparedStatement = con.prepareStatement(LOAD_RECIPE_ROWS_WITH_DETAILS);
        preparedStatement.setString(1, RecipeId);
        resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
          RecipeRow recipeRow = new RecipeRow();
          
          recipeRow.setId(resultSet.getString("RowId"));
          recipeRow.setId_recipe(resultSet.getString("RecipeId"));
          recipeRow.setComponente_pos(resultSet.getInt("ComponentePos"));
          recipeRow.setComponente_qta(resultSet.getFloat("ComponenteQta"));
          recipeRow.setComponentId(resultSet.getString("ComponenteId"));
          recipeRow.setComponentCode(resultSet.getString("ComponenteCode"));
          recipeRow.setComponentUnitDescription(resultSet.getString("UnitCode"));
        	
          recipe.recipe_row.add(recipeRow);
      }
										        		
										      
        	  
        	
		
	}catch (SQLException e) {
		ConnectionMySQLExceptHandler.printSQLException(e);
	}
	
	
	recipe.comments = CommentsDao.GetCommentsForRecipe(RecipeId);
	
	
	return recipe;
}

public static ArrayList<TopRecipe> GetRecipeListByName (String RecipeName) {
	
	ArrayList<TopRecipe> listFoundRecipe = new ArrayList<>(); 
	ArrayList<String> RecipesIds = GetRecipesIdsByName(RecipeName);
	
	Connection con = ConnectionMysql.getCon();
	
	for(int i=0;i<RecipesIds.size();i++)
	{
		TopRecipe topRecipe = new TopRecipe();
		
			String LOAD_RECIPE_WITH_DETAILS= "select 	a.id 			as RecipeId,"
					   									+" a.name 			as RecipeName,"
					   									+" a.description 	as RecipeDescr, "
					   									+" a.id_user 		as UserId,"
					   									+" c.login	 		as Username,"
					   									+" a.data_creation as DataCreation,"
					   									+" a.id_category 	as CategoryId,"
					   									+" b.code 			as CategoryName"
					   									+" from recipes_header as a"
					   									+" left join categories as b"
					   									+" on a.id_category = b.id"
					   									+" left join users as c"
					   									+" on a.id_user = c.id"
					   									+" where a.id = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(LOAD_RECIPE_WITH_DETAILS);
	        preparedStatement.setString(1, RecipesIds.get(i));
	        
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	        	  topRecipe.setRecipeId(resultSet.getString("RecipeId"));
	        	  topRecipe.setRecipeName(resultSet.getString("RecipeName"));
	        	  topRecipe.setRecipeDescr(resultSet.getString("RecipeDescr"));
	        	  topRecipe.setUserId(resultSet.getString("UserId"));
	        	  topRecipe.setUsername(resultSet.getString("Username"));
	        	  topRecipe.setDataCreation(resultSet.getString("DataCreation"));
	        	  topRecipe.setCategoryId(resultSet.getString("CategoryId"));
	        	  topRecipe.setCategoryName(resultSet.getString("CategoryName"));
	        	  topRecipe.setImgPath(Image.GetUserAvatar(topRecipe.getRecipeId()));
	        	}
	        topRecipe.setRate(RatesDao.GetRateById(topRecipe.getRecipeId()));
	        listFoundRecipe.add(topRecipe);
		} catch (SQLException e) {
			ConnectionMySQLExceptHandler.printSQLException(e);
		}
		
	}
	
	return listFoundRecipe;
}

public static ArrayList<TopRecipe> GetFavouritesRecipes (String userId) {
	
	
	ArrayList<TopRecipe> listFavouritesRecipes = new ArrayList<>(); 
	ArrayList<String> RecipesIds = FavouritesDao.GetFavouritesIds(userId);
	System.out.println(RecipesIds.get(0));
	Connection con = ConnectionMysql.getCon();
	
	for(int i=0;i<RecipesIds.size();i++)
	{
		TopRecipe topRecipe = new TopRecipe();
		
			String LOAD_RECIPE_WITH_DETAILS= "select 	a.id 			as RecipeId,"
					   									+" a.name 			as RecipeName,"
					   									+" a.description 	as RecipeDescr, "
					   									+" a.id_user 		as UserId,"
					   									+" c.login	 		as Username,"
					   									+" a.data_creation as DataCreation,"
					   									+" a.id_category 	as CategoryId,"
					   									+" b.code 			as CategoryName"
					   									+" from recipes_header as a"
					   									+" left join categories as b"
					   									+" on a.id_category = b.id"
					   									+" left join users as c"
					   									+" on a.id_user = c.id"
					   									+" where a.id = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(LOAD_RECIPE_WITH_DETAILS);
	        preparedStatement.setString(1, RecipesIds.get(i));
	        
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	        	  topRecipe.setRecipeId(resultSet.getString("RecipeId"));
	        	  topRecipe.setRecipeName(resultSet.getString("RecipeName"));
	        	  topRecipe.setRecipeDescr(resultSet.getString("RecipeDescr"));
	        	  topRecipe.setUserId(resultSet.getString("UserId"));
	        	  topRecipe.setUsername(resultSet.getString("Username"));
	        	  topRecipe.setDataCreation(resultSet.getString("DataCreation"));
	        	  topRecipe.setCategoryId(resultSet.getString("CategoryId"));
	        	  topRecipe.setCategoryName(resultSet.getString("CategoryName"));
	        	  topRecipe.setImgPath(Image.GetUserAvatar(topRecipe.getRecipeId()));
	        	}
	        topRecipe.setRate(RatesDao.GetRateById(topRecipe.getRecipeId()));
	        listFavouritesRecipes.add(topRecipe);
		} catch (SQLException e) {
			ConnectionMySQLExceptHandler.printSQLException(e);
		}
		
	}
	
	return listFavouritesRecipes;
}

}
