package com.example.foodmap4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Datas")
    private List<Datas> datas;
}
