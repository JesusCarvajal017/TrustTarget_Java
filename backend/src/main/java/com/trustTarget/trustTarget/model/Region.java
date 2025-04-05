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

@Entity(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "reg_id", length= 10 , nullable = false)
    private int reg_id;

    @Column(name = "reg_name", length = 100, nullable = false)
    private String reg_name;

    @Column(name = "reg_description", length = 10, nullable = false)
    private String reg_description;

    @OneToMany(mappedBy = "region", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    public Region() {
    }

    public Region(int reg_id, String reg_name, String reg_description, List<User> users) {
        this.reg_id = reg_id;
        this.reg_name = reg_name;
        this.reg_description = reg_description;
        this.users = users;
    }

    public int getReg_id() {
        return reg_id;
    }

    public void setReg_id(int reg_id) {
        this.reg_id = reg_id;
    }

    public String getReg_name() {
        return reg_name;
    }

    public void setReg_name(String reg_name) {
        this.reg_name = reg_name;
    }

    public String getReg_description() {
        return reg_description;
    }

    public void setReg_description(String reg_description) {
        this.reg_description = reg_description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
}
