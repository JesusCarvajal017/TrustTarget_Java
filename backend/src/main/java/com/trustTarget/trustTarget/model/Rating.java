package com.trustTarget.trustTarget.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "rat_id", length= 10 , nullable = false)
    private int rat_id;

    @ManyToOne
    @JoinColumn(name = "target_id", nullable = false)
    private TrustTarget trustTarget;

    @Column(name = "rat_score", length = 10, nullable = false)
    private int rat_score;

    @Column(name = "rat_comment", length = 100, nullable = false)
    private String rat_comment;

    @Column(name = "rat_create_date", length = 30, nullable = false)
    private String rat_create_date;
    
    @ManyToOne
    @JoinColumn(name = "com_id", nullable = false)
    private Company Company;



    public Rating() {
    }

    public Rating(int rat_id, TrustTarget trustTarget, int rat_score, String rat_comment, String rat_create_date,
    Company Company) {
        this.rat_id = rat_id;
        this.trustTarget = trustTarget;
        this.rat_score = rat_score;
        this.rat_comment = rat_comment;
        this.rat_create_date = rat_create_date;
        this.Company = Company;
    }

    public int getRat_id() {
        return rat_id;
    }

    public void setRat_id(int rat_id) {
        this.rat_id = rat_id;
    }

    public TrustTarget getTrustTarget() {
        return trustTarget;
    }

    public void setTrustTarget(TrustTarget trustTarget) {
        this.trustTarget = trustTarget;
    }

    public int getRat_score() {
        return rat_score;
    }

    public void setRat_score(int rat_score) {
        this.rat_score = rat_score;
    }

    public String getRat_comment() {
        return rat_comment;
    }

    public void setRat_comment(String rat_comment) {
        this.rat_comment = rat_comment;
    }

    public String getRat_create_date() {
        return rat_create_date;
    }

    public void setRat_create_date(String rat_create_date) {
        this.rat_create_date = rat_create_date;
    }

    public Company getRating() {
        return this.Company;
    }

    public void setRating(Company Company) {
        this.Company = Company;
    }


}
