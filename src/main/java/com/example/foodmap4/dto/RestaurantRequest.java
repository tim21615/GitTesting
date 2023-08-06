package com.example.foodmap4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Addr")
    private String address;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("MinPrice")
    private Integer minCustomerPrice;

    @JsonProperty("MaxPrice")
    private Integer maxCustomerPrice;

    @JsonProperty("OpenTime")
    private Time openTime;

    @JsonProperty("CloseTime")
    private Time closeTime;
}