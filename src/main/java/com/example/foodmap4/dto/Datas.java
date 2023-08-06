package com.example.foodmap4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datas {

    @JsonProperty("Restaurant")
    private String name;

    @JsonProperty("Addr")
    private String address;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("MinCustomerPrice")
    private Integer minCustomerPrice;

    @JsonProperty("MaxCustomerPrice")
    private Integer maxCustomerPrice;

    @JsonProperty("Open")
    private Time openTime;

    @JsonProperty("Close")
    private Time closeTime;
}
