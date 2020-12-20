package com.przepisy.models;

public class RecipeRow {
	
	private String id;
	private String id_recipe;
	private Components component = new Components();
	private int componente_pos;
	private float componente_qta;
	
	
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
	public String getComponentId() {
		return component.getId();
	}
	
	public void setComponentId(String id) {
		this.component.setId(id);
	}
	
	public void setComponentCode(String code) {
		this.component.setCode(code);
	}
	
	public void setComponentUnitDescription(String unit_descr) {
		this.component.setUnit_descr(unit_descr);
	}
	
	public void setComponent(Components component) {
		this.component = component;
	}
	public int getComponente_pos() {
		return componente_pos;
	}
	public void setComponente_pos(int componente_pos) {
		this.componente_pos = componente_pos;
	}
	public float getComponente_qta() {
		return componente_qta;
	}
	public void setComponente_qta(float componente_qta) {
		this.componente_qta = componente_qta;
	}
	

}
