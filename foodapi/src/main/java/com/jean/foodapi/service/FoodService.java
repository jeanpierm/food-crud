package com.jean.foodapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.foodapi.entity.Food;
import com.jean.foodapi.repository.IFoodRepo;

@Service
public class FoodService {

	@Autowired
	private IFoodRepo repo;

	public List<Food> list() {
		return repo.findAll();
	}
	
	public Optional<Food> get(Integer id) {
		return repo.findById(id);
	}
	
	public void insert(Food food) {
		repo.save(food);
	}
	
	public void update(Food food) {
		repo.save(food);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
