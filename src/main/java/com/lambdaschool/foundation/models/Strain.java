package com.lambdaschool.foundation.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "strains")
public class Strain extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // TEMPORARY!!!
    private long id;

    private String name;

    private String flavors; // could make Flavor class

    private String positive; // ^^^^ Positive

    private String medical; // ^^^^ Medical

    private String type;

    private double rating;

    private String flavor; // ^^^^ Flavor

    public Strain() {
    }

    public Strain(String name, String flavors, String positive, String medical, String type, double rating, String flavor) {
        this.name = name;
        this.flavors = flavors;
        this.positive = positive;
        this.medical = medical;
        this.type = type;
        this.rating = rating;
        this.flavor = flavor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavors() {
        return flavors;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Strain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flavors='" + flavors + '\'' +
                ", positive='" + positive + '\'' +
                ", medical='" + medical + '\'' +
                ", type='" + type + '\'' +
                ", rating=" + rating +
                ", flavor='" + flavor + '\'' +
                '}';
    }
}
