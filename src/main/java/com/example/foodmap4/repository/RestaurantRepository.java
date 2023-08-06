package com.example.foodmap4.repository;

import com.example.foodmap4.entity.Restaurant;
import com.example.foodmap4.entity.RestaurantPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, RestaurantPK> {
}
