package com.jean.foodapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public Optional<Food> get(@PathVariable Integer id) {
		return repo.findById(id);
	}
	
	public void insert(@RequestBody Food food) {
		repo.save(food);
	}
	
	public void update(@RequestBody Food food) {
		repo.save(food);
	}
	
	public void delete(@PathVariable Integer id) {
		repo.deleteById(id);
	}
}
