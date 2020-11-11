package com.przepisy.models;

public class Rates {
	private String id;
	private String id_recipe;
	private int rate;
	private String id_user;
	
	public String getGeneratedId() {
		return java.util.UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_recipe() {
		return id_recipe;
	}
	public void setId_recipe(String id_recipe) {
		this.id_recipe = id_recipe;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
}
