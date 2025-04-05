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

@Entity(name = "company")
public class Company {
    @Id
    // auto increment and autore generated value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // indica que el valor es una columna de la tabla
    @Column(name = "com_id", length = 10, nullable = false)
    private int com_id;

    @Column(name = "com_name", length = 100, nullable = false)
    private String com_name;

    @Column(name = "com_code", length = 10, nullable = false)
    private int com_code;

    @OneToMany(mappedBy = "Company", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;

    public Company() {
    }

    public Company(int com_id, String com_name, int com_code, List<Rating> ratings) {
        this.com_id = com_id;
        this.com_name = com_name;
        this.com_code = com_code;
        this.ratings = ratings;
    }

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public int getCom_code() {
        return com_code;
    }

    public void setCom_code(int com_code) {
        this.com_code = com_code;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }


}
