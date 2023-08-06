package com.example.foodmap4.controller;

import com.example.foodmap4.dto.RestaurantRequest;
import com.example.foodmap4.dto.RestaurantResponse;
import com.example.foodmap4.entity.Restaurant;
import com.example.foodmap4.exception.ErrorInputException;
import com.example.foodmap4.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/restaurants")
    public RestaurantResponse queryAll() {

        return restaurantService.queryAll();
    }

    @GetMapping("/restaurants/{name}/{address}")
    public RestaurantResponse queryRestaurant(@PathVariable @NotBlank @Size(max=10) String name, @PathVariable @NotBlank String address) {

        return restaurantService.queryRestaurant(name, address);
    }

    @GetMapping("/test")
    public String abc() {return "tutor ABC2";
    }

    @PostMapping("/restaurants")
    public String create(@RequestBody Restaurant restaurant) {
        return restaurantService.create(restaurant);
    }

    @PutMapping("/restaurants/{name}/{address}")
    public String updateRestaurant(@PathVariable String name, @PathVariable String address, @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(name, address, restaurant);
    }

    @PostMapping("/restaurants/findRestaurant")
    public RestaurantResponse findRestaurant(@RequestBody RestaurantRequest req) {
        Map<String, Object> map = new HashMap<>();
        map = objectMapper.convertValue(req, Map.class);

        System.out.println(map.get("Name"));

        if(map.get("Name")==null ||map.get("Name").toString().isBlank()) {
            System.out.println("他是空的");
        }


        return new RestaurantResponse();
    }


}
