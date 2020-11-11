package com.przepisy.models;

public class Components {
	
	private String id;
	private String id_categories;
	private String id_unit;
	private String code;
	private String description;
	private int active;
	
	public String getGeneratedId() {
		return java.util.UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_categories() {
		return id_categories;
	}
	public void setId_categories(String id_categories) {
		this.id_categories = id_categories;
	}
	public String getId_unit() {
		return id_unit;
	}
	public void setId_unit(String id_unit) {
		this.id_unit = id_unit;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}

}
