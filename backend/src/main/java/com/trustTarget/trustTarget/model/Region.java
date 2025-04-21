package com.trustTarget.trustTarget.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trustTarget.trustTarget.interfaces.Identificable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "region")
public class Region implements Identificable<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "reg_id", length= 10 , nullable = false)
    private int reg_id;

    @Column(name = "reg_name", length = 100, nullable = false)
    private String reg_name;

    @Column(name = "reg_code", length = 10, nullable = false)
    private String reg_code;

    // @OneToMany(mappedBy = "region", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<User> users;

    public Region() {
    }

    public Region(int reg_id, String reg_name, String reg_code) {
        this.reg_id = reg_id;
        this.reg_name = reg_name;
        this.reg_code = reg_code;
        // this.users = users;
    }

    @Override
    @JsonIgnore
    public Integer getId() {
        return reg_id;
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

    public String getreg_code() {
        return reg_code;
    }

    public void setreg_code(String reg_code) {
        this.reg_code = reg_code;
    }

    // public List<User> getUsers() {
    //     return users;
    // }

    // public void setUsers(List<User> users) {
    //     this.users = users;
    // }
    
}
