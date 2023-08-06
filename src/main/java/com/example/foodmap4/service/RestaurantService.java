package com.example.foodmap4.service;

import com.example.foodmap4.dto.RestaurantResponse;
import com.example.foodmap4.entity.Restaurant;

public interface RestaurantService {

    public RestaurantResponse queryAll();

    public RestaurantResponse queryRestaurant(String name, String address);

    public String create(Restaurant restaurant);

    public String updateRestaurant(String name, String address, Restaurant restaurant);
}
