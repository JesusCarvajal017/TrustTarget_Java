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


@Entity(name = "identification_type")
public class IdentificationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ident_id", length = 10, nullable = false)
    private int ident_id;

    @Column(name = "ident_name", length = 100, nullable = false)
    private String ident_name;

    @Column(name = "ident_acronym", length = 3, nullable = false)
    private String ident_acronym;

    @OneToMany(mappedBy = "identificationType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    public IdentificationType() {
    }

    public IdentificationType(int ident_id, String ident_name, String ident_acronym, List<User> users) {
        this.ident_id = ident_id;
        this.ident_name = ident_name;
        this.ident_acronym = ident_acronym;
        this.users = users;
    }

    public int getIdent_id() {
        return ident_id;
    }

    public void setIdent_id(int ident_id) {
        this.ident_id = ident_id;
    }

    public String getIdent_name() {
        return ident_name;
    }

    public void setIdent_name(String ident_name) {
        this.ident_name = ident_name;
    }

    public String getIdent_acronym() {
        return ident_acronym;
    }

    public void setIdent_acronym(String ident_acronym) {
        this.ident_acronym = ident_acronym;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }



}
