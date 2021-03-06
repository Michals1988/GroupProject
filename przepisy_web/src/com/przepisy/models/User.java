package com.przepisy.models;

import com.przepisy.security.Hash256;

public class User {
	private String id;
	private String login;
	private String password;
	private String name;
	private String email;
	private boolean active;
	private boolean admin;
	
	public User() {
		this.active = true;
		this.admin = false;
	}	
	public String getGeneratedId() {
		return java.util.UUID.randomUUID().toString();
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public String getPasswordHashed() {
		return Hash256.HashPassword(this.password);
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
