package com.jean.foodapi.entity;

public class Food {

	private int food_id;
	private String food_name;
	private int food_stock;
	private double food_price;

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public int getFood_stock() {
		return food_stock;
	}

	public void setFood_stock(int food_stock) {
		this.food_stock = food_stock;
	}

	public double getFood_price() {
		return food_price;
	}

	public void setFood_price(double food_price) {
		this.food_price = food_price;
	}

}
