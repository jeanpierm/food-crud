package com.jean.foodapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jean.foodapi.entity.Food;
import com.jean.foodapi.repository.IFoodRepo;
import com.jean.foodapi.service.FoodService;

@CrossOrigin
@RequestMapping("/food")
@RestController
public class FoodController {

	@Autowired
	private FoodService service;

	@GetMapping
	public List<Food> list() {
		return service.list();
	}
	
	@GetMapping("/{id}")
	public Food get(@PathVariable Integer id) {
		return service.get(id);
	}

	@PostMapping
	public void insert(@RequestBody Food food) {
		service.insert(food);
	}
	
	@PutMapping(value = "/{id}")
	public void update(@PathVariable Integer id, @RequestBody Food food) {
		service.update(id, food);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
