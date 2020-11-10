package com.przepisy.models;

public class Premium {
	private String id;
	private String id_user;
	private String day_start;
	private String day_end;
	private int level;
	
	public Premium() {
		this.level =0;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getDay_start() {
		return day_start;
	}
	public void setDay_start(String day_start) {
		this.day_start = day_start;
	}
	public String getDay_end() {
		return day_end;
	}
	public void setDay_end(String day_end) {
		this.day_end = day_end;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
