package com.trustTarget.trustTarget.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trustTarget.trustTarget.interfaces.Identificable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "profession")
public class Profession implements Identificable<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "prof_id", length= 10 , nullable = false)
    private int prof_id;

    @Column(name = "prof_name", length = 100, nullable = false)
    private String prof_name;

    // @OneToMany(mappedBy = "profession", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<User> users;

    public Profession() {
    }

    public Profession(int prof_id, String prof_name) {
        this.prof_id = prof_id;
        this.prof_name = prof_name;
        // this.users = users;
    }

    @Override
    @JsonIgnore
    public Integer getId() {
        return prof_id;
    }

    public int getProf_id() {
        return prof_id;
    }

    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }

    public String getProf_name() {
        return prof_name;
    }

    public void setProf_name(String prof_name) {
        this.prof_name = prof_name;
    }

    // public List<User> getUsers() {
    //     return users;
    // }

    // public void setUsers(List<User> users) {
    //     this.users = users;
    // }

}
