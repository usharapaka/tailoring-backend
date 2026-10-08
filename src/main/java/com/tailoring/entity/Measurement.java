package com.tailoring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Customer customer;

    private double shoulder;
    private double chest;
    private double waist;
    private double hip;
    private double sleeve;
    private double length;

    private boolean hiddenFromTailor;

    public Measurement() {
    }

    public Measurement(
            Customer customer,
            double shoulder,
            double chest,
            double waist,
            double hip,
            double sleeve,
            double length) {

        this.customer = customer;
        this.shoulder = shoulder;
        this.chest = chest;
        this.waist = waist;
        this.hip = hip;
        this.sleeve = sleeve;
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getShoulder() {
        return shoulder;
    }

    public void setShoulder(double shoulder) {
        this.shoulder = shoulder;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getHip() {
        return hip;
    }

    public void setHip(double hip) {
        this.hip = hip;
    }

    public double getSleeve() {
        return sleeve;
    }

    public void setSleeve(double sleeve) {
        this.sleeve = sleeve;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isHiddenFromTailor() {
        return hiddenFromTailor;
    }

    public void setHiddenFromTailor(boolean hiddenFromTailor) {
        this.hiddenFromTailor = hiddenFromTailor;
    }
}