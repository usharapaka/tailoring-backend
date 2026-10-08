package com.tailoring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "tailor_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Tailor tailor;

    private String dressType;

    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private boolean hiddenFromTailor;

    public Appointment() {
    }

    public Appointment(Customer customer, Tailor tailor,
                       String dressType,
                       String appointmentDate, String appointmentTime,
                       String status) {
        this.customer = customer;
        this.tailor = tailor;
        this.dressType = dressType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
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

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

 public boolean isHiddenFromTailor() {
    return hiddenFromTailor;
}

public void setHiddenFromTailor(boolean hiddenFromTailor) {
    this.hiddenFromTailor = hiddenFromTailor;
}

}