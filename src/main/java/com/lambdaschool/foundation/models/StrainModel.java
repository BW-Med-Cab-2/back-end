package com.lambdaschool.foundation.models;

public class StrainModel {

    private String strain;

    private long id;

    private String flavors;

    private String effects;

    private String medical;

    private String type;

    private double rating;

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlavors() {
        return flavors;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
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

    @Override
    public String toString() {
        return "StrainModel{" +
                "strain='" + strain + '\'' +
                ", id=" + id +
                ", flavors='" + flavors + '\'' +
                ", effects='" + effects + '\'' +
                ", medical='" + medical + '\'' +
                ", type='" + type + '\'' +
                ", rating=" + rating +
                '}';
    }
}
