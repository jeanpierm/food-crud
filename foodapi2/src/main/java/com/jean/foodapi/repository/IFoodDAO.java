package com.jean.foodapi.repository;

import java.util.List;

import com.jean.foodapi.entity.Food;

public interface IFoodDAO {
	public List<Food> findAll();
	public Food findById(Integer id);
	public void save(Food food);
	public void update(Integer id, Food food);
	public void delete(Integer id);

}
