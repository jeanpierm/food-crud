package com.jean.foodapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jean.foodapi.entity.Food;

@Repository
public interface IFoodRepo extends JpaRepository<Food, Integer>{

}
