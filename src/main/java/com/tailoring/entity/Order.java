package com.tailoring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "tailor_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Tailor tailor;

    private String dressType;
    private String status;
    private Double price;

    private boolean hiddenFromTailor;

    public Order() {
    }

    public Order(Customer customer,
                 Tailor tailor,
                 String dressType,
                 String status,
                 Double price) {

        this.customer = customer;
        this.tailor = tailor;
        this.dressType = dressType;
        this.status = status;
        this.price = price;
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

    public Tailor getTailor() {
        return tailor;
    }

    public void setTailor(Tailor tailor) {
        this.tailor = tailor;
    }

    public String getDressType() {
        return dressType;
    }

    public void setDressType(String dressType) {
        this.dressType = dressType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isHiddenFromTailor() {
        return hiddenFromTailor;
    }

    public void setHiddenFromTailor(boolean hiddenFromTailor) {
        this.hiddenFromTailor = hiddenFromTailor;
    }
}