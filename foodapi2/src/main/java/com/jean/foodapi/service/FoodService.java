package com.jean.foodapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jean.foodapi.entity.Food;
import com.jean.foodapi.repository.IFoodRepo;

@Service
public class FoodService {

	@Autowired
	private IFoodRepo repo;

	public List<Food> list() {
		return repo.findAll();
	}
	
	public Food get(Integer id) {
		return repo.findById(id);
	}
	
	public void insert(Food food) {
		repo.save(food);
	}
	
	public void update(Integer id, Food food) {
		repo.update(id, food);
	}
	
	public void delete(Integer id) {
		repo.delete(id);
	}
}
