package com.trustTarget.trustTarget.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trustTarget.trustTarget.interfaces.Identificable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "trustNivels")
public class TrustNivels implements Identificable<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nivel_id ", length = 10, nullable = false)
    private int nivel_id;

    @Column(name = "nivel_name", length = 30, nullable = false)
    private String nivel_name;


    public TrustNivels() {
    }

    public TrustNivels(int nivel_id, String nivel_name ) {
        this.nivel_id = nivel_id;
        this.nivel_name = nivel_name;
        // TrustTargets = trustTargets;
    }

    @Override
    @JsonIgnore
    public Integer getId() {
        return nivel_id;
    }

    public int getNivel_id() {
        return nivel_id;
    }

    public void setNivel_id(int nivel_id) {
        this.nivel_id = nivel_id;
    }

    public String getNivel_name() {
        return nivel_name;
    }

    public void setNivel_name(String nivel_name) {
        this.nivel_name = nivel_name;
    }

    // public List<TrustTarget> getTrustTargets() {
    //     return TrustTargets;
    // }

    // public void setTrustTargets(List<TrustTarget> trustTargets) {
    //     TrustTargets = trustTargets;
    // }

}
