package com.przepisy.models;

import java.util.ArrayList;

public class Recipe {
	
	private RecipeHeader recipe_header;
	private ArrayList<RecipeRow> recipe_row;
	
	
	public RecipeHeader getRecipe_header() {
		return recipe_header;
	}
	public void setRecipe_header(RecipeHeader recipe_header) {
		this.recipe_header = recipe_header;
	}
	public ArrayList<RecipeRow> getRecipe_row() {
		return recipe_row;
	}
	public void setRecipe_row(ArrayList<RecipeRow> recipe_row) {
		this.recipe_row = recipe_row;
	}

}
