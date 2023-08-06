package com.example.foodmap4.service.impl;

import com.example.foodmap4.dto.Datas;
import com.example.foodmap4.dto.RestaurantResponse;
import com.example.foodmap4.entity.RestaurantPK;
import com.example.foodmap4.exception.DataNotFoundException;
import com.example.foodmap4.repository.RestaurantRepository;
import com.example.foodmap4.entity.Restaurant;
import com.example.foodmap4.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponse queryAll() {
        List<Restaurant> list = restaurantRepository.findAll();

        List<Datas> dataList = list.stream()
                .map(restaurant -> new Datas(restaurant.getName(), restaurant.getAddress(), restaurant.getType(), restaurant.getMinCustomerPrice(), restaurant.getMaxCustomerPrice(), restaurant.getOpenTime(), restaurant.getCloseTime()))
                .collect(Collectors.toList());
        RestaurantResponse restaurantResponse = new RestaurantResponse("success", dataList);

        return restaurantResponse;
    }

    @Override
    public RestaurantResponse queryRestaurant(String name, String address) throws DataNotFoundException {
        Restaurant restaurant = restaurantRepository.findById(new RestaurantPK(name, address)).orElse(null);

        if(restaurant == null) {
//            RestaurantResponse restaurantResponse = new RestaurantResponse("fail", null);
//            return restaurantResponse;
            throw new DataNotFoundException();
        }
        else {
            Datas datas = new Datas(restaurant.getName(), restaurant.getAddress(), restaurant.getType(), restaurant.getMinCustomerPrice(), restaurant.getMaxCustomerPrice(), restaurant.getOpenTime(), restaurant.getCloseTime());
            List<Datas> list = new ArrayList<>();
            list.add(datas);
            RestaurantResponse restaurantResponse = new RestaurantResponse("success", list);
            return restaurantResponse;
        }
    }

    @Override
    public String create(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return "新增成功!";
    }

    @Override
    public String updateRestaurant(String name, String address, Restaurant restaurant) {
        Restaurant res = restaurantRepository.findById(new RestaurantPK(name, address)).orElse(null);
        if(res == null) {
            return "查無資料";
        } else {
            res.setType(restaurant.getType());
            res.setMinCustomerPrice(restaurant.getMinCustomerPrice());
            res.setMaxCustomerPrice(restaurant.getMaxCustomerPrice());
            res.setOpenTime(restaurant.getOpenTime());
            res.setCloseTime(restaurant.getCloseTime());

            restaurantRepository.save(res);
            return "更新成功!";
        }
    }
}
