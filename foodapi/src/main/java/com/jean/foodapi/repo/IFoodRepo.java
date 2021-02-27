package com.jean.foodapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jean.foodapi.model.Food;

@Repository
public interface IFoodRepo extends JpaRepository<Food, Integer>{

}
