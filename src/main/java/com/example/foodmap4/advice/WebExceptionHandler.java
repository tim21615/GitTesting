package com.example.foodmap4.advice;

import com.example.foodmap4.dto.RestaurantResponse;
import com.example.foodmap4.exception.DataNotFoundException;
import com.example.foodmap4.exception.ErrorInputException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(ErrorInputException.class)
    public RestaurantResponse handleErrorInputException() {
        RestaurantResponse restaurantResponse = new RestaurantResponse();

        restaurantResponse.setMessage("ErrorInputException");
        restaurantResponse.setDatas(null);

        return restaurantResponse;
    }

    @ExceptionHandler(DataNotFoundException.class)
    public RestaurantResponse handleDataNotFoundException() {
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        restaurantResponse.setMessage("DataNotFoundException");
        restaurantResponse.setDatas(null);

        return restaurantResponse;
    }
}
