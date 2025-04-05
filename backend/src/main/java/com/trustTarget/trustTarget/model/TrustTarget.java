package com.trustTarget.trustTarget.model;

import java.util.List;

import org.apache.juli.logging.Log;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "trustTarget")
public class TrustTarget {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="target_id", length = 10, nullable = false)
    private int target_id;

    @OneToOne(mappedBy = "trustTarget")
    private User user;

    @Column(name = "target_create_date", length = 30, nullable = false)
    private String target_create_date;

    @ManyToOne
    @JoinColumn(name = "nivel_id", nullable = false)
    private TrustNivels trustNivel;

    @OneToMany(mappedBy = "trustTarget", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;

    public TrustTarget() {
    }

    public TrustTarget(int target_id, User user, String target_create_date, TrustNivels trustNivel,
            List<Rating> ratings) {
        this.target_id = target_id;
        this.user = user;
        this.target_create_date = target_create_date;
        this.trustNivel = trustNivel;
        this.ratings = ratings;
    }

    public int getTarget_id() {
        return target_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTarget_create_date() {
        return target_create_date;
    }

    public void setTarget_create_date(String target_create_date) {
        this.target_create_date = target_create_date;
    }

    public TrustNivels getTrustNivel() {
        return trustNivel;
    }

    public void setTrustNivel(TrustNivels trustNivel) {
        this.trustNivel = trustNivel;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
