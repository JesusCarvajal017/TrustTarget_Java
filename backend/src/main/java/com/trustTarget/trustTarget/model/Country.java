package com.trustTarget.trustTarget.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trustTarget.trustTarget.interfaces.Identificable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "country")
public class Country implements Identificable<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nation_id", length = 10, nullable = false)
    private int nation_id;

    @Column(name = "nation_name", length = 100, nullable = false)
    private String nation_name;
    
    // @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<User> users;

    public Country() {
    }

    public Country(int nation_id, String nation_name) {
        this.nation_id = nation_id;
        this.nation_name = nation_name;
        // this.users = users;
    }

    @Override
    @JsonIgnore
    public Integer getId() {
        return nation_id;
    }

    public int getNation_id() {
        return nation_id;
    }

    public void setNation_id(int nation_id) {
        this.nation_id = nation_id;
    }

    public String getNation_name() {
        return nation_name;
    }

    public void setNation_name(String nation_name) {
        this.nation_name = nation_name;
    }

    // public List<User> getUsers() {
    //     return users;
    // }

    // public void setUsers(List<User> users) {
    //     this.users = users;
    // }

}
