package com.trustTarget.trustTarget.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "city")
public class City {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "city_id", length = 10, nullable = false)
    private int city_id;

    @Column(name = "city_name", length = 100, nullable = false)
    private String city_name;

    @Column(name = "city_code", length = 50, nullable = false)
    private String city_code;

    @OneToMany(mappedBy = "city", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    public City() {
    }

    public City(int city_id, String city_name, String city_code, List<User> users) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.city_code = city_code;
        this.users = users;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
