package com.trustTarget.trustTarget.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "user_set")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", length= 10 , nullable = false)
    private Long user_id;

    @Column(name = "user_names", length = 150, nullable = false)
    private String user_names;

    @Column(name = "user_first_surname", length = 150, nullable = false)
    private String user_first_surname;

    @Column(name = "user_second_surname", length = 150, nullable = true)
    private String user_second_surname;

    @Column(name = "user_num_ident", length = 20, nullable = false)
    private int user_num_ident;

    @ManyToOne
    @JoinColumn(name = "ident_id", nullable = false)
    private IdentificationType identificationType;

    @ManyToOne
    @JoinColumn(name = "prof_id", nullable = false)
    private Profession profession;

    @ManyToOne
    @JoinColumn(name = "nation_id", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "reg_id", nullable = false)
    private Region region;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "target_id", referencedColumnName = "target_id", unique = true)
    private TrustTarget trustTarget;

    public User() {
    }

    public User(Long user_id, String user_names, String user_first_surname, String user_second_surname,
            int user_num_ident, IdentificationType identificationType, Profession profession, Country country,
            City city, Region region, TrustTarget trustTarget) {
        this.user_id = user_id;
        this.user_names = user_names;
        this.user_first_surname = user_first_surname;
        this.user_second_surname = user_second_surname;
        this.user_num_ident = user_num_ident;
        this.identificationType = identificationType;
        this.profession = profession;
        this.country = country;
        this.city = city;
        this.region = region;
        this.trustTarget = trustTarget;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_names() {
        return user_names;
    }

    public void setUser_names(String user_names) {
        this.user_names = user_names;
    }

    public String getUser_first_surname() {
        return user_first_surname;
    }

    public void setUser_first_surname(String user_first_surname) {
        this.user_first_surname = user_first_surname;
    }

    public String getUser_second_surname() {
        return user_second_surname;
    }

    public void setUser_second_surname(String user_second_surname) {
        this.user_second_surname = user_second_surname;
    }

    public int getUser_num_ident() {
        return user_num_ident;
    }

    public void setUser_num_ident(int user_num_ident) {
        this.user_num_ident = user_num_ident;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public TrustTarget getTrustTarget() {
        return trustTarget;
    }

    public void setTrustTarget(TrustTarget trustTarget) {
        this.trustTarget = trustTarget;
    }
}
