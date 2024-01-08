package com.solvd.post.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String country;
    private String city;
    private String street;
    private Integer house;
    private Integer apartment;

}
