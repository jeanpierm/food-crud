package com.jean.foodapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jean.foodapi.model.Food;
import com.jean.foodapi.repo.IFoodRepo;

@RequestMapping("/food")
@RestController
public class FoodController {

	@Autowired
	private IFoodRepo repo;

	@GetMapping
	public List<Food> list() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Food> get(@PathVariable Integer id) {
		return repo.findById(id);
	}
	
	@PostMapping
	public void insert(@RequestBody Food food) {
		repo.save(food);
	}
	
	@PutMapping
	public void update(@RequestBody Food food) {
		repo.save(food);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
