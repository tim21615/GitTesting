package com.example.foodmap4.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "restaurant")
@IdClass(value = RestaurantPK.class)
@Data
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "STORE_NAME")
    private String name;

    @Id
    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STORE_TYPE")
    private String type;

    @Column(name = "MIN_CUSTOMER_PRICE")
    private Integer minCustomerPrice;

    @Column(name = "MAX_CUSTOMER_PRICE")
    private Integer maxCustomerPrice;

    @Column(name = "OPEN_TIME")
    private Time openTime;

    @Column(name = "CLOSE_TIME")
    private Time closeTime;
}