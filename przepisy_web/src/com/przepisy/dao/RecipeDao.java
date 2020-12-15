package com.przepisy.dao;

import com.przepisy.models.RecipeHeader;

public class RecipeDao {
	
	
	public static void InsertRecipeHeadeR(RecipeHeader recipe_header) {
		
		String QUERY_CODE_EXIST = "select count(id) as xx from units where code = ?"; 
		
		
		
	}

}
