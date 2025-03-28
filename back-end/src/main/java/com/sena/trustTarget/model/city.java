package com.sena.trustTarget.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "city")
public class city {
    @Id 
    @Column(name = "city_id", length = 10, nullable = false)
    private int city_id;

    @Column(name = "city_name", length = 100, nullable = false)
    private String city_name;

    @Column(name = "city_code", length = 50, nullable = false)
    private String city_code;
}
