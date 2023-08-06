package com.example.foodmap4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "STORE_NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;
}
