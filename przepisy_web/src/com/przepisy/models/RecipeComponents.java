package com.przepisy.models;

public class RecipeComponents {
	public String name;
	public String unit;
	public String count;
	public String completeComponent;
	
	public String getCompleteComponent() {
		return count + " " + unit + " " + name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
}
