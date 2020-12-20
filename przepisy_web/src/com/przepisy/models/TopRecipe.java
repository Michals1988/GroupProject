package com.przepisy.models;

public class TopRecipe {
	
	private String recipeId;
	private String imgPath;
	private String recipeName;
	private String recipeDescr;
	private String userId;
	private String username;
	private String dataCreation;
	private String categoryId;
	private String categoryName;
	private float rate;
	
	
	public String getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getRecipeDescr() {
		return recipeDescr;
	}
	public void setRecipeDescr(String recipeDescr) {
		this.recipeDescr = recipeDescr;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDataCreation() {
		return dataCreation;
	}
	public void setDataCreation(String dataCreation) {
		this.dataCreation = dataCreation;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}

}
