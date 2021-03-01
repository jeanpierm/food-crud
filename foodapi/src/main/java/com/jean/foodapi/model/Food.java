package com.jean.foodapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Food {

	@Id
	@GeneratedValue
	private int food_id;
	@Column(length = 50)
	private String food_name;
	@Column
	private int food_stock;
	@Column
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
