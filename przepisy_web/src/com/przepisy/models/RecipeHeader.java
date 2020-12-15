package com.przepisy.models;

public class RecipeHeader {
	
	private String id;
	private String name;
	private String description;
	private int active;
	private User user;
	private String data_creation;
	private String video_link;
	private String note;
	private String photo_path;
	private Categories category;	
	
	public String getGeneratedId() {
		return java.util.UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUserId() {
		return user.getId();
	}
	
	public String getUserName() {
		return user.getName();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getData_creation() {
		return data_creation;
	}

	public void setData_creation(String data_creation) {
		this.data_creation = data_creation;
	}

	public String getVideo_link() {
		return video_link;
	}

	public void setVideo_link(String video_link) {
		this.video_link = video_link;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPhoto_path() {
		return photo_path;
	}

	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}

	public String getCategoryId() {
		return category.getId();
	}
	
	public String getCategoryCode() {
		return category.getCode();
	}

	public void setCategory(Categories category) {
		this.category = category;
	}	
}
